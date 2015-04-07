package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;
import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.EditItemActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ItemEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Currency;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;

public class US04_03_01 extends ActivityInstrumentationTestCase2<EditItemActivity> {
	public EditItemActivity thisActivity;
	public ItemEditController controller;
	
	public US04_03_01() {
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
		itemA.setItemCategory("Cate1");
		
		Currency itemCurrency = new Currency("CNY", 80);
		
		itemA.setItemCurrency(itemCurrency);
		itemA.setItemDescription("testDescription");
		
		controller.addItem(itemA);
		
		
		if (claim.getItems().get(0).getItemCurrency().getType().equals("CAD")) {
			assertEquals("itemA's item carency unit is add", "CAD", claim.getItems().get(0).getItemCurrency().getType());
		}
		else if (claim.getItems().get(0).getItemCurrency().getType().equals("USD")) {
			assertEquals("itemA's item carency unit is add", "USD", claim.getItems().get(0).getItemCurrency().getType());
		}
		else if (claim.getItems().get(0).getItemCurrency().getType().equals("EUR")) {
			assertEquals("itemA's item carency unit is add", "EUR", claim.getItems().get(0).getItemCurrency().getType());
		}
		else if (claim.getItems().get(0).getItemCurrency().getType().equals("GBP")) {
			assertEquals("itemA's item carency unit is add", "GBP", claim.getItems().get(0).getItemCurrency().getType());
		}
		else if (claim.getItems().get(0).getItemCurrency().getType().equals("CHF")) {
			assertEquals("itemA's item carency unit is add", "CHF", claim.getItems().get(0).getItemCurrency().getType());
		}
		else if (claim.getItems().get(0).getItemCurrency().getType().equals("JPY")) {
			assertEquals("itemA's item carency unit is add", "JPY", claim.getItems().get(0).getItemCurrency().getType());
		}
		else if (claim.getItems().get(0).getItemCurrency().getType().equals("CNY")) {
			assertEquals("itemA's item carency unit is add", "CNY", claim.getItems().get(0).getItemCurrency().getType());
		}
		else {
			assertEquals("itemA's item carency unit is add", null, claim.getItems().get(0).getItemCurrency().getType());
		}
		


	}
}