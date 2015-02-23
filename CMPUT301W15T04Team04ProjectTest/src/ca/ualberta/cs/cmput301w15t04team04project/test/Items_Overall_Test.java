package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.AddEditExpenseActivity;
import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.Item;
import junit.framework.TestCase;

public class Items_Overall_Test extends TestCase {
	final String itemname = "car";
	final String claimname = "Beijing";

	public void testItem() {
		Item item = new Item(itemname);
		item.setDate(new Date());
		item.setCategary(new String());
		item.setDes(new String());
		int a = 100;
		item.setAmount(a);
		item.setUnit(new String());
		
		assertFalse("Problems with getter and setter of status",
				itemname.equals(item.getItemName()));
		assertFalse("Problems with getter and setter of status",
				a == item.getAmount());
		assertFalse("Problems with getter and setter of status",
				itemname.equals(item.getItemName()));
	}

	public void testFlag() {
		Item item = new Item(itemname);
		item.addFlag();
		assertFalse("Problems with getter and setter of status",
				item.getFlag() == 1);
		item.removeFlag();
		assertFalse("Problems with getter and setter of status",
				item.getFlag() == 0);
	}
	
	private void makeTweet(String text) {
		assertNotNull(AddEditExpenseActivity
				.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.AddEditExpenseFlag));
	}

	public void testItemView() {
		Item item = new Item(itemname);
		System.out.println(item.getDate() + item.getCategary() + item.getDes()
				+ item.getAmount() + item.getUnit());
	}

	public void testEditDeleteItem() {
		Claim claim = new Claim(claimname);
		Item item = new Item(itemname);
		claim.addItem(item);
		assertFalse("Problems with getter and setter of status",
				item.getItemName().equals(claim.getItem(0)));
		claim.removeItem(item);
	}
}
