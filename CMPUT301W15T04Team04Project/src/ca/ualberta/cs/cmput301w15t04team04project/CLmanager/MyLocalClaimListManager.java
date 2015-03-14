package ca.ualberta.cs.cmput301w15t04team04project.CLmanager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;

import ca.ualberta.cs.cmput301w15t04team04project.models.ClaimList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.content.Context;

public class MyLocalClaimListManager {
	
	public MyLocalClaimListManager()	{
	}
	
	
	public static void saveClaimList(Context context,ClaimList claimList, String FILENAME){
		Gson gson = new Gson();
		try
		{
			FileOutputStream fos = context.openFileOutput(FILENAME, 0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			gson.toJson(claimList, osw);
			osw.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ClaimList loadClaimList(Context context, String FILENAME){
		ClaimList claimList = new ClaimList();
		Gson gson = new Gson();
		try{
			FileInputStream fis = context.openFileInput(FILENAME);
			Type listType = new TypeToken<ClaimList>(){}.getType();
			InputStreamReader isr = new InputStreamReader(fis);
			claimList = gson.fromJson(isr, listType);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (claimList == null){
			claimList = new ClaimList();
		}
		return claimList;
		
	}
}
