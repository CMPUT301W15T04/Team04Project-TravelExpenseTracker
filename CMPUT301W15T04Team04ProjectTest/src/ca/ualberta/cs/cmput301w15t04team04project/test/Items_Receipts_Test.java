package ca.ualberta.cs.cmput301w15t04team04project.test;

import ca.ualberta.cs.cmput301w15t04team04project.Item;
import android.content.Intent;
import android.net.Uri;
import junit.framework.TestCase;

public class Items_Receipts_Test extends TestCase {

	Uri imageFileUri;

	// test delete receipt test
	protected void deleteReceiptTest() {
		Item item = new Item("test");
		item.takeAPhoto();
		assertTrue("exist photo", item.getPhoto() != null);
		item.deleteAPhoto();
		assertTrue("delete a photo", item.getPhoto() == null);
	}

	protected void addReceiptTest(){
		
		Item item = new Item("test");
		item.takeAPhoto();
		assertTrue("exist photo", item.getPhoto() != null);
	}

   
    


    protected void viewReceiptTest(){
    	Item item = new Item("test");
    	item.takeAPhoto();
    	assertTrue("view Receipt",item.getPhoto().equals(imageFileUri));
    	
    }
    

    
    protected void retakenReceiptTest(){
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
