package com.acompany.photoi;

import android.app.IntentService;
import android.content.ContentProviderClient;
import android.content.Intent;
import android.content.Context;
import android.database.Cursor;
import android.os.RemoteException;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class UsersService extends IntentService {

    private static final String ACTION_LOGIN = "com.acompany.photoi.extra.LOGIN";

    private static final String USERNAME = "com.acompany.photoi.extra.USERNAME";
    private static final String PASSWORD = "com.acompany.photoi.extra.PASSWORD";

    public static final String PASSWORD_MATCH_PARAM = "com.acompany.photoi.extra.PASSWORD_MATCH";


    public UsersService() {
        super("UsersService");
    }


    public static void startActionLogin(Context context, String param1, String param2) {
        Intent intent = new Intent(context, UsersService.class);
        intent.setAction(ACTION_LOGIN);
        intent.putExtra(USERNAME, param1);
        intent.putExtra(PASSWORD, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_LOGIN.equals(action)) {
                final String param1 = intent.getStringExtra(USERNAME);
                final String param2 = intent.getStringExtra(PASSWORD);
                handleActionLogin(param1, param2);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionLogin(String param1, String param2) {


        String username = param1.toString();
        String password = param2.toString();

        ContentProviderClient cp = getContentResolver().acquireContentProviderClient(UsersContentProvider.CONTENT_URI);
        Cursor cursor = null;
        boolean passwordMatch = false;

        try {


            // we first check locally for a match

            cursor = cp.query(UsersContentProvider.CONTENT_URI,new String[]{PhotoiSQLiteManager.USER_DATA_COLUMN},null,new String[]{username},null);

            cursor.moveToFirst();


            for (int i=0; i < cursor.getCount();i++) {

                String credential = cursor.getString(0);

                String[] pieces = credential.split(":");
                if (pieces[0].equals(username) && pieces[1].equals(password)) {

                    passwordMatch = true;
                    break;

                }

                cursor.moveToNext();

            }

            cursor.moveToFirst();


        } catch (RemoteException e) {

            e.printStackTrace();

        } finally {


            if (cursor != null)
                cursor.close();
            if (cp != null)
                cp.release();


            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(LoginActivity.PasswordMatchResponseReceiver.ACTION_RESP);
            broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
            broadcastIntent.putExtra(PASSWORD_MATCH_PARAM, passwordMatch);
            sendBroadcast(broadcastIntent);

        }
    }
}
