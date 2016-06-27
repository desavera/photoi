package com.acompany.photoi;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class UsersContentProvider extends ContentProvider {

    public static final String PROVIDER_NAME = "com.acompany.photoi.userscontentprovider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME);


    private PhotoiSQLiteManager dbManager;
    private SQLiteDatabase database;


    public UsersContentProvider() {
    }

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

        database = dbManager.getReadableDatabase();
        return database.rawQuery("SELECT USERDATA FROM USER",null);


    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
