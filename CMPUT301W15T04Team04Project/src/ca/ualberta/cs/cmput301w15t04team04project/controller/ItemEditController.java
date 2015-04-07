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

package ca.ualberta.cs.cmput301w15t04team04project.controller;

import java.util.ArrayList;

import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;

/**
 * This controller can control the EditItemActivity
 * @author youdong
 *
 */
public class ItemEditController{
	private Claim claim;

	/**
	 * Initial the controller
	 */
	public ItemEditController(){
		
	}
	/**
	 * Initial the controller
	 */
	public ItemEditController(Claim claim) {
		this.claim = claim;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * add a item in the item list
	 */

	public void addItem(Item item) {
		getItem().add(item);
	}
	/**
	 * get claim if no claim create a new one
	 * @return claim
	 */
	public Claim getClaim() {
		if (claim == null) {
			claim = new Claim("");
		}
		return claim;
	}

	/**
	 * get ArrayList of item
	 * @return list of Item
	 */
	public ArrayList<Item> getItem() {
		return getClaim().getItems();
	}
}
