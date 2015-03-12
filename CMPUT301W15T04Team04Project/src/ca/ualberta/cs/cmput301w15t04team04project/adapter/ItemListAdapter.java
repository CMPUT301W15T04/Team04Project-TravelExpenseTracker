package ca.ualberta.cs.cmput301w15t04team04project.adapter;

import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.cmput301w15t04team04project.R;
import ca.ualberta.cs.cmput301w15t04team04project.adapter.ClaimListAdapter.ViewHolder;
import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class ItemListAdapter extends ArrayAdapter<Item>
{
	private ArrayList<Item> itemList = null;
	private ViewHolder iholder = null;
	public ItemListAdapter(Context context, int resource,
			 ArrayList<Item> objects)
	{

		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.itemList = objects;
	}

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
	

		

		
		return convertView;
		
	}
	class ViewHolder {
		TextView itemName;
		TextView description;
		TextView date;
		TextView amount;
		TextView category;
		ImageView receipt;
	}
}
