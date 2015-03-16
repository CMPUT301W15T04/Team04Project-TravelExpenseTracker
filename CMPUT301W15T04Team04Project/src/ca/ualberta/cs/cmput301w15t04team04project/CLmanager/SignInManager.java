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
import ca.ualberta.cs.cmput301w15t04team04project.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.content.Context;

/**
 * The SignInManager is use to store the local user profile
 *
 * @author Chenrui Lei
 * @version 1.0
 * @since 2015-03-11
 */
public class SignInManager {
	// private static String FILENAME = "UserStatus";
	public static User user = new User(null);

	public SignInManager() {
	}

	public static User loadFromFile(Context context, String FILENAME) {
		User user = new User(null);

		Gson gson = new Gson();
		try {
			FileInputStream fis = context.openFileInput(FILENAME);

			Type listType = new TypeToken<User>() {
			}.getType();
			InputStreamReader isr = new InputStreamReader(fis);
			user = gson.fromJson(isr, listType);
			fis.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (user == null) {
			user = new User(null);
		}
		return user;
	}

	public static void saveInFile(User user, Context context, String FILENAME) {

		Gson gson = new Gson();
		try {
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
