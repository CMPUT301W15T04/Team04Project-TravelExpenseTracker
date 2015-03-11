package ca.ualberta.cs.cmput301w15t04team04project.CLmanager;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import ca.ualberta.cs.cmput301w15t04team04project.SignInActivity;
import ca.ualberta.cs.cmput301w15t04team04project.models.User;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.content.Context;

public class SignInManager{
	//private static String FILENAME = "UserStatus";
	public static User user = new User(null);

	public SignInManager()	{
	}
	
	
	public static User loadFromFile(Context context, String FILENAME)
	{
		User user = new User(null);
		
		Gson gson = new Gson();
		try{
			FileInputStream fis = context.openFileInput(FILENAME);
			
			Type listType = new TypeToken<User>(){}.getType();
			InputStreamReader isr = new InputStreamReader(fis);
			user = gson.fromJson(isr, listType);
			fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (user == null){
			user = new User(null);
		}
		return user;
	}

	
	
	public static void saveInFile(User user, Context context, String FILENAME)
	{

		Gson gson = new Gson();
		try
		{
			FileOutputStream fos = context.openFileOutput(FILENAME, 0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			gson.toJson(user, osw);
			osw.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
