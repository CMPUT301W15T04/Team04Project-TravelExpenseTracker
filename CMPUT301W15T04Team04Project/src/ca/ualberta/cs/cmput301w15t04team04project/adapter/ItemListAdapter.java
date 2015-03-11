package ca.ualberta.cs.cmput301w15t04team04project.adapter;

import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import android.content.Context;
import android.widget.ArrayAdapter;


public class ItemListAdapter extends ArrayAdapter<Item>
{
	private ArrayList<Item> itemList = null;

	public ItemListAdapter(Context context, int resource,
			 ArrayList<Item> objects)
	{

		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		this.itemList = objects;
	}


}
