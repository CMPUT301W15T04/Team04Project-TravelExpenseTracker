package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;
import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.EditItemActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ItemEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Currency;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;

public class US04_04_01 extends ActivityInstrumentationTestCase2<EditItemActivity> {
	public EditItemActivity thisActivity;
	public ItemEditController controller;
	
	public US04_04_01() {
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
		
		itemA.setComplete(false);
		Currency itemCurrency = new Currency("CAD", 80);
		
		itemA.setItemCurrency(itemCurrency);
		itemA.setItemDescription("testDescription");
		
		controller.addItem(itemA);
		
		Item itemB = new Item("testAItem2");
		itemB.setComplete(true);
		itemB.setItemDate(Bdate);
		itemB.setItemCategory("Cate2");
		
		
		Currency itemCurrencyB = new Currency("USD", 80);
		
		itemB.setItemCurrency(itemCurrencyB);
		itemB.setItemDescription("testDescription");
		
		controller.addItem(itemB);
		
		assertEquals("itemA's item name is add", "testAItem", claim.getItems().get(0).getItemName());
		assertEquals("itemA's item date is add", 2013, claim.getItems().get(0).getItemDate().getYear());
		assertEquals("itemA's item category is add", "Cate1", claim.getItems().get(0).getItemCategory());
		assertEquals("itemA's item carency unit is add", "CAD", claim.getItems().get(0).getItemCurrency().getType());
		assertEquals("itemA's item carency is add", 80, claim.getItems().get(0).getItemCurrency().getAmount());
		assertEquals("itemA's item description is add", "testDescription", claim.getItems().get(0).getItemDescription());
		assertEquals("itemA's item description is add", false, claim.getItems().get(0).getisComplete());
		
		assertEquals("itemB's item name is add", "testAItem2", claim.getItems().get(1).getItemName());
		assertEquals("itemB's item date is add", 2014, claim.getItems().get(1).getItemDate().getYear());
		assertEquals("itemB's item category is add", "Cate2", claim.getItems().get(1).getItemCategory());
		assertEquals("itemB's item carency unit is add", "USD", claim.getItems().get(1).getItemCurrency().getType());
		assertEquals("itemB's item carency is add", 80, claim.getItems().get(1).getItemCurrency().getAmount());
		assertEquals("itemB's item description is add", "testDescription", claim.getItems().get(1).getItemDescription());
		assertEquals("itemA's item description is add", true, claim.getItems().get(1).getisComplete());
	}
}