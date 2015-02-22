package ca.ualberta.cs.cmput301w15t04team04project.test;

import java.io.File;

import com.example.cameratest.R;

import ca.ualberta.cs.cmput301w15t04team04project.AddEditClaimActivity;
import ca.ualberta.cs.cmput301w15t04team04project.AddEditExpenseActivity;
import ca.ualberta.cs.cmput301w15t04team04project.Claim;
import ca.ualberta.cs.cmput301w15t04team04project.ClaimList;
import ca.ualberta.cs.cmput301w15t04team04project.Item;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.test.ActivityInstrumentationTestCase2;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import junit.framework.TestCase;

public class Items_Receipts_Test extends ActivityInstrumentationTestCase2<AddEditExpenseActivity> {

	
	Activity activity;
	ClaimList claimList = ClaimListManager.getClaimList();
	Claim claim = new Claim("TestClaim");
	claimList.addClaim(claim);
	Item item = new Item("item");
	claim.addItem(item)
	
	public Items_Receipts_Test(Class<AddEditExpenseActivity> activityClass) {
		super(activityClass);
		// TODO Auto-generated constructor stub
	}
	
	//get from camera test
	
    Uri imageFileUri;
    String test;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ImageButton button = (ImageButton) findViewById(R.id.TakeAPhoto);
        OnClickListener listener = new OnClickListener() {
            public void onClick(View v){
                takeAPhoto();
            }
        };
        button.setOnClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    
    public void takeAPhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        
        String folder = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tmp";
        File folderF = new File(folder);
        if (!folderF.exists()) {
            folderF.mkdir();
        }
        
        String imageFilePath = folder + "/" + String.valueOf(System.currentTimeMillis()) + "jpg";
        File imageFile = new File(imageFilePath);
        imageFileUri = Uri.fromFile(imageFile);
        
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageFileUri);
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            TextView tv = (TextView) findViewById(R.id.status);
            if (resultCode == RESULT_OK) {
                tv.setText("Photo OK!");
                test = "Photo OK!";
                ImageButton button = (ImageButton) findViewById(R.id.TakeAPhoto);
                button.setImageDrawable(Drawable.createFromPath(imageFileUri.getPath()));
            } else if (resultCode == RESULT_CANCELED) {
                tv.setText("Photo canceled");
                test = "Photo canceled";
                
            } else {
                tv.setText("Not sure what happened!" + resultCode);
                test = "Not sure what happened!";
            }
        }
    }
    
    //
    //US06.03.01
	// test delete receipt test
	protected void deleteReceiptTest() {
		((Button) activity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.AddEditExpenseTakeReceiptButton)).performClick();
		assertTrue("deleted?",test.equals("Photo canceled"));
		Item item = new Item("test");
		item.takeAPhoto();
		assertTrue("exist photo", item.getPhoto() != null);
		item.deleteAPhoto();
		assertTrue("delete a photo", item.getPhoto() == null);
	}

	protected void addReceiptTest(){
		((Button) activity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.AddEditExpenseTakeReceiptButton)).performClick();
		assertTrue("add/",test.equals("Photo OK!"));
		Item item = new Item("test");
		item.takeAPhoto();
		assertTrue("exist photo", item.getPhoto() != null);
	}

   
    

//US06.02.01
    protected void viewReceiptTest(){
    	Item item = new Item("test");
    	item.takeAPhoto();
    	assertTrue("view Receipt",item.getPhoto().equals(imageFileUri));
    	public class ClickFunActivityTest
        extends ActivityInstrumentationTestCase2 {
    
    	Button mClickMeButton = new Button();	
    		
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);

        mClickFunActivity = getActivity();
        mClickMeButton = (Button) 
                mClickFunActivity
                .findViewById(R.id.photo);
        mInfoTextView = (TextView) 
                mClickFunActivity.findViewById(R.id.info_text_view);
    }
}

    }
    
    
    //US06.01.01
    protected void retakenReceiptTest(){
		((Button) activity.findViewById(ca.ualberta.cs.cmput301w15t04team04project.R.id.AddEditExpenseTakeReceiptButton)).performClick();
		assertTrue("add/",test.equals("Photo OK!"));
    	Item item = new Item("test");
    	item.takeAPhoto();
    	assertTrue("exist photo", item.getPhoto()!=null);
    	item.deleteAPhoto();
    	assertTrue("delete a photo", item.getPhoto()==null);
    	item.takeAPhoto();
    	assertTrue("exist photo", item.getPhoto()!=null);
    	public void testOpenNextActivity() {
    		  // register next activity that need to be monitored.
    		  ActivityMonitor activityMonitor = getInstrumentation().addMonitor(NextActivity.class.getName(), null, false);

    		  // open current activity.
    		  MyActivity myActivity = getActivity();
    		  final Button button = (Button) myActivity.findViewById(R.id.take_a_photo);
    		  myActivity.runOnUiThread(new Runnable() {
    		    @Override
    		    public void run() {
    		      // click button and open next activity.
    		      button.performClick();
    		    }
    		  });

    		  NextActivity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5);
    		  // next activity is opened and captured.
    		  assertNotNull(nextActivity);
    		  nextActivity .finish();
    		}
    	
    }
    
    


    //US06.04.01
	protected void underSizeReceiptTest() {
		Item item = new Item("test");
		item.takeAPhoto();

		assertTrue("undersize", item.getPhotoSize() <= 65536);
	}



	protected void saveReceiptTest() {
		Item item = new Item("test");
		item.takeAPhoto();
		assertTrue("exist photo", item.getPhoto() != null);
		
		// question
	}



}
