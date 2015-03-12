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
	private static Gson gson = new Gson();
	final private String FILENAME = "localclaimlist";
	private Context context;
	static private MyLocalClaimListManager myLocalClaimListManager = null;
	
	public static MyLocalClaimListManager getMyLocalClaimListManager(){
		
		return myLocalClaimListManager;
	}
	
	public MyLocalClaimListManager(Context context){
		this.context = context;
	}
	
	public void saveClaimList(ClaimList claimList){
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
	
	public ClaimList loadClaimList(){
		ClaimList claimList = new ClaimList();
		
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
		return claimList;
	}
}
