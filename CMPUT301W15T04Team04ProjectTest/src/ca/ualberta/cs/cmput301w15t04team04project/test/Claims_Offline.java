package ca.ualberta.cs.cmput301w15t04team04project.test;

import ca.ualberta.cs.cmput301w15t04team04project.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.Controller;
import ca.ualberta.cs.cmput301w15t04team04project.Manager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.test.ActivityInstrumentationTestCase2;

public class Claims_Offline extends ActivityInstrumentationTestCase2<T> {
	ClaimList claimlist = Manager.getClaimList();
	ConnectivityManager connectManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	NetworkInfo activeNetworkInfo = connectManager
			.getActiveNetworkInfo();
	protected void setUp() throws Exception {
		super.setUp();
		
	}
	
	/*
	 *  US09.01.01
	 */
	
	public void testReadOnlineInfo() {
		
		ClaimList claimListFromOnline;
		assertTrue(isNetworkAvailable());
		Controller.SaveToOnline();
		claimListFromOnline = Controller.LoadFromOnline();
		assertEquals("was ClaimList succefully written to db?",
				claimlist.toString(), claimListFromOnline.toString());
	}

	// http://stackoverflow.com/questions/4238921/detect-whether-there-is-an-internet-connection-available-on-android
	public boolean isNetworkAvailable() {
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
}
