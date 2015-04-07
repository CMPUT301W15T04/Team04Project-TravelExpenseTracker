package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;
import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.cmput301w15t04team04project.EditItemActivity;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ItemEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Currency;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;

public class US04_06_01 extends ActivityInstrumentationTestCase2<EditItemActivity> {
	public EditItemActivity thisActivity;
	public ItemEditController controller;
	
	public US04_06_01() {
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
		
		assertEquals("itemA's item name is add", "testAItem", claim.getItems().get(0).getItemName());
		assertEquals("itemA's item date is add", 2013, claim.getItems().get(0).getItemDate().getYear());
		assertEquals("itemA's item category is add", "Cate1", claim.getItems().get(0).getItemCategory());
		assertEquals("itemA's item carency unit is add", "CAD", claim.getItems().get(0).getItemCurrency().getType());
		assertEquals("itemA's item carency is add", 80, claim.getItems().get(0).getItemCurrency().getAmount());
		assertEquals("itemA's item description is add", "testDescription", claim.getItems().get(0).getItemDescription());
	}
	
	
	public void editItemTest(){
		Claim claim = controller.getClaim();
		Item editItem = claim.getItems().get(0);
		
		editItem.setComplete(true);
		editItem.setItemCategory("Air Fare");
		editItem.setItemCurrency(new Currency("USD", 100));
		Date Adate = new Date();
		Adate.setYear(2000);
		editItem.setItemDate(Adate);
		editItem.setItemDescription("the second description");
		editItem.setItemName("After Editing");
		editItem.setReceipt("new reciept");

		assertEquals("itemA's item name is updated", "After Editing", claim.getItems().get(0).getItemName());
		assertEquals("itemA's item date is updated", 2000, claim.getItems().get(0).getItemDate().getYear());
		assertEquals("itemA's item category is updated", "Air Fare", claim.getItems().get(0).getItemCategory());
		assertEquals("itemA's item carency unit is updated", "USD", claim.getItems().get(0).getItemCurrency().getType());
		assertEquals("itemA's item carency is updated", 100, claim.getItems().get(0).getItemCurrency().getAmount());
		assertEquals("itemA's item description is updated", "the second description", claim.getItems().get(0).getItemDescription());
		assertEquals("itemA's item receipt is updated", "new reciept", claim.getItems().get(0).getReceipt());
		assertEquals("itemA's item flag is updated", true, claim.getItems().get(0).getisComplete());
		
	}
}