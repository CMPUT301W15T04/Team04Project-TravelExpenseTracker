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

import java.util.ArrayList;

import ca.ualberta.cs.cmput301w15t04team04project.R;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ClaimListAdapter extends ArrayAdapter<Claim> {
	private ArrayList<Claim> claimList = null;
	private ViewHolder holder = null;

	public ClaimListAdapter(Context context, int resource,
			ArrayList<Claim> objects) {
		super(context, resource, objects);
		this.claimList = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(this.getContext());
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.single_claim, null);
		}else {
			holder = (ViewHolder) convertView.getTag();
		}
		claimList.get(position);
		holder.startDate = (TextView) convertView
				.findViewById(R.id.dateStartDisplay);
		holder.endDate = (TextView) convertView
				.findViewById(R.id.dateEndDisplay);
		holder.tags = (TextView) convertView
				.findViewById(R.id.desplayTags);
		holder.destination = (TextView) convertView
				.findViewById(R.id.destinationDisplay);
		holder.claimState = (TextView) convertView
				.findViewById(R.id.claimState);
		holder.totalAmount = (TextView) convertView
				.findViewById(R.id.totalAmountDisplay);
		convertView.setTag(holder);
		Claim claim = claimList.get(position);
		if (claim!=null){
			
		}
		return convertView;
		//holder.startDate.setText(claim.getStartDate().getDate());
		//holder.endDate.setText(claim.getEndDate().getDate());
		//holder.tags
		//holder.destination = claim.getDestination()
		//holder.claimState = claim.getStatus();
		//holder.totalAmount = claim.getAmount()
	}

	class ViewHolder {
		TextView startDate;
		TextView endDate;
		TextView destination;
		TextView totalAmount;
		TextView tags;
		TextView claimState;
	}
}
