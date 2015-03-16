/*
* Copyright 2015 Weijie Sun
* Copyright 2015 Youdong Ma
* Copyright 2015 Yufei Zhang
* Copyright 2015 Chenrui Lei
* Copyright 2015 Yang Zhang
* Copyright 2015 Ji Yang
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package ca.ualberta.cs.cmput301w15t04team04project.test;


import ca.ualberta.cs.cmput301w15t04team04project.MyClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MyLocalClaimListController;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.test.ActivityInstrumentationTestCase2;

public class Claims_Offline_Test extends ActivityInstrumentationTestCase2<MyClaimActivity> {
	public Claims_Offline_Test(Class<MyClaimActivity> activityClass) {
		super(activityClass);
		// TODO Auto-generated constructor stub
	}

	ClaimList claimlist = MyLocalClaimListController.getClaimList();
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
		MyLocalClaimListController.SaveToOnline();
		claimListFromOnline = MyLocalClaimListController.LoadFromOnline();
		assertEquals("was ClaimList succefully written to db?",
				claimlist.toString(), claimListFromOnline.toString());
	}

	// http://stackoverflow.com/questions/4238921/detect-whether-there-is-an-internet-connection-available-on-android
	public boolean isNetworkAvailable() {
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
}
