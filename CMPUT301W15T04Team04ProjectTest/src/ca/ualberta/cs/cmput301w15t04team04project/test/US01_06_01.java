package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.ArrayList;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.MyClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.MyLocalClaimListController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;

public class US01_06_01 extends ActivityInstrumentationTestCase2<MyClaimActivity> {
	public MyClaimActivity thisActivity;
	public ClaimEditController controller;
	public MyLocalClaimListController controller1;
	public User claimiant;
	public ArrayList<Item> items;

	public US01_06_01() {
		super(MyClaimActivity.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		//thisActivity = (MyClaimActivity) getActivity();
		controller = new ClaimEditController();
	}
	
	public void test(){
		
		//assertNotNull(thisActivity);
        
        claimiant = new User("testclaimiant");
        Claim testClaim = new Claim("test");

        controller.setClaimObj(testClaim);
        
        //do not know how to test
	
	
	}
	
}
