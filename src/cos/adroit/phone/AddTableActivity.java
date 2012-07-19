/*
 * Copyright (C) 2011 Wglxy.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cos.adroit.phone;


import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * This is the activity for feature 4 in the dashboard application.
 * It displays some text and provides a way to get back to the home activity.
 *
 */

public class AddTableActivity extends DashboardActivity implements OnItemSelectedListener
{

	/**
	 * onCreate
	 *
	 * Called when the activity is first created. 
	 * This is where you should do all of your normal static set up: create views, bind data to lists, etc. 
	 * This method also provides you with a Bundle containing the activity's previously frozen state, if there was one.
	 * 
	 * Always followed by onStart().
	 *
	 * @param savedInstanceState Bundle
	 */

	private String tableName, now;
	private int numClients;


	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView (R.layout.add_table_layout);
		setTitleFromActivityLabel (R.id.title_text);

		TableApp tables = ((TableApp)getApplicationContext());

		// Array of choices
		String allNames[] = {"Alpha", "Bravo","Charlie","Delta","Echo","Foxtrot",
				"Golf","Hotel","India","Juliet","Kilo","Lima","Mike","November","Oscar",
				"Papa","Quebec","Romeo","Sierra","Tango","Uniform","Victor","Whiskey",
				"X-ray","Yankee","Zulu"};

		int numFree = 0; //not taken

		for(int i = 0; i < allNames.length; i++){
			if(!tables.hasTableName(allNames[i]))
				numFree++;
		}

		String[] freeNames = new String[numFree];

		int k = 0;

		//allNames.length() = 26
		for(int i = 0; i < 26; i++){
			if(!tables.hasTableName(allNames[i]))
				freeNames[k++] = allNames[i]; 
		}



		// Selection of the spinner
		Spinner sTableName = (Spinner) findViewById(R.id.spinner1);

		// Application of the Array to the Spinner
		ArrayAdapter<String> spinnerArrayAdapter = 
				new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, freeNames);
		spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down vieww
		sTableName.setAdapter(spinnerArrayAdapter);


		sTableName.setOnItemSelectedListener(this);

		Spinner sNumClients = (Spinner) findViewById(R.id.spinner2);
		sNumClients.setOnItemSelectedListener(this);

		Spinner sAddTableNow = (Spinner) findViewById(R.id.spinner3);
		sAddTableNow.setOnItemSelectedListener(this);



	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {



		if(arg0.getId() == R.id.spinner1)
			tableName = (String)arg0.getItemAtPosition(arg2);

		if(arg0.getId() == R.id.spinner2)
			numClients = Integer.parseInt((String)arg0.getItemAtPosition(arg2));

		if(arg0.getId() == R.id.spinner3)
			now = (String)arg0.getItemAtPosition(arg2);




		//		Toast.makeText(this, tableName + " " + numClients + " " + now, Toast.LENGTH_SHORT).show();	



	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
	}


	public void addNumClients(View v){
		numClients = Integer.parseInt((String)v.getTag());
		Toast.makeText(this, "numClients " + numClients, Toast.LENGTH_SHORT).show();

	}

	public void createThisTable(View v){


		if(now.equalsIgnoreCase("Yes")){
			String[] tableData = {tableName, numClients+""};
			Intent i = new Intent(getApplicationContext(), AddOrdersActivity.class);
			i.putExtra("tableData", tableData);

			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity (i);			
		}
		else{


			TableApp tables = ((TableApp)getApplicationContext());
			tables.addTable(new Table(numClients, tableName, System.currentTimeMillis()));


			Toast toast = Toast.makeText(this, "Table " + tableName + " created. Look in " +
					"\"My Tables\" to edit this table", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();

			finish();
		}

	}





}
