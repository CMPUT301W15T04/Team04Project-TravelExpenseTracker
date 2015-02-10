package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.Item;
import junit.framework.TestCase;

public class Items_Overall_Test extends TestCase {
	 final String itemname = "car";
	 final String claimname = "Beijing";
	 public void testItem(){
		 Item item = new Item(itemname);
		 item.setStartdate(new Date());
		 item.setCategary(new String());
		 item.setDes(new String());
		 int a = 100;
		 item.setAmount(a);
		 item.setUnit(new String());
	 }
	 
	 public void testFlag(){
		 Item item = new Item(itemname);
		 item.addFlag();
		 item.removeFlag();
	 }
	 
	 public void testItemView(){
		 Item item = new Item(itemname);
		 System.out.println(item.getStartdate()+item.getCategary()+item.getDes()+item.getAmount()+item.getUnit());
	 }
	 
	 public void testEditDeleteItem(){
		 Claim claim = new Claim(claimname);
		 claim.remove(new Item(itemname));
	 }
}
