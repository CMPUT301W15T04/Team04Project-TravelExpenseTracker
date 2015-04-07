package ca.ualberta.cs.cmput301w15t04team04project.test;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.EditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Destination;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Location;
import android.test.ActivityInstrumentationTestCase2;

public class US03_01_01 extends ActivityInstrumentationTestCase2<EditClaimActivity> {
	public EditClaimActivity thisActivity;
	public ClaimEditController controller;
	public User claimiant;
	public ArrayList<Item> items;
	
	public US03_01_01() {
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
 
        claimiant = new User("testclaimiant");
        Claim testClaim = new Claim("test");
        Date date1 = new Date();
        date1.setYear(1999);
        testClaim.setStartDate(date1);
        Date date2 = new Date();
        date2.setYear(2000);  
        testClaim.setEndDate(date2);
        controller.setClaimObj(testClaim);
        
        String testTags = "tag1,tag2";
        
        ArrayList<Destination> destinations = new ArrayList<Destination>();
        Destination destination1 = new Destination("Edmonton");
        destination1.setdReason("test1");
        destinations.add(destination1);
        
        ArrayList<String> comments = new ArrayList<String>();
        Location location = null;
        
        controller.setClaim("test", "", testTags, date1, date2, destinations, "testclaimiant", items,comments,location);

        String outPutTag1 = testClaim.getTag().get(0);
        String outPutTag2 = testClaim.getTag().get(1);
        
        assertEquals("Tag1 is equall","tag1",outPutTag1);
        assertEquals("Tag1 is equall","tag2",outPutTag2);
	}

}
