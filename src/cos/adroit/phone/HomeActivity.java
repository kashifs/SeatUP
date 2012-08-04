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



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

/**
 * This is a simple activity that demonstrates the dashboard user interface pattern.
 *
 */

public class HomeActivity extends DashboardActivity
{

	public static final String PREFS_NAME = "MyPrefsFile";
	public static final String TAG = "HomeActivity";
	private String hiMessage = "Welcome to SeatUP. Your mobile solution for providing quality service.";
	private String userName;

	private SharedPreferences settings;
	private SharedPreferences.Editor editor;
	
	


	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);


		TableApp tables = ((TableApp)getApplicationContext());
		int numTables = tables.size();

		getAccountName();
		
		

		//get user settings for sound and vibration
		settings = getSharedPreferences(PREFS_NAME, 0);
		editor = settings.edit();
		
		if (!settings.contains("isFirstTime")) {
			editor.putBoolean("isFirstTime", false);
			editor.commit();
		} 


	}

	private void getAccountName() {
		Account[] accounts = AccountManager.get(this).getAccountsByType("com.google");

		if(accounts.length != 0){
			userName = accounts[0].name;
			userName = userName.substring(0, userName.length() - 10); //get rid of @gmail.com
		}else
			userName = "emulator";
		
		Log.v(TAG, "The username is currently: " + userName);

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

	/**
	 * onPause
	 * Called when the system is about to start resuming a previous activity. 
	 * This is typically used to commit unsaved changes to persistent data, stop animations 
	 * and other things that may be consuming CPU, etc. 
	 * Implementations of this method must be very quick because the next activity will not be resumed 
	 * until this method returns.
	 * Followed by either onResume() if the activity returns back to the front, 
	 * or onStop() if it becomes invisible to the user.
	 *
	 */

	protected void onPause ()
	{
		super.onPause ();
	}

	/**
	 * onRestart
	 * Called after your activity has been stopped, prior to it being started again.
	 * Always followed by onStart().
	 *
	 */

	protected void onRestart ()
	{
		super.onRestart ();
	}

	/**
	 * onResume
	 * Called when the activity will start interacting with the user. 
	 * At this point your activity is at the top of the activity stack, with user input going to it.
	 * Always followed by onPause().
	 *
	 */

	protected void onResume ()
	{
		super.onResume ();
	}

	/**
	 * onStart
	 * Called when the activity is becoming visible to the user.
	 * Followed by onResume() if the activity comes to the foreground, or onStop() if it becomes hidden.
	 *
	 */

	protected void onStart ()
	{
		super.onStart ();
		
		
		boolean isFirstTime = settings.getBoolean("firstTime", true);
		if (isFirstTime || !isFirstTime) {
			AlertDialog.Builder tutorialBuilder = new AlertDialog.Builder(this);
			LayoutInflater inflater = LayoutInflater.from(this);
			View tutorialLayout = inflater.inflate(R.layout.welcome_layout, null);
			tutorialBuilder.setView(tutorialLayout);
			final CheckBox dontShowAgain = (CheckBox)tutorialLayout.findViewById(R.id.dontShowAgain);
			tutorialBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface d, int m) {
					boolean checked = dontShowAgain.isChecked();
					if (checked) {
						editor.putBoolean("firstTime", false);
						editor.commit();
					}
				}
			});
			tutorialBuilder.setMessage(hiMessage);
			tutorialBuilder.show();
		}
		
		
//		File sdCard = Environment.getExternalStorageDirectory();
//		File dir = new File (sdCard.getAbsolutePath() + "/SeatUpMenu");
//		Log.v(TAG, "The file is at: " + dir.getAbsolutePath());
//		dir.mkdirs();
		
//		File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/menu.xml");


		
		String url = "http://api.allmenus.com/restaurant?type=menu&restaurant_id=59434&v=2&api_key=cc2xghs2kr2xx9xd8yv6wum7";
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
//			FileOutputStream fos = openFileOutput("menu.xml", Context.MODE_PRIVATE);
			
			FileOutputStream fos = openFileOutput("menu2.xml", Context.MODE_PRIVATE);
			fos.write(doc.toString().getBytes());
			
//			BufferedWriter out1 = new BufferedWriter(new FileWriter(file));
			
//			out1.write(doc.toString());
			
//			out1.close();
			fos.close();
			
			
			StringBuffer strContent = new StringBuffer("");
			int ch;
			FileInputStream fis = openFileInput("menu2.xml");
			
			while( (ch = fis.read()) != -1)
		        strContent.append((char)ch);
			
			Log.v(TAG, strContent.toString());
			
			
			
		} catch (IOException e) {
			Log.e(TAG, "Error while downloading menu");
			e.printStackTrace();
		}
		
		
		
		
	}

	/**
	 * onStop
	 * Called when the activity is no longer visible to the user
	 * because another activity has been resumed and is covering this one. 
	 * This may happen either because a new activity is being started, an existing one 
	 * is being brought in front of this one, or this one is being destroyed.
	 *
	 * Followed by either onRestart() if this activity is coming back to interact with the user, 
	 * or onDestroy() if this activity is going away.
	 */

	protected void onStop ()
	{
		super.onStop ();
	}

	/**
	 */
	// Click Methods


	/**
	 */
	// More Methods

} // end class
