package ca.ualberta.cs.cmput301w15t04team04project.adapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import android.widget.ImageView;
import android.widget.TextView;


public class ItemListAdapter extends ArrayAdapter<Item>
{
	private ArrayList<Item> itemList = null;
	private ViewHolder iholder = null;
	public ItemListAdapter(Context context, int resource,
			 ArrayList<Item> objects){

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
	

		//get views
		iholder.date = (TextView) convertView.findViewById(R.id.singleItemDateShowTextView);
		iholder.description = (TextView) convertView.findViewById(R.id.singleItemDescripShowTextView);
		iholder.category = (TextView) convertView.findViewById(R.id.singleItemCategoryShowTextView);
		iholder.amount = (TextView) convertView.findViewById(R.id.singleItemAmountShowTextView);

		convertView.setTag(iholder);
		
		
		Item item = itemList.get(position);
		if (item!=null){
			//item = new Item("Testing");
		}
		
		//set content in views
		
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		String dateOutput = df.format(item.getDate());
		iholder.date.setText(dateOutput);//item.getDate().toString());//"date"); //claim.getDestination());
		
		iholder.description.setText(item.getDescription());  //claim.getStatus();
		iholder.category.setText(item.getCategory());//"category");
		iholder.amount.setText(item.getCurrency().toString());//"$ CAD 88.88"); //claim.getAmount();
		
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
