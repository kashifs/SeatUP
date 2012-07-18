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


import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.widget.TextView;

/**
 * This is the activity for feature 4 in the dashboard application.
 * It displays some text and provides a way to get back to the home activity.
 *
 */

public class AddOrdersActivity extends DashboardActivity
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

		
		Bundle extras = getIntent().getExtras();
		String[] tableData = extras.getStringArray("tableData");
	    

		setContentView (R.layout.one_client_layout);
		setTitleFromActivityLabel (R.id.title_text);

		TextView tv = (TextView) findViewById(R.id.titleTextView);
		tv.setGravity(Gravity.CENTER_HORIZONTAL);
		tv.setText(tableData[0]);

		

	}







}
