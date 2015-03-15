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

package ca.ualberta.cs.cmput301w15t04team04project.models;

import java.util.Date;

import android.widget.ImageView;


/**
* The Item model is just a rough Item's information
* simply store set and get all of the Item
*
* @param	itemName is the name of the item
* @author  Weijie Sun
* @version 1.0
* @since   2015-03-08 
* 
* @author  Chenrui Lei
* @version 1.0
* @since   2015-03-12
*/
public class Item {
	private String itemName;
	private Date date;
	private String category;
	private String description;
	private Currency currency;
	//private ImageView receipt;
	private boolean isComplete = false;
	
	/**
	* The Item model is just a rough Item's information
	* simply store set and get all of the Item
	*
	* @param	itemName is the name of the item
	* @author  Weijie Sun
	* @version 1.0
	* @since   2015-03-08 
	*/
	public Item(String itemName) {
		// TODO Auto-generated constructor stub
		this.setItemName(itemName);
		date = new Date();
		category = "";
		description = "";
		currency = new Currency(null);
	}

	public void takeAPhoto() {
		// TODO Auto-generated method stub
		
	}

	public void deleteAPhoto() {
		// TODO Auto-generated method stub
		
	}

	public Object getPhoto() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getItemName()
	{

		return itemName;
	}

	public void setItemName(String itemName)
	{

		this.itemName = itemName;
	}

	public Date getDate()
	{

		return date;
	}

	public void setDate(Date date)
	{

		this.date = date;
	}

	public String getCategory()
	{

		return category;
	}

	public void setCategory(String category)
	{

		this.category = category;
	}

	public String getDescription()
	{

		return description;
	}

	public void setDescription(String description)
	{

		this.description = description;
	}

/*
	public ImageView getReceipt()
	{

		return receipt;
	}

	public void setReceipt(ImageView receipt)
	{

		this.receipt = receipt;
	}
*/
	public boolean isComplete()
	{

		return isComplete;
	}

	public void changeIsComplete(boolean isComplete)
	{
		if (this.isComplete==false){
			this.isComplete = true;
		} else {
			this.isComplete = false;
		}
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
