package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.ArrayList;
import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.EditItemActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ItemEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Currency;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;

public class US04_08_01 extends ActivityInstrumentationTestCase2<EditItemActivity> {
	public EditItemActivity thisActivity;
	public ItemEditController controller;
	
	public US04_08_01() {
		super(EditItemActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		controller = new ItemEditController();
	}

	public void testLessInterFace(){
		Claim claim = controller.getClaim();
		assertNotNull(claim);
		
		ArrayList<Item> items = claim.getItems();
		assertNotNull(items);
		
	}
}