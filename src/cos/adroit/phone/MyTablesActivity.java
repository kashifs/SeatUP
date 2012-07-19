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
import android.view.View;
import android.widget.GridView;

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
		
		setContentView(R.layout.grid_table_layout);

		TableApp tables = ((TableApp)getApplicationContext());
		int numTables = tables.size();
		
		
        GridView gridView = (GridView) findViewById(R.id.grid_view);
        
        
        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this, numTables, tables.getOrderedTables(), tables));

	}
	
	public void addTable(View v){
        startActivity (new Intent(getApplicationContext(), AddTableActivity.class));
	}

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
