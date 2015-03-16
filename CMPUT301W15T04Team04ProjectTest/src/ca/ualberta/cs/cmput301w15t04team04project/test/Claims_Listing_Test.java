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
import android.widget.ListView;
import ca.ualberta.cs.cmput301w15t04team04project.FragmentMoments;
import ca.ualberta.cs.cmput301w15t04team04project.FragmentProfile;
import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MyLocalClaimListController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MyLocalClaimListController2;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;


public class Claims_Listing_Test extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity thisActivity;
	private FragmentMoments momentfragment;
    private MyLocalClaimListController2 controller;
	private Claim Aclaim;
	private Claim Bclaim;

	public Claims_Listing_Test() {
		super(MainActivity.class);
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
		thisActivity = (MainActivity) getActivity();
		momentfragment = (FragmentMoments) thisActivity.fragments.get(1);
		
	}
	
	@SuppressWarnings("deprecation")
	public void testPreConditions() {
        assertNotNull(thisActivity);
        assertNotNull(momentfragment);
        Date date1 = new Date();
        date1.setYear(1999);
        Claim Aclaim = new Claim("Aclaim");
        Aclaim.setClaim("Test");
        Aclaim.setStatus("Submitted");
        Aclaim.setStartDate(date1);
        Date date2 = new Date();
        date2.setYear(2000);
        Claim Bclaim = new Claim("Bclaim");
        Bclaim.setStatus("Submitted");
        Bclaim.setClaim("Test");
        Claim Cclaim = new Claim("Cclaim");
        Cclaim.setStatus("Proceed");
        controller.addClaim(Aclaim);
        controller.addClaim(Bclaim);
        controller.addClaim(Cclaim);
    }


	// US02.01.01
	public void testListClaims() {
		ListView claimlistview = (ListView) thisActivity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.myClaimsListView); //listView
		assertEquals("index 0 equals", claimlistview.getChildAt(0).equals(Aclaim));
		
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
