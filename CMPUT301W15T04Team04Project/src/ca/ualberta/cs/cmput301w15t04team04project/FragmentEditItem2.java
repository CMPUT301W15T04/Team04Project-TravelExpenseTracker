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


import ca.ualberta.cs.cmput301w15t04team04project.CLmanager.MyLocalClaimListManager;
import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This is the fragment part 2 for adding/editing an item.
 * 
 * @author Ji Yang
 * @author Yang Zhang
 * @version 1.0
 * @since 2015-03-10
 */
public class FragmentEditItem2 extends Fragment {
	private int myItemId;
	private int myClaimId;
	private TextView itemDescription;
	private View thisview;
	private Uri imageFileUri;
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private Item currentItem;
	private String stringUri = null;

	
	/**
	 * This is the onCreateView of initial the view
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-15
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		// return inflater.inflate(R.layout.fragment_edit_item_2, container,
		// false);
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
	 * This is the onActivityCreated of create Item or Edit item set the
	 * original information in the View
	 * 
	 * @author Weijie Sun
	 * @version 1.1
	 * @since 2015-03-15
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		ClaimList claimList = MyLocalClaimListManager
				.loadClaimList(getActivity());
		Bundle bundle = getActivity().getIntent().getExtras();
		if (bundle.size() == 1) {
			EditItemActivity.addEditItemStatus = 0;
		} else if (bundle.size() == 2) {
			EditItemActivity.addEditItemStatus = 1;
			myClaimId = bundle.getInt("myClaimId");
			myItemId = bundle.getInt("myItemId");
			Toast.makeText(getActivity(), "Frag ItemID = " + myItemId,
					Toast.LENGTH_SHORT).show();

			currentItem = claimList.getClaimArrayList().get(myClaimId)
					.getItems().get(myItemId);

			itemDescription = (TextView) getView().findViewById(
					R.id.fragmentEditItem2DiscriptionEditText);
			itemDescription.setText(currentItem.getItemDescription());
			
			/*ImageButton button = (ImageButton) thisview.findViewById(R.id.addRecieptImageButton);
			imageFileUri = Uri.parse(currentItem.getReceipt());
			button.setImageDrawable(Drawable.createFromPath(imageFileUri
					.getPath()));*/
		}

	}

	// resource from https://github.com/joshua2ua/BogoPicLab
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

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
			if (resultCode == -1) {
				
				stringUri = imageFileUri.getPath();
				Toast.makeText(getActivity(), stringUri,Toast.LENGTH_LONG ).show();
				//currentItem.setReceipt(stringUri);
				ImageButton button = (ImageButton) thisview.findViewById(R.id.addRecieptImageButton);
				button.setImageDrawable(Drawable.createFromPath(imageFileUri
						.getPath()));
			}
		}
		
		
	}

	public String getPath(Uri uri) {
		String[] projection = { MediaStore.Images.Media.DATA };
		Cursor cursor = getActivity().managedQuery(uri, projection, null, null, null);
		int column_index = cursor
				.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		return cursor.getString(column_index);
	}
}
	