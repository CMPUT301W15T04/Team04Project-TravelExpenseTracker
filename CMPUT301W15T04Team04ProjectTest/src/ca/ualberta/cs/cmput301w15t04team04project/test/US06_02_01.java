package ca.ualberta.cs.cmput301w15t04team04project.test;

import ca.ualberta.cs.cmput301w15t04team04project.EditItemActivity;
import ca.ualberta.cs.cmput301w15t04team04project.ItemDetailActivity;
import ca.ualberta.cs.cmput301w15t04team04project.OneClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.R;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ItemEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.test.ActivityInstrumentationTestCase2;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class US06_02_01 extends ActivityInstrumentationTestCase2<OneClaimActivity> {
	public OneClaimActivity thisActivity;
	public ItemEditController controller;
	
	public US06_02_01() {
		super(OneClaimActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		//thisActivity = (OneClaimActivity) getActivity();
		controller = new ItemEditController();
	}

	public void test(){
		Bitmap bitmap = Bitmap.createBitmap(256,256,Bitmap.Config.ARGB_4444);
		Item item = new Item("test");
		item.setReceipBitmap(bitmap);
		controller.addItem(item);
		
		assertFalse("Not null", item.getReceipt().isEmpty());
		
	}
	
	public void Uitest(){
		
		//assertNotNull(thisActivity);
		
		AlertDialog.Builder adb = new AlertDialog.Builder(thisActivity);

		LayoutInflater factory = LayoutInflater.from(thisActivity);
		View itemInfoCDialogView = factory.inflate(
				R.layout.activity_item_detail_a, null);
		adb.setView(itemInfoCDialogView);
		
		ImageView receiptImageView = (ImageView) itemInfoCDialogView
				.findViewById(R.id.currentRecieptImageView);
		assertNotNull(receiptImageView);
	}
}
