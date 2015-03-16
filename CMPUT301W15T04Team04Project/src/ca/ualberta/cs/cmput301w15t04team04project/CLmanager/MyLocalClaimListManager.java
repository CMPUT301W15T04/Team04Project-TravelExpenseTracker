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

/**
 * @author Youdong Ma
 *
 */
public class MyLocalClaimListManager {
	protected static String FILENAME = "LocalClaimList";

	/**
	 * 
	 */
	public MyLocalClaimListManager() {
	}

	/**
	 * save claimList in certain file
	 * @author Youdong Ma
	 * @param context
	 * @param claimList
	 */
	public static void saveClaimList(Context context, ClaimList claimList) {
		Gson gson = new Gson();
		try {
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

	/**
	 * load claimList form certain file
	 * @author Youdong Ma
	 * @param context
	 * @return
	 */
	public static ClaimList loadClaimList(Context context) {
		ClaimList claimList = new ClaimList();
		Gson gson = new Gson();
		try {
			FileInputStream fis = context.openFileInput(FILENAME);
			Type listType = new TypeToken<ClaimList>() {
			}.getType();
			InputStreamReader isr = new InputStreamReader(fis);
			claimList = gson.fromJson(isr, listType);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (claimList == null) {
			claimList = new ClaimList();
		}
		return claimList;

	}
}
