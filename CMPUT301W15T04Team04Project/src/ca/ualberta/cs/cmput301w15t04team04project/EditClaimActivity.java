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
package ca.ualberta.cs.cmput301w15t04team04project;

import ca.ualberta.cs.cmput301w15t04team04project.models.Claim;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class EditClaimActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_claim);

		EditText claimName = (EditText) findViewById(R.id.editClaimName);
		EditText description = (EditText) findViewById(R.id.addDescription);
		EditText tag = (EditText) findViewById(R.id.addTag);
		EditText destinationandReason = (EditText) findViewById(R.id.addDestinationandReason);
		DatePicker fromDatePicker = (DatePicker) findViewById(R.id.fromdatePicker);
		DatePicker toDatePicker = (DatePicker) findViewById(R.id.todatePicker);
		Button confirm = (Button) findViewById(R.id.action_accept);

		/**
		 * you don't need this line confirm.setOnClickListener(new AddClaim());
		 * because what we use is the function called confirm confirm(MenuItem
		 * item) is what you need to add code on
		 **/

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_claim, menu);
		return true;
	}

	public void confirm(MenuItem item) {

		// Controller clc = new Controller();
		EditText claimName = (EditText) findViewById(R.id.editClaimName);
		Claim claim = new Claim(claimName.getContext().toString());
		// clc.addClaim(claim);
		Toast.makeText(EditClaimActivity.this, "Added", Toast.LENGTH_LONG)
				.show();
		Intent intent = new Intent(EditClaimActivity.this, MainActivity.class);
		// Controller.saveClaimList();
		startActivity(intent);
	}

}
