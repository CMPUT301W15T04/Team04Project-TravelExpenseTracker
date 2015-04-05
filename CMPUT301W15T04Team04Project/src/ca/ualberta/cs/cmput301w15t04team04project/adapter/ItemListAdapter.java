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

package ca.ualberta.cs.cmput301w15t04team04project.adapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.ualberta.cs.cmput301w15t04team04project.R;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.ClaimListAdapter.ViewHolder;
import ca.ualberta.cs.cmput301w15t04team04project.controller.searchController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemListAdapter extends ArrayAdapter<Item> {
	private ArrayList<Item> itemList = null;
	private ViewHolder iholder = null;
	/**
	 * Constructs the adapter and initializes its context.
	 * 
	 * @param context
	 *            The Context in which the adapter is running.
	 * @param objects
	 *            The Item list.
	 * @param source
	 *            the posiion of the Item
	 */
	public ItemListAdapter(Context context, int resource,
			ArrayList<Item> objects) {

		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.itemList = objects;
	}

	/**
	 * Gets a View that displays the given view holder for the specific values
	 * in a reply.
	 * 
	 * @param position
	 *            The position of the Item.
	 * @param convertView
	 *            A previous recycled view.
	 * @param parent
	 *            Parent view
	 * 
	 * @return The View
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(this.getContext());
			iholder = new ViewHolder();
			convertView = inflater.inflate(R.layout.single_item, null);
		} else {
			iholder = (ViewHolder) convertView.getTag();
		}

		itemList.get(position);

		// get views
		iholder.date = (TextView) convertView
				.findViewById(R.id.singleItemDateShowTextView);
		iholder.description = (TextView) convertView
				.findViewById(R.id.singleItemDescripShowTextView);
		iholder.category = (TextView) convertView
				.findViewById(R.id.singleItemCategoryShowTextView);
		iholder.amount = (TextView) convertView
				.findViewById(R.id.singleItemAmountShowTextView);
		iholder.receipt = (ImageView) convertView.findViewById(R.id.hasRecieptImageView);
		
		convertView.setTag(iholder);

		Item item = itemList.get(position);
		if (item != null) {
			// item = new Item("Testing");
		}

		// set content in views

		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		String dateOutput = df.format(item.getItemDate());
		iholder.date.setText(dateOutput);// item.getDate().toString());//"date");
											// //claim.getDestination());

		iholder.description.setText(item.getItemDescription()); // claim.getStatus();
		iholder.category.setText(item.getItemCategory());// "category");
		iholder.amount.setText(item.getItemCurrency().toString());// "$ CAD 88.88");
																// //claim.getAmount();
		if (item.getReceipt() != null) {

			Bitmap bitmap = item.getReceipBitmap();
			iholder.receipt.setImageBitmap(Bitmap.createScaledBitmap(bitmap, 256,
					256, false));
			// button.setImageBitmap(bitmap);

		}
		
		
		return convertView;

	}

	/**
	 * The container of the views for a single Item
	 * @author Weijie Sun
	 *
	 * 
	 */
	class ViewHolder {
		TextView itemName;
		TextView description;
		TextView date;
		TextView amount;
		TextView category;
		ImageView receipt;
	}
}
