package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.MainActivity;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

public class Approver_02_Test extends ActivityInstrumentationTestCase2<MainActivity>{
	public Approver_02_Test(Class<MainActivity> activityClass) {
		super(activityClass);
		// TODO Auto-generated constructor stub
	}

	
	
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
