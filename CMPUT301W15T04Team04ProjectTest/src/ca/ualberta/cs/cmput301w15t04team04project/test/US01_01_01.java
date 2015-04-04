package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.EditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.test.ActivityInstrumentationTestCase2;

public class US01_01_01 extends ActivityInstrumentationTestCase2<EditClaimActivity> {
	public EditClaimActivity thisActivity;
	public ClaimEditController controller;
	
	public US01_01_01() {
		super(EditClaimActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		thisActivity = (EditClaimActivity) getActivity();
		controller = new ClaimEditController();
	}
	
	public void testPreConditions(){
        assertNotNull(thisActivity);
 
        Claim testClaim = new Claim("test");
        Date date1 = new Date();
        date1.setYear(1999);
        testClaim.setStartDate(date1);
        Date date2 = new Date();
        date2.setYear(2000);  
        testClaim.setEndDate(date2);
        controller.setClaimObj(testClaim);
        
        Date startDate = new Date();
        startDate = testClaim.getStartDate();
        Date endDate = new Date();
        endDate = testClaim.getEndDate();
        
        
        assertEquals("Start Date is equall",startDate,date1);
        assertEquals("End Date is equall",endDate,date1);
	
	}
}
