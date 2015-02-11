package ca.ualberta.cs.cmput301w15t04team04project;

import java.util.Date;

import android.graphics.Bitmap;
//import android.graphics.Color;
import android.net.Uri;

public class Item {
	protected String itemname;
	protected static Bitmap bitmap;
	protected Date startdate;
	protected String categary;
	protected String des;
	protected int amount;
	protected String unit;
	protected int flag;
	
	protected Uri imageFileUri;
	
	public Item(String itemname) {
		// TODO Auto-generated constructor stub
	}


    public void takeAPhoto() {
    	takeAPhoto();
    }

   

	public String getItemname() {
		return itemname;
	}




	public void setItemname(String itemname) {
		this.itemname = itemname;
	}




	public Date getStartdate() {
		return startdate;
	}




	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}




	public String getCategary() {
		return categary;
	}




	public void setCategary(String categary) {
		this.categary = categary;
	}




	public String getDes() {
		return des;
	}




	public void setDes(String des) {
		this.des = des;
	}




	public int getAmount() {
		return amount;
	}







	public String getUnit() {
		return unit;
	}




	public void setUnit(String unit) {
		this.unit = unit;
	}




	public void addFlag() {
		this.flag = 1;
		
	}




	public void removeFlag() {
		// TODO Auto-generated method stub
		this.flag = 0;
	}




	public void setAmount(int amount) {
		this.amount = amount;
	}




	@Override
	public String toString() {
		return "Item [itemname=" + itemname + "]";
	}


	public Uri getPhoto() {
		// TODO Auto-generated method stub
		return imageFileUri;
	}


	public void deleteAPhoto() {
		// TODO Auto-generated method stub
		imageFileUri = null;
	}


	public int getPhotoSize() {
		// TODO Auto-generated method stub
		
		return 0; // size
	}



}
