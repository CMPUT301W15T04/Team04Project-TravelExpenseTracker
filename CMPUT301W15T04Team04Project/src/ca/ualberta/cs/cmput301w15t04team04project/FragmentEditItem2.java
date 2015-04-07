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

import java.io.File;
import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.CLmanager;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ItemEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * <p><b>
 * This is the fragment part 2 for adding/editing an item.</b><br>
 * In this part of the fragment, you can add the description of an item and receipt<br>
 * You also can edit the item if you already add one item and choose the one you want to edit.<br>
 * You can enter the description as much as you want but you can add only one receipt.<br>
 * The size of the receipt is 65536 byte at most
 * </p>
 * 
 * @since 2015-03-10
 * @version 1.0
 * 
 * @author Ji Yang
 * @author Yang Zhang
 * @author Yufei Zhang
 * @author Weijie Sun
 */
public class FragmentEditItem2 extends Fragment {
	private int myItemId;
	private String claimName;
	private TextView itemDescription;
	private View thisview;
	private Uri imageFileUri;
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private ItemEditController controller;
	private CLmanager onlineManager = new CLmanager();
	private EditItemActivity myActivity;
	private Runnable finishLoad =  new Runnable() {
		public void run() {
			Item currentItem = controller.getClaim().getPosition(myItemId);
			itemDescription.setText(currentItem.getItemDescription());

			ImageButton button = (ImageButton) thisview
					.findViewById(R.id.addRecieptImageButton);

			
			if (currentItem.getReceipt() != null) {

				Bitmap bitmap = currentItem.getReceipBitmap();
				button.setImageBitmap(Bitmap.createScaledBitmap(bitmap, 256,
						256, false));
				Toast.makeText(getActivity(), ""+bitmap.getByteCount(), Toast.LENGTH_LONG).show();

				Toast.makeText(myActivity, "has photo",Toast.LENGTH_LONG ).show();
				// button.setImageBitmap(bitmap);

			}
			else{
				Toast.makeText(myActivity, "No photo",Toast.LENGTH_LONG ).show();
			}
		}
	};
	/**
	 * Version of onCreateView(String, Context, AttributeSet) that also supplies 
	 * the parent that the view created view will be placed in.
	 * 
	 * @param inflater
	 * @param container
	 * @param savedInstanceState
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-15
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_edit_item_2, container,
				false);
		thisview = view;
		ImageButton button = (ImageButton) view
				.findViewById(R.id.addRecieptImageButton);
		OnClickListener listener = new OnClickListener() {
			public void onClick(View v) {
				takeAPhoto();
			}
		};
		button.setOnClickListener(listener);

		return view;

	}

	/**
	 * Called when the fragment's activity has been created and this fragment's view hierarchy instantiated.<br>
	 * It can be used to do final initialization once these pieces are in place, such as retrieving views or restoring state.<br>
	 * It is also useful for fragments that use setRetainInstance(boolean) to retain their instance, 
	 * as this callback tells the fragment when it is fully associated with the new activity instance.<br>
	 * This is called after onCreateView(LayoutInflater, ViewGroup, Bundle) and before onViewStateRestored(Bundle).
	 * 
	 * @param savedInstanceState	If the fragment is being re-created from a previous saved state, this is the state.
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-15
	 * @author Yufei Zhang
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Bundle bundle = getActivity().getIntent().getExtras();
		if (bundle.size() == 1) {
			EditItemActivity.addEditItemStatus = 0;
		} else if (bundle.size() == 2) {
			EditItemActivity.addEditItemStatus = 1;
			claimName = bundle.getString("MyClaimName");
			myItemId = bundle.getInt("myItemId");
			itemDescription = (TextView) getView().findViewById(
					R.id.fragmentEditItem2DiscriptionEditText);
			GetThread get = new GetThread(claimName);
			get.start();
		}

	}

	/**
	 * <p>This part of code are copied from the following link:<br>
	 * {@link https://github.com/joshua2ua/BogoPicLab}<br>
	 * This part is using for taking a picture.</p>
	 * 
	 * @author Jushua
	 */

	public void takeAPhoto() {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

		String folder = Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/tmp";
		File folderF = new File(folder);
		if (!folderF.exists()) {
			folderF.mkdir();
		}

		String imageFilePath = folder + "/"
				+ String.valueOf(System.currentTimeMillis()) + "jpg";
		File imageFile = new File(imageFilePath);
		imageFileUri = Uri.fromFile(imageFile);

		intent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri);
		startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
	}
	
	/**
	 * <p>This part of code is copied from:<br>
	 * {@link http://stackoverflow.com/questions/13116104/best-practice-to-reference-the-parent-activity-of-a-fragment}
	 * @since March 26
	 */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			myActivity = (EditItemActivity) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must be EditItemActivity ");
		}
	}

	/**
	 * <b>This part of code is from:</b><br>
	 * {@link http://stackoverflow.com/questions/4830711/how-to-convert-a-image-into-base64-string}<br>
	 * @since March 26
	 */
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
			if (resultCode == -1) {

				Drawable drawable = Drawable.createFromPath(imageFileUri
						.getPath());
				Bitmap bitmap = BitmapFactory
						.decodeFile(imageFileUri.getPath());
				
				Toast.makeText(getActivity(), ""+bitmap.getByteCount(), Toast.LENGTH_LONG).show();

				myActivity.setReceiptBitmap(bitmap, 1);

				ImageButton button = (ImageButton) thisview
						.findViewById(R.id.addRecieptImageButton);
				button.setImageBitmap(Bitmap.createScaledBitmap(bitmap, 256,
						256, false));
				
			}
		}

	}

	/**
	 * <b>This part of code if copied from:</b><br>
	 * {@link http://geekonjava.blogspot.ca/2014/03/upload-image-on-server-in-android-using.html}
	 * 
	 * @param uri
	 * @return the value of one column as a String.
	 */
	// "http://geekonjava.blogspot.ca/2014/03/upload-image-on-server-in-android-using.html"
	// March 24 2015
	public String getPath(Uri uri) {
		String[] projection = { MediaStore.Images.Media.DATA };
		Cursor cursor = getActivity().managedQuery(uri, projection, null, null, null);
		int column_index = cursor
				.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		return cursor.getString(column_index);
	}
	class GetThread extends Thread{ 
		private String claimName;
		
		public GetThread(String claimName){
			this.claimName = claimName;
		}
		
		public void run(){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			controller = new ItemEditController(onlineManager.getClaim(claimName));
			getActivity().runOnUiThread(finishLoad);
		}
		
	}
}
