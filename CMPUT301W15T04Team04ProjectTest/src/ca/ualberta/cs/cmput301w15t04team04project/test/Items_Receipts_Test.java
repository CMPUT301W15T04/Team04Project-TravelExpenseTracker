package ca.ualberta.cs.cmput301w15t04team04project.test;

import ca.ualberta.cs.cmput301w15t04team04project.Item;
import android.content.Intent;
import android.net.Uri;
import junit.framework.TestCase;

public class Items_Receipts_Test extends TestCase {

	Uri imageFileUri;


   
    
    //test delete receipt test
    protected void deleteReceiptTest(){
    	Item item = new Item("test");
    	item.takeAPhoto();
    	assertTrue("exist photo", item.getPhoto()!=null);
    	item.deleteAPhoto();
    	assertTrue("delete a photo", item.getPhoto()==null);
    }
    
    protected void viewReceiptTest(){
    	Item item = new Item("test");
    	item.takeAPhoto();
    	assertTrue("view Receipt",item.getPhoto().equals(imageFileUri));
    	
    }
    
    protected void underSizeReceiptTest(){
     	Item item = new Item("test");
    	item.takeAPhoto();
    	
    	assertTrue("undersize", item.getPhotoSize()<=65536);
    }
    
    protected void retakenReceiptTest(){
    	Item item = new Item("test");
    	item.takeAPhoto();
    	assertTrue("exist photo", item.getPhoto()!=null);
    	item.deleteAPhoto();
    	assertTrue("delete a photo", item.getPhoto()==null);
    	item.takeAPhoto();
    	assertTrue("exist photo", item.getPhoto()!=null);
    }
    
    protected void saveReceiptTest(){
    	Item item = new Item("test");
    	item.takeAPhoto();
    	assertTrue("exist photo", item.getPhoto()!=null);
    	
    	//question 
    }

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

	}



}
