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

import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.ListView;
/**
* The Approver_02_Test method is extend the super class MainActivity
*
* @author  Weijie Sun
* @version 1.0
* @since   2015-03-09
*/
public class Approver_02_Test extends ActivityInstrumentationTestCase2<MainActivity>{
	/**
	* The Approver_02_Test method is extend the super class MainActivity
	*
	* @author  Weijie Sun
	* @version 1.0
	* @since   2015-03-08
	*/
	public Approver_02_Test(Class<MainActivity> activityClass) {
		super(activityClass);
		// TODO Auto-generated constructor stub
	}

	
	/**
	* The sortedClaimListTest method tests if the listview equals and show by ordered
	*
	* @author  Weijie Sun
	* @version 1.0
	* @since   2015-03-08
	*/
	protected void sortedClaimListTest() {
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		AClaim.setClaimName("1");

		Date Adate = new Date();
		Adate.setYear(2013);
		Date Bdate = new Date();
		Bdate.setYear(2014);
		Date Cdate = new Date();
		Cdate.setYear(2015);
		
		AClaim.setStartDate(Adate);
		BClaim.setStartDate(Bdate);
		CClaim.setStartDate(Cdate);
		
		ListView listview = (ListView) findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.MainClaimListView);  
		
		assertEquals("index 0 equals", listview.getChildAt(0).equals(AClaim));
		assertEquals("index 1 equals", listview.getChildAt(1).equals(BClaim));
		assertEquals("index 2 equals", listview.getChildAt(2).equals(CClaim));

		
/*		assertTrue("first item is true", testClaimList.getSubmittedClaimList()
				.get(1).getItemList().get(0).equals(itemB));
		assertTrue("first item is true", testClaimList.getSubmittedClaimList()
				.get(0).getItemList().get(0).equals(itemA));

		testOpenNextActivity(MainActivity, AddEditClaimActivity);
		View v = activity.getWindow().getDecorView()
				.findViewById(android.R.id.MainClaimListView);
		assertTrue("Toast is shown", v.isShown());
*/
		
		
	}

	
}
