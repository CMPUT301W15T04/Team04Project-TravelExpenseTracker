//from http://www.programcreek.com/java-api-examples/index.php?api=android.net.ConnectivityManager
package ca.ualberta.cs.cmput301w15t04team04project.network;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 *
 */
public class InternetChecker{
	private Context context;

	public InternetChecker(Context context) {
        this.context = context;
    }
	/**
	 * Check if the device connects the Internet
	 * 
	 * @return true if the Internet is connected; else return false.
	 */
	public final boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo wifiNetwork = connectivityManager
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (wifiNetwork != null && wifiNetwork.isConnected()) {
			return true;
		}

		NetworkInfo mobileNetwork = connectivityManager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if (mobileNetwork != null && mobileNetwork.isConnected()) {
			return true;
		}
		NetworkInfo activeNetworkInfo = connectivityManager
				.getActiveNetworkInfo();
		if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
			return true;
		} else {
			return false;
		}

	}

}
