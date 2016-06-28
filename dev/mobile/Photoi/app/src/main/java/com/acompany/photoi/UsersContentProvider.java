package com.acompany.photoi;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import io.swagger.client.ApiException;
import io.swagger.client.api.UserApi;
import io.swagger.client.model.User;

public class UsersContentProvider extends ContentProvider {

    public static final String PROVIDER_NAME = "com.acompany.photoi.userscontentprovider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME);


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
            UserApi api = new UserApi();
            try {
                User user = api.getUserByName(username);
                MatrixCursor remoteResult = new MatrixCursor(new String[]{"userdata"});
                remoteResult.addRow(new String[]{user.getUsername() + ':' + user.getPassword()});

                return remoteResult;

            } catch (TimeoutException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ApiException e) {
                e.printStackTrace();
            }

        }

        return null;


    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
