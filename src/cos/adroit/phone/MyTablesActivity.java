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



import android.R.layout;
import android.os.Bundle;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * This is a simple activity that demonstrates the dashboard user interface pattern.
 *
 */

public class MyTablesActivity extends DashboardActivity 
{

	/**
	 * onCreate - called when the activity is first created.
	 * Called when the activity is first created. 
	 * This is where you should do all of your normal static set up: create views, bind data to lists, etc. 
	 * This method also provides you with a Bundle containing the activity's previously frozen state, if there was one.
	 * 
	 * Always followed by onStart().
	 *
	 */

	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

		int numCustomers = 7;
		
		if(numCustomers == 1)
			setContentView(R.layout.activity_home);
		
		else if(numCustomers == 2)
			setContentView(R.layout.two_table_layout);
		
		else if(numCustomers == 3)
			setContentView(R.layout.three_table_layout);
		
		else if(numCustomers == 4)
			setContentView(R.layout.four_table_layout);
		
		else if(numCustomers == 5)
			setContentView(R.layout.five_table_layout);
		
		else if(numCustomers == 6)
			setContentView(R.layout.six_table_layout);
		
		else if(numCustomers == 7)
			setContentView(R.layout.seven_table_layout);
		
		else if(numCustomers == 8)
			setContentView(R.layout.eight_table_layout);


	}

	/**
	 * onDestroy
	 * The final call you receive before your activity is destroyed. 
	 * This can happen either because the activity is finishing (someone called finish() on it, 
	 * or because the system is temporarily destroying this instance of the activity to save space. 
	 * You can distinguish between these two scenarios with the isFinishing() method.
	 *
	 */

	protected void onDestroy ()
	{
		super.onDestroy ();
	}


	protected void onPause ()
	{
		super.onPause ();
	}

	protected void onRestart ()
	{
		super.onRestart ();
	}


	protected void onResume ()
	{
		super.onResume ();
	}


	protected void onStart ()
	{
		super.onStart ();
	}


	protected void onStop ()
	{
		super.onStop ();
	}

}
