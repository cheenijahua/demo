package exmaple.wanqu.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Administrator on 2016/11/14.
 */
public class ConnectionUtils {
    public static boolean isConnection(Context context){
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo==null){
            return false;
        }
        return networkInfo.isConnected();
    }
}
