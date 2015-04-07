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

import java.text.DateFormatSymbols;
import java.util.ArrayList;

import ca.ualberta.cs.cmput301w15t04team04project.R;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * @author Youdong Ma
 *
 */
public class ClaimListAdapter extends ArrayAdapter<Claim> {
	private ArrayList<Claim> claimList = null;
	private ViewHolder holder = null;


	/**
	 * Constructs the adapter and initializes its context.
	 * 
	 * @param context
	 *            The Context in which the adapter is running.
	 * @param objects
	 *            The Claim list.
	 * @param source
	 *            the posiion of the claim
	 */
	public ClaimListAdapter(Context context, int resource,
			ArrayList<Claim> objects) {
		super(context, resource, objects);
		this.claimList = objects;
	}

	/**
	 * Gets a View that displays the given view holder for the specific values
	 * in a reply.
	 * 
	 * @param position
	 *            The position of the Claim.
	 * @param convertView
	 *            A previous recycled view.
	 * @param parent
	 *            Parent view
	 * 
	 * @return The View
	 */
	@SuppressWarnings("deprecation")
	/* (non-Javadoc)
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(this.getContext());
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.single_claim, null);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		claimList.get(position);
		holder.claimName=(TextView) convertView.findViewById(R.id.singleClaimClaimNametextView);
		holder.startMonth = (TextView) convertView
				.findViewById(R.id.singleClaimStartMonthTextView);
		holder.startDate = (TextView) convertView
				.findViewById(R.id.singleClaimStartDateTextView);
		holder.startYear = (TextView) convertView
				.findViewById(R.id.singleClaimStartYearTextView);
		holder.tags = (TextView) convertView.findViewById(R.id.desplayTags);
		holder.destination = (TextView) convertView
				.findViewById(R.id.singleClaimDistinationDisplayTextView);
		holder.claimState = (TextView) convertView
				.findViewById(R.id.claimState);
		holder.totalAmount = (TextView) convertView
				.findViewById(R.id.totalAmountDisplay);

		convertView.setTag(holder);

		Claim claim = claimList.get(position);
		if (claim != null) {
			// claim = new Claim("Testing");
		}
		holder.claimName.setText(claim.getClaim());
		holder.startYear.setText("" + (claim.getStartDate().getYear() + 1900));
		holder.startMonth
				.setText(new DateFormatSymbols().getShortMonths()[claim
						.getStartDate().getMonth()]);
		holder.startDate.setText(" " + claim.getStartDate().getDate() + ",");
		holder.tags.setText(claim.TagListToString());
		holder.destination.setText(claim.DestinationListToString());// "destination");
																	// //claim.getDestination());
		holder.claimState.setText(claim.getStatus());// "In Progress");
														// //claim.getStatus();
		holder.totalAmount.setText(claim.currencySummary());// "$ CAD 88.88");
																		// //claim.getAmount();

		return convertView;

	}

	/**
	 * The container of the views for a single Claim
	 * @author Youdong Ma
	 *
	 * 
	 */
	class ViewHolder {
		TextView claimName;
		TextView startYear;
		TextView startMonth;
		TextView startDate;
		TextView destination;
		TextView totalAmount;
		TextView tags;
		TextView claimState;
	}
}
