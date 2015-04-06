package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.ArrayList;
import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.EditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Destination;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;

public class US01_04_01 extends ActivityInstrumentationTestCase2<EditClaimActivity> {
	public EditClaimActivity thisActivity;
	public ClaimEditController controller;
	public User claimiant;
	public ArrayList<Item> items;

	public US01_04_01() {
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
	
	public void test(){
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
        
        ArrayList<Destination> destinations = new ArrayList<Destination>();
        Destination destination1 = new Destination("Edmonton");
        destination1.setdReason("test1");
        destinations.add(destination1);
        
        Destination destination2 = new Destination("Ca");
        destination2.setdReason("test2");
        destinations.add(destination2);
        
        ArrayList<String> comments = new ArrayList<String>();

        controller.setClaim("test", "", "", date1, date2, destinations, "testclaimiant", items,comments);

        Date startDate = new Date();
        startDate = testClaim.getStartDate();
        Date endDate = new Date();
        endDate = testClaim.getEndDate();
        
        assertEquals("Start Date is equall",startDate,date1);
        assertEquals("End Date is equall",endDate,date2);
	
        Destination destinationA = testClaim.getDestination().get(0);
        Destination destinationB = testClaim.getDestination().get(1);
        
        assertEquals("destination1 is equall",destinationA.getdName(),destination1.getdName());
        assertEquals("destination1 is equall",destinationB.getdName(),destination2.getdName());


	}
	
	public void editTest(){
		Claim testClaim = new Claim("test");
        Date date1 = new Date();
        date1.setYear(1998);
        testClaim.setStartDate(date1);
        Date date2 = new Date();
        date2.setYear(2001);  
        testClaim.setEndDate(date2);
        controller.setClaimObj(testClaim);
        
        ArrayList<Destination> destinations = new ArrayList<Destination>();
        Destination destination1 = new Destination("Edmontonedit");
        destination1.setdReason("test1edit");
        destinations.add(destination1);
        
        Destination destination2 = new Destination("Caedit");
        destination2.setdReason("test2edit");
        destinations.add(destination2);
        
        ArrayList<String> comments = new ArrayList<String>();

        controller.setClaim("test", "", "", date1, date2, destinations, "testclaimiant", items,comments);

        Date startDate = new Date();
        startDate = testClaim.getStartDate();
        Date endDate = new Date();
        endDate = testClaim.getEndDate();
        
        assertEquals("Start Date is equall",startDate,date1);
        assertEquals("End Date is equall",endDate,date1);
	
        Destination destinationA = testClaim.getDestination().get(0);
        Destination destinationB = testClaim.getDestination().get(1);
        
        assertEquals("destination1 is equall",destinationA.getdName(),destination1.getdName());
        assertEquals("destination1 is equall",destinationB.getdName(),destination2.getdName());


		
	}

}
