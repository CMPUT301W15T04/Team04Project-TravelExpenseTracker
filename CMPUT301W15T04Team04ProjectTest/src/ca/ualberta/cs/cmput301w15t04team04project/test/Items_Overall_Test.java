/*
* Copyright 2015 Weijie Sun
* Copyright 2015 Youdong Ma
* Copyright 2015 Yufei Zhang
* Copyright 2015 Chenrui Lei
* Copyright 2015 Yang Zhang
* Copyright 2015 Ji Yang
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.util.Date;

import ca.ualberta.cs.cmput301w15t04team04project.AddEditExpenseActivity;
import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Currency;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import junit.framework.TestCase;

public class Items_Overall_Test extends TestCase {
	final String itemname = "car";
	final String claimname = "Beijing";

	public void testItem() {
		Item item = new Item(itemname);
		item.setDate(new Date());
		item.setCategory(new String());
		item.setDate(new Date());
		float a = 100;
		String unit = "CAD $";
		item.setCurrency(new Currency(unit,a));
		
		assertFalse("Problems with getter and setter of status",
				itemname.equals(item.getItemName()));
		assertFalse("Problems with getter and setter of status",
				a == item.getAmount());
		assertFalse("Problems with getter and setter of status",
				itemname.equals(item.getItemName()));
	}

	public void testFlag() {
		Item item = new Item(itemname);
		
		assertFalse("Problems with getter and setter of status",
				item.isComplete() == false);
		item.changeIsComplete();
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
