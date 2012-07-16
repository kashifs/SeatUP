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


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
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

	private String tableName;
	private int numClients; 
	
	ImageButton iButton1;
	ImageButton iButton2;
	ImageButton iButton3;
	ImageButton iButton4;
	ImageButton iButton5;
	ImageButton iButton6;
	ImageButton iButton7;
	ImageButton iButton8;
	ImageButton iButton9;
	ImageButton iButton10;

	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView (R.layout.add_table_layout);
		setTitleFromActivityLabel (R.id.title_text);

		//    tablenames_array

		Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		spinner.setOnItemSelectedListener(this);

		
		iButton1 = (ImageButton) findViewById(R.id.imageButton1);
		iButton2 = (ImageButton) findViewById(R.id.imageButton2);
		iButton3 = (ImageButton) findViewById(R.id.imageButton3);
		iButton4 = (ImageButton) findViewById(R.id.imageButton4);
		iButton5 = (ImageButton) findViewById(R.id.imageButton5);
		iButton6 = (ImageButton) findViewById(R.id.imageButton6);
		iButton7 = (ImageButton) findViewById(R.id.imageButton7);
		iButton8 = (ImageButton) findViewById(R.id.imageButton8);
		iButton9 = (ImageButton) findViewById(R.id.imageButton9);
		iButton10 = (ImageButton) findViewById(R.id.imageButton10);

		iButton1.setVisibility(View.GONE);
		iButton2.setVisibility(View.GONE);
		iButton3.setVisibility(View.GONE);
		iButton4.setVisibility(View.GONE);
		iButton5.setVisibility(View.GONE);
		iButton6.setVisibility(View.GONE);
		iButton7.setVisibility(View.GONE);
		iButton8.setVisibility(View.GONE);
		iButton9.setVisibility(View.GONE);
		iButton10.setVisibility(View.GONE);




	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		String tableName = (String)arg0.getItemAtPosition(arg2);
		Toast.makeText(this, tableName, Toast.LENGTH_SHORT).show();	





	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
	}


	public void addNumClients(View v){
		numClients = Integer.parseInt((String)v.getTag());
		Toast.makeText(this, "numClients " + numClients, Toast.LENGTH_SHORT).show();
		
		if(numClients == 1){
			iButton1.setVisibility(View.VISIBLE);
			iButton2.setVisibility(View.GONE);
			iButton3.setVisibility(View.GONE);
			iButton4.setVisibility(View.GONE);
			iButton5.setVisibility(View.GONE);
			iButton6.setVisibility(View.GONE);
			iButton7.setVisibility(View.GONE);
			iButton8.setVisibility(View.GONE);
			iButton9.setVisibility(View.GONE);
			iButton10.setVisibility(View.GONE);
		}
		else if(numClients == 2){
			iButton1.setVisibility(View.VISIBLE);
			iButton2.setVisibility(View.VISIBLE);
			iButton3.setVisibility(View.GONE);
			iButton4.setVisibility(View.GONE);
			iButton5.setVisibility(View.GONE);
			iButton6.setVisibility(View.GONE);
			iButton7.setVisibility(View.GONE);
			iButton8.setVisibility(View.GONE);
			iButton9.setVisibility(View.GONE);
			iButton10.setVisibility(View.GONE);
		}
		else if(numClients == 3){
			iButton1.setVisibility(View.VISIBLE);
			iButton2.setVisibility(View.VISIBLE);
			iButton3.setVisibility(View.VISIBLE);
			iButton4.setVisibility(View.GONE);
			iButton5.setVisibility(View.GONE);
			iButton6.setVisibility(View.GONE);
			iButton7.setVisibility(View.GONE);
			iButton8.setVisibility(View.GONE);
			iButton9.setVisibility(View.GONE);
			iButton10.setVisibility(View.GONE);
		}
		else if(numClients == 4){
			iButton1.setVisibility(View.VISIBLE);
			iButton2.setVisibility(View.VISIBLE);
			iButton3.setVisibility(View.VISIBLE);
			iButton4.setVisibility(View.VISIBLE);
			iButton5.setVisibility(View.GONE);
			iButton6.setVisibility(View.GONE);
			iButton7.setVisibility(View.GONE);
			iButton8.setVisibility(View.GONE);
			iButton9.setVisibility(View.GONE);
			iButton10.setVisibility(View.GONE);
		}
		else if(numClients == 5){
			iButton1.setVisibility(View.VISIBLE);
			iButton2.setVisibility(View.VISIBLE);
			iButton3.setVisibility(View.VISIBLE);
			iButton4.setVisibility(View.VISIBLE);
			iButton5.setVisibility(View.VISIBLE);
			iButton6.setVisibility(View.GONE);
			iButton7.setVisibility(View.GONE);
			iButton8.setVisibility(View.GONE);
			iButton9.setVisibility(View.GONE);
			iButton10.setVisibility(View.GONE);
		}
		else if(numClients == 6){
			iButton1.setVisibility(View.VISIBLE);
			iButton2.setVisibility(View.VISIBLE);
			iButton3.setVisibility(View.VISIBLE);
			iButton4.setVisibility(View.VISIBLE);
			iButton5.setVisibility(View.VISIBLE);
			iButton6.setVisibility(View.VISIBLE);
			iButton7.setVisibility(View.GONE);
			iButton8.setVisibility(View.GONE);
			iButton9.setVisibility(View.GONE);
			iButton10.setVisibility(View.GONE);
		}
		else if(numClients == 7){
			iButton1.setVisibility(View.VISIBLE);
			iButton2.setVisibility(View.VISIBLE);
			iButton3.setVisibility(View.VISIBLE);
			iButton4.setVisibility(View.VISIBLE);
			iButton5.setVisibility(View.VISIBLE);
			iButton6.setVisibility(View.VISIBLE);
			iButton7.setVisibility(View.VISIBLE);
			iButton8.setVisibility(View.GONE);
			iButton9.setVisibility(View.GONE);
			iButton10.setVisibility(View.GONE);

		}
		else if(numClients == 8){
			iButton1.setVisibility(View.VISIBLE);
			iButton2.setVisibility(View.VISIBLE);
			iButton3.setVisibility(View.VISIBLE);
			iButton4.setVisibility(View.VISIBLE);
			iButton5.setVisibility(View.VISIBLE);
			iButton6.setVisibility(View.VISIBLE);
			iButton7.setVisibility(View.VISIBLE);
			iButton8.setVisibility(View.VISIBLE);
			iButton9.setVisibility(View.GONE);
			iButton10.setVisibility(View.GONE);
		}
		else if(numClients == 9){
			iButton1.setVisibility(View.VISIBLE);
			iButton2.setVisibility(View.VISIBLE);
			iButton3.setVisibility(View.VISIBLE);
			iButton4.setVisibility(View.VISIBLE);
			iButton5.setVisibility(View.VISIBLE);
			iButton6.setVisibility(View.VISIBLE);
			iButton7.setVisibility(View.VISIBLE);
			iButton8.setVisibility(View.VISIBLE);
			iButton9.setVisibility(View.VISIBLE);
			iButton10.setVisibility(View.GONE);
		}
		else if(numClients == 10){
			iButton1.setVisibility(View.VISIBLE);
			iButton2.setVisibility(View.VISIBLE);
			iButton3.setVisibility(View.VISIBLE);
			iButton4.setVisibility(View.VISIBLE);
			iButton5.setVisibility(View.VISIBLE);
			iButton6.setVisibility(View.VISIBLE);
			iButton7.setVisibility(View.VISIBLE);
			iButton8.setVisibility(View.VISIBLE);
			iButton9.setVisibility(View.VISIBLE);
			iButton10.setVisibility(View.VISIBLE);
		}
		



	}





}
