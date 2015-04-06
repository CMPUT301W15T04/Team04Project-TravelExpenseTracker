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
import ca.ualberta.cs.cmput301w15t04team04project.MyClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.SignInManager;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.ClaimListAdapter;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
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
public class US08_02_01 extends ActivityInstrumentationTestCase2<MyClaimActivity>{
	
	private ClaimListAdapter claimAdapter; 
	private MyClaimActivity thisActivity;
	private User claimiant;
	
	/**
	* The Approver_02_Test method is extend the super class MainActivity
	*
	* @author  Weijie Sun
	* @version 1.0
	* @since   2015-03-08
	*/
	public US08_02_01(Class<MyClaimActivity> activityClass) {
		super(activityClass);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		claimiant = new User("testclaimiant");

		SignInManager.saveInFile(getActivity(), claimiant);
		thisActivity = (MyClaimActivity) getActivity();
		//manager = new MyLocalClaimListManager();
		//claim = manager.loadClaimList(getActivity()).getClaimArrayList().get(0);
	}

	/**
	* The sortedClaimListTest method tests if the listview equals and show by ordered
	*
	* @author  Weijie Sun
	* @version 1.0
	* @since   2015-03-08
	*/
	protected void sortedClaimListTest() {
		SignInManager.saveInFile(getActivity(), claimiant);
		thisActivity = (MyClaimActivity) getActivity();
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.getClaimArrayList().add(AClaim);
		testClaimList.getClaimArrayList().add(BClaim);
		testClaimList.getClaimArrayList().add(CClaim);
		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		AClaim.setClaim("1");

		Date Adate = new Date();
		Adate.setYear(2013);
		Date Bdate = new Date();
		Bdate.setYear(2014);
		Date Cdate = new Date();
		Cdate.setYear(2015);
		
		AClaim.setStartDate(Adate);
		BClaim.setStartDate(Bdate);
		CClaim.setStartDate(Cdate);
		ListView claimlistview = (ListView) getActivity().findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.myClaimsListView); //listView
		//some problem here
		claimAdapter = new ClaimListAdapter(getActivity(), 0, testClaimList.getClaimArrayList());
		View view1 = claimAdapter.getView(0, null, null);
		View view2 = claimAdapter.getView(1, null, null);
		View view3 = claimAdapter.getView(2, null, null);
		ListView listview = (ListView) getActivity().findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.myClaimsListView);  
		
		//
		assertEquals("index 0 equals", listview.getChildAt(0).equals(view1));
		assertEquals("index 1 equals", listview.getChildAt(1).equals(view2));
		assertEquals("index 2 equals", listview.getChildAt(2).equals(view3));

		
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
