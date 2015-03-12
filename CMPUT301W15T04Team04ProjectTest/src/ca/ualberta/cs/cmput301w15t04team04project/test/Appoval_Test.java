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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Instrumentation.ActivityMonitor;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemLongClickListener;

import junit.framework.TestCase;

import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.SignInActivity;
//import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Destination;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;

/**
* The Approver_test Mainly test the US08
*
* @param Activity is SignInActivity based on the use case precondition
* @param claimList is the data base that used to test.
* @author  Weijie Sun
* @version 1.0
* @since   2015-03-08
*/

public class Appoval_Test extends ActivityInstrumentationTestCase2<SignInActivity>   {
	public Appoval_Test(Class<SignInActivity> activityClass) {
		super(activityClass);
		// TODO Auto-generated constructor stub
	}

	

	
	
	//US08.01.01 and US08.04.01
	protected void viewSubmittedClaimsDetailsTest() {
		
		String tname = "claimant_test";
		User claimiant = new User(tname);
		
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		AClaim.setClaim("1");
		assertTrue("name is equal", testClaimList.getSubmittedClaimList()
				.get(0).getClaim().toString().equals("1"));
		Date date = new Date();
		AClaim.setStartDate(date);
		assertTrue("starting date is equal", testClaimList
				.getSubmittedClaimList().get(0).getStartDate().equals(date));
		Date endDate = new Date();
		AClaim.setEndDate(endDate);
		assertTrue("ending date is equal", testClaimList
				.getSubmittedClaimList().get(0).getEndDate().equals(endDate));
		BClaim.setDescription("tests");
		assertTrue("description is equal", testClaimList
				.getSubmittedClaimList().get(1).getDescription()
				.equals("tests"));
		BClaim.setStatus("Submitted");
		assertTrue("status is equal", testClaimList.getSubmittedClaimList()
				.get(1).getStatus().equals("Submitted"));
		Destination testDestionation = new Destination("Paris");
		BClaim.addDestionation(testDestionation);
		assertTrue("destionation is true",
				testClaimList.getSubmittedClaimList().get(1).getDestination()
						.equals(testDestionation));
		Item itemA = new Item("food");
		Item itemB = new Item("texi");
		itemA.setAmount(12);
		itemB.setAmount(15);
		AClaim.addItem(itemA);
		AClaim.addItem(itemB);
		int amount = AClaim.getTotalCurrency();
		assertEquals("total currency is right",amount, 27);
		


	}

	// US08.04.01 and US08.05.01
	protected void viewClaimItemReceiptPhoto(){
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		Item itemA = new Item("food");
		Item itemB = new Item("texi");
		AClaim.addItem(itemA);
		BClaim.addItem(itemB);
		itemA.takeAPhoto();
		itemB.takeAPhoto();
		
		assertFalse("is photo", itemA.getPhoto().equals(null));
		assertFalse("is photo", itemB.getPhoto().equals(null));
		
	}
	
	//US08.02.01

	
	/*
	
	//should go to another activity AddEditClaimActivity
	
	public class Appoval_Test extends ActivityInstrumentationTestCase2<AddEditClaimActivity>   {
	public Appoval_Test(Class<AddEditClaimActivity> activityClass) {
		super(activityClass);
		// TODO Auto-generated constructor stub
	}

	Activity activity;
	ClaimList claimList = Manager.getClaimList();
	
	*/
	
	// US08.06.01
	
	
	protected void addACommentOfSubmittedClaimTest() {
		String tname = "claimant_test";
		User claimiant = new User(tname);
		
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		User approval = new User("test");
		AClaim.setApproverName(approval);
		AClaim.setComment("comment test");
		assertEquals("comment added ", AClaim.getComment().toString(), "comment test");
				
	}

	//from us07.05.01
	public void showFeedback() {
		String tname = "claimant_test";
		User claimiant = new User(tname);
		
		ClaimList claimList = new ClaimList();
	
		User approver = new User("jack");
		Claim claim = claimList.getPosition(0);
		//User.approve(claim, "This a good claim");
		assertTrue("recieve feedback?", claim.getApproverName().getName().equals("jack"));
		assertTrue("recieve feedback?",
				claim.getComment() == "This a good claim");
	}
	
	//US08.07.01
	protected void returnClaimNotApproveTest() {

		User AApproval = new User("tester");
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		BClaim.setStatus("Returned");
		BClaim.setApproverName(AApproval);
		BClaim.setComment("reason");
		assertTrue("comment is added", BClaim.getComment()
				.equals("reason"));
		assertEquals("status is return? ", BClaim.getStatus(), "Returned");
		
		
	
	}

	//US08.08.01
	protected void returnClaimSetApproverNameTest() {
		String tname = "claimant_test";
		User claimiant = new User(tname);
	
		User AApproval = new User("tester");
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		BClaim.setStatus("Returned");
		BClaim.setApproverName(AApproval);
		BClaim.setComment("reason");
		assertTrue("comment is added",
				BClaim.getApproverName().getName().equals("tester"));

	}

	protected void approveClaimSetApproverNameTest() {
		User AApproval = new User("tester");
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
		BClaim.setApproverName(AApproval);

		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		BClaim.setStatus("Approved");
		BClaim.setComment("reason");
		assertTrue("comment is added",
				BClaim.getApproverName().getName().equals("tester"));

	}
	
	//US08.09.01 added 2015-02-12
	
	public void claimantCanNotChangeClaimStatusTest(){
		String name = "J";
		
		
		User testApproval = new User(name); 
		
		Claim claimA = new Claim("A");
		
		claimA.setApproverName(testApproval);
		claimA.setStatus("Submitted");
		assertEquals("should change", claimA.getStatus(), "Submitted");
		
		
		User testClaimant = new User(name);
		claimA.setClaimiantName(testClaimant);	
		ArrayList<Claim> testClaimListTrue = new ArrayList<Claim>();
		testClaimListTrue.add(claimA);
	
		//assertTrue("Submittedlist", testClaimListTrue.getSubmittedClaimList().equals(testClaimListTrue));
	
		claimA.setStatus("Returned");
		assertEquals("should not changed", claimA.getStatus(), "Submitted");
		claimA.setStatus("Approved");
		assertEquals("should not changed", claimA.getStatus(), "Submitted");
		assertTrue("Claimant cannot edit the claim write by himself",claimA.getStatus().equals(claimA.getStatus()));

		
	}
	


	


	protected void viewSClaimsDetailsTest() {
		User approve = new User("test");
		ClaimList testClaimList = new ClaimList();
		Claim AClaim = new Claim("A");
		Claim BClaim = new Claim("B");
		Claim CClaim = new Claim("C");
		testClaimList.addClaim(AClaim);
		testClaimList.addClaim(BClaim);
		testClaimList.addClaim(CClaim);
		BClaim.setApproverName(approve);

		AClaim.setStatus("Submitted");
		BClaim.setStatus("Submitted");
		BClaim.setStatus("Approved");
		assertEquals("should change", AClaim.getStatus(), "Submitted");
		
	}
	
	//08.05.01
    protected void viewReceiptTest(){
    	Bitmap imageFileUri = null;
    	User approver = new User("test");
    	Claim Aclaim = new Claim("test");
    	Item item = new Item("test");
    	Aclaim.addItem(item);
    	item.takeAPhoto();
    	assertTrue("view Receipt",item.getPhoto().equals(imageFileUri));


    }
	}
