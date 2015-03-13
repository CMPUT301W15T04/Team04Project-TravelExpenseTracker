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
package ca.ualberta.cs.cmput301w15t04team04project;

import java.util.ArrayList;
import ca.ualberta.cs.cmput301w15t04team04project.View.XListView;
import ca.ualberta.cs.cmput301w15t04team04project.View.XListView.IXListViewListener;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

public class FragmentMoments extends Fragment implements IXListViewListener{
	private XListView mListView;
	//private ClaimListAdapter mAdapter;
	private ArrayAdapter<String> mAdapter;
	//private ArrayList<Claim> items = new ArrayList<Claim>();
	private ArrayList<String> items = new ArrayList<String>();
	private Handler mHandler;
	private int start = 0;
	private static int refreshCnt = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			return null;
		}
		return (LinearLayout) inflater.inflate(R.layout.fragment_moments,
				container, false);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		geneItems();
		mListView = (XListView) getView().findViewById(R.id.xListView);
		mListView.setPullLoadEnable(true);
		mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item , items);
		mListView.setAdapter(mAdapter);
//		mListView.setPullLoadEnable(false);
//		mListView.setPullRefreshEnable(false);
		mListView.setXListViewListener(this);
		mHandler = new Handler();

	}
	public void onStart() {
		super.onStart();
	}

	private void geneItems() {
		for (int i = 0; i != 20; ++i) {
			items.add("refresh cnt " + (++start));
		}
	}

	private void onLoad() {
		mListView.stopRefresh();
		mListView.stopLoadMore();
		mListView.setRefreshTime("Just now");
	}

	@Override
	public void onRefresh() {
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				start = refreshCnt;
				items.clear();
				geneItems();
				//mAdapter.notifyDataSetChanged();
				mAdapter = new ArrayAdapter<String>(getActivity(),R.layout.list_item, items);
				mListView.setAdapter(mAdapter);
				onLoad();
			}
		}, 500);
	}

	@Override
	public void onLoadMore() {
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				geneItems();
				mAdapter.notifyDataSetChanged();
				onLoad();
			}
		}, 500);
	}

}
