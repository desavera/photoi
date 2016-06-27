package com.acompany.photoi;

import android.app.IntentService;
import android.content.ContentProviderClient;
import android.content.Intent;
import android.content.Context;
import android.database.Cursor;
import android.os.RemoteException;
import android.provider.SyncStateContract;
import android.support.v4.content.LocalBroadcastManager;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class UserLoginService extends IntentService {

    private static final String ACTION_LOGIN = "com.acompany.photoi.extra.LOGIN";

    private static final String EMAIL = "com.acompany.photoi.extra.EMAIL";
    private static final String PASSWORD = "com.acompany.photoi.extra.PASSWORD";

    public UserLoginService() {
        super("UserLoginService");
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionLogin(Context context, String param1, String param2) {
        Intent intent = new Intent(context, UserLoginService.class);
        intent.setAction(ACTION_LOGIN);
        intent.putExtra(EMAIL, param1);
        intent.putExtra(PASSWORD, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_LOGIN.equals(action)) {
                final String param1 = intent.getStringExtra(EMAIL);
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


        String email = param1.toUpperCase();
        String password = param2.toString();


        System.out.println("DID IT !");

        ContentProviderClient cp = getContentResolver().acquireContentProviderClient(UsersContentProviderMock.CONTENT_URI);
        Cursor cursor = null;
        boolean passwordMatch = false;

        try {

            cursor = cp.query(UsersContentProviderMock.CONTENT_URI,null,null,null,null);

            cursor.moveToFirst();


            for (int i=0; i < cursor.getCount();i++) {

                String credential = cursor.getString(0);

                        String[] pieces = credential.split(":");
                if (pieces[0].equals(email) && pieces[1].equals(password)) {

                    passwordMatch = true;
                    break;

                }

                cursor.moveToNext();

            }

        } catch (RemoteException e) {

            e.printStackTrace();

        } finally {


            if (cursor != null)
                cursor.close();
            if (cp != null)
                cp.release();

/*            if (passwordMatch) {

                Intent localIntent =
                        new Intent(SyncStateContract.Constants.BROADCAST_ACTION)
                                // Puts the status into the Intent
                                .putExtra(SyncStateContract.Constants.EXTENDED_DATA_STATUS, status);
                // Broadcasts the Intent to receivers in this app.
                LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);


            }*/

        }
    }
}
