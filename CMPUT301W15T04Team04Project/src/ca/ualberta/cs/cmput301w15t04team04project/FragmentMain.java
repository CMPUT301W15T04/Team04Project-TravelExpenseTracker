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

public class FragmentMain extends Fragment implements IXListViewListener{
	private XListView mListView;
	private ArrayAdapter<String> mAdapter;
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
		return (LinearLayout) inflater.inflate(R.layout.fragment_main,
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
		mListView.setRefreshTime("刚刚");
	}

	@Override
	public void onRefresh() {
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				start = ++refreshCnt;
				items.clear();
				geneItems();
				//mAdapter.notifyDataSetChanged();
				mAdapter = new ArrayAdapter<String>(getActivity(),R.layout.list_item, items);
				mListView.setAdapter(mAdapter);
				onLoad();
			}
		}, 2000);
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
		}, 2000);
	}

}