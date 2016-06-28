package com.acompany.photoi;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.acompany.photoi.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;



public class UsersContentProvider extends ContentProvider {


    private static final String TAG = "UsersContentProvider";

    public static final String PROVIDER_NAME = "com.acompany.photoi.userscontentprovider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME);

    public static final String SERVER_URL = "http://192.168.1.105:8080";



    private PhotoiSQLiteManager dbManager;
    private SQLiteDatabase database;


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        database = dbManager.getWritableDatabase();
        long rid = database.insert(PhotoiSQLiteManager.USER_TABLE,null,values);
        return Uri.withAppendedPath(CONTENT_URI,new Long(rid).toString());
    }

    @Override
    public boolean onCreate() {

        dbManager = new PhotoiSQLiteManager(getContext());
        database = dbManager.getReadableDatabase();

        if (database

                != null) {

            ContentValues values = new ContentValues();
            values.put(PhotoiSQLiteManager.USER_DATA_COLUMN,UsersContentProviderMock.DUMMY_CREDENTIALS[0]);

            insert(CONTENT_URI,values);

            return true;
        }

        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        if ((selectionArgs.length == 0) || (projection[0].compareTo(PhotoiSQLiteManager.USER_DATA_COLUMN) != 0)) {

            // full userdata fetch from local database
            database = dbManager.getReadableDatabase();
            return database.rawQuery("SELECT USERDATA FROM USER",null);

            //TODO: add /users for remote full fetch

        }

        String username = selectionArgs[0];
        // userdata fetch from local database
        database = dbManager.getReadableDatabase();
        Cursor localResult = database.rawQuery("SELECT USERDATA FROM USER WHERE USERDATA LIKE " + "\'" + username + ':' + "%'",null);


        if (localResult.getCount() != 0) {

            return localResult;

        } else {

            // fetches remote service
            User user = fetchUser(username);

            MatrixCursor remoteResult = new MatrixCursor(new String[]{"userdata"});
            if (user != null) {

                remoteResult.addRow(new String[]{user.getUsername() + ':' + user.getPassword()});
            }

            return remoteResult;
        }

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    protected User fetchUser(String username) {

        try {
            //Create an HTTP client
            HttpClient client = new DefaultHttpClient();
            HttpGet get = new HttpGet(SERVER_URL + "/users/" + username);

            //Perform the request and check the status code
            HttpResponse response = client.execute(get);
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();

                try {
                    //Read the server response and attempt to parse it as JSON
                    Reader reader = new InputStreamReader(content);

                    GsonBuilder gsonBuilder = new GsonBuilder();
                    gsonBuilder.setDateFormat("M/d/yy hh:mm a");
                    Gson gson = gsonBuilder.create();
                    User user = gson.fromJson(reader, User.class);
                    content.close();

                    return user;

                } catch (Exception ex) {
                    Log.e(TAG, "Failed to parse JSON due to: " + ex);

                }
            } else {
                Log.e(TAG, "Server responded with status code: " + statusLine.getStatusCode());
            }
        } catch(Exception ex) {
            Log.e(TAG, "Failed to send HTTP POST request due to: " + ex);
        }
        return null;
    }
}
