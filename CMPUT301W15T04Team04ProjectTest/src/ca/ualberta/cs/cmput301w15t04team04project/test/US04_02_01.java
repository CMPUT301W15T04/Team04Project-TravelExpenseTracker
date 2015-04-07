package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.EditItemActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ItemEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Currency;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;

public class US04_02_01 extends ActivityInstrumentationTestCase2<EditItemActivity> {
	public EditItemActivity thisActivity;
	public ItemEditController controller;
	
	public US04_02_01() {
		super(EditItemActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		//thisActivity = (EditItemActivity) getActivity();
		controller = new ItemEditController();
	}

	public void test(){
		Claim claim = controller.getClaim();

		Item itemA = new Item("testAItem");

		Date Adate = new Date();
		Adate.setYear(2013);
		Date Bdate = new Date();
		Bdate.setYear(2014);
		itemA.setItemDate(Adate);
		itemA.setItemCategory("supplies");
		
		Currency itemCurrency = new Currency("CAD", 80);
		
		itemA.setItemCurrency(itemCurrency);
		itemA.setItemDescription("testDescription");
		
		controller.addItem(itemA);
		
		
		if (claim.getItems().get(0).getItemCategory().equals("Air Fare")) {
			assertEquals("itemA's item category is add", "Air Fare", claim.getItems().get(0).getItemCategory());
		}
		else if (claim.getItems().get(0).getItemCategory().equals("Ground Transport")) {
			assertEquals("itemA's item category is add", "Ground Transport", claim.getItems().get(0).getItemCategory());
		}
		else if (claim.getItems().get(0).getItemCategory().equals("vehicle rental")) {
			assertEquals("itemA's item category is add", "vehicle rental", claim.getItems().get(0).getItemCategory());
		}
		else if (claim.getItems().get(0).getItemCategory().equals("private automobile")) {
			assertEquals("itemA's item category is add", "private automobile", claim.getItems().get(0).getItemCategory());
		}
		else if (claim.getItems().get(0).getItemCategory().equals("Fuel")) {
			assertEquals("itemA's item category is add", "Fuel", claim.getItems().get(0).getItemCategory());
		}
		else if (claim.getItems().get(0).getItemCategory().equals("parking")) {
			assertEquals("itemA's item category is add", "parking", claim.getItems().get(0).getItemCategory());
		}
		else if (claim.getItems().get(0).getItemCategory().equals("registration")) {
			assertEquals("itemA's item category is add", "registration", claim.getItems().get(0).getItemCategory());
		}
		else if (claim.getItems().get(0).getItemCategory().equals("accommodation")) {
			assertEquals("itemA's item category is add", "accommodation", claim.getItems().get(0).getItemCategory());
		}
		else if (claim.getItems().get(0).getItemCategory().equals("meal")) {
			assertEquals("itemA's item category is add", "meal", claim.getItems().get(0).getItemCategory());
		}
		else if (claim.getItems().get(0).getItemCategory().equals("supplies")) {
			assertEquals("itemA's item category is add", "supplies", claim.getItems().get(0).getItemCategory());
		}
		else {
			assertEquals("itemA's item category is add", null, claim.getItems().get(0).getItemCategory());
		}
		


	}
}
