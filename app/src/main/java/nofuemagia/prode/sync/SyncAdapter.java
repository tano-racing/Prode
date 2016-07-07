package nofuemagia.prode.sync;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;

/**
 * Created by Tano on 02/07/2016.
 */
public class SyncAdapter extends AbstractThreadedSyncAdapter {

    public static final String QUE = "QUE";
    public static final String OPERACION = "OPERACION";
    public static final String ID = "ID";

    ContentResolver mContentResolver;

    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
        mContentResolver = context.getContentResolver();
    }

    public SyncAdapter(Context context, boolean autoInitialize, boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);
        mContentResolver = context.getContentResolver();
    }

    @Override
    public void onPerformSync(Account account, Bundle bundle, String s, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        String que = bundle.getString(QUE);
        String operacion = bundle.getString(OPERACION);

        System.out.println(String.format("Iniciando %s %s", que, operacion));
    }
}