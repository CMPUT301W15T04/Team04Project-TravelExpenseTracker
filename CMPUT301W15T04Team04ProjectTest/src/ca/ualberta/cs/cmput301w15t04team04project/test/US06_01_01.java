package ca.ualberta.cs.cmput301w15t04team04project.test;

import ca.ualberta.cs.cmput301w15t04team04project.EditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.EditItemActivity;
import ca.ualberta.cs.cmput301w15t04team04project.R.drawable;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ClaimEditController;
import ca.ualberta.cs.cmput301w15t04team04project.controller.ItemEditController;
import ca.ualberta.cs.cmput301w15t04team04project.models.Item;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageButton;
import android.widget.ImageView;

public class US06_01_01 extends ActivityInstrumentationTestCase2<EditItemActivity> {
	public EditItemActivity thisActivity;
	public ItemEditController controller;
	
	public US06_01_01() {
		super(EditItemActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		thisActivity = (EditItemActivity) getActivity();
		controller = new ItemEditController();
	}

	protected void test(){
		Bitmap bitmap = Bitmap.createBitmap(256,256,Bitmap.Config.ARGB_4444);
		Item item = new Item("test");
		item.setReceipBitmap(bitmap);
		controller.addItem(item);
		
		assertFalse("Not null", item.getReceipt().isEmpty());
		
	}
	
	protected void Uitest(){
		
		assertNotNull(thisActivity);
		
		
		
		ImageButton receipt = (ImageButton) thisActivity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.addRecieptImageButton);
		assertNotNull(receipt);
		
		
	}
}
