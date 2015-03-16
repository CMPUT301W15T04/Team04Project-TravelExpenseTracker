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

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import ca.ualberta.cs.cmput301w15t04team04project.FragmentMoments;
import ca.ualberta.cs.cmput301w15t04team04project.FragmentProfile;
import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.MyClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.R;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.ClaimListAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.ItemListAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MyLocalClaimListController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MyLocalClaimListController2;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;


public class Claims_Listing_Test extends ActivityInstrumentationTestCase2<MyClaimActivity> {
    private MyClaimActivity thisActivity;
    private MyLocalClaimListController2 controller;
	private Claim Aclaim;
	private Claim Bclaim;
	private Claim Cclaim;

	private ClaimListAdapter claimAdapter; 
	private ClaimList claimList;
	private int mode;
	
	public Claims_Listing_Test() {
		super(MyClaimActivity.class);
		// TODO Auto-generated constructor stub
	}
	// US01.03.01
	public void testViewClaims() {
		ListView claimlistview = (ListView) thisActivity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.myClaimsListView); //listView
		assertEquals("index 0 equals", claimlistview.getChildAt(0).equals(Aclaim));
		
	}
	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		
		thisActivity = (MyClaimActivity) getActivity();
		MyClaimActivity.mode = 1;
	}
	
	@SuppressWarnings("deprecation")
	public void testPreConditions() {
        assertNotNull(thisActivity);
        Date date1 = new Date();
        date1.setYear(1999);
        Aclaim = new Claim("Aclaim");
        Aclaim.setClaim("Test");
        Aclaim.setStatus("Submitted");
        Aclaim.setStartDate(date1);
        Date date2 = new Date();
        date2.setYear(2000);
        Bclaim = new Claim("Bclaim");
        Bclaim.setStatus("Submitted");
        Bclaim.setClaim("Test");
        Cclaim = new Claim("Cclaim");
        Cclaim.setStatus("Proceed");
        controller.addClaim(Aclaim);
        controller.addClaim(Bclaim);
        controller.addClaim(Cclaim);
        claimList.getClaimArrayList().add(Aclaim);
        claimList.getClaimArrayList().add(Bclaim);
        claimList.getClaimArrayList().add(Cclaim);
    }


	// US02.01.01
	public void testListClaims() {
		ListView claimlistview = (ListView) thisActivity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.myClaimsListView); //listView
		//some problem here
		claimAdapter = new ClaimListAdapter(thisActivity, 0, claimList.getClaimArrayList());
		View view = claimAdapter.getView(0, null, null);
		TextView claimState = (TextView) view
				.findViewById(R.id.claimState);
		TextView startYear = (TextView) view
				.findViewById(R.id.singleClaimStartYearTextView);
		
		assertNotNull("View is null. ", view);
	    assertNotNull("claim status is null. ", claimState);
	    assertNotNull("start year is null. ", startYear);
	    assertEquals("status equal", claimState.getText().toString(), Aclaim.getStatus());
		//assertEquals("index 0 equals", claimlistview.getChildAt(0).equals(Aclaim));
	}
	
	// US02.02.01
	public void testSortClaimList() {
		ListView claimlistview = (ListView) thisActivity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.myClaimsListView); //listView

		assertEquals("index 0 equals", claimlistview.getChildAt(0).equals(Bclaim));
		assertEquals("index 1 equals", claimlistview.getChildAt(1).equals(Aclaim));
		
	}
	// US01.05.01
		public void testCantDeleteClaim() {
			controller.deleteClaim(1);
			controller.deleteClaim(0);
			controller.deleteClaim(2);
			assertEquals("No claims", MyLocalClaimListController2.getClaimList()
					.size(), 0);
		}




}
