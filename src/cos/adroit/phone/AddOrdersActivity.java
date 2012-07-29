/*
 * Copyright (C) 2012 Adroit Designs
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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author Adroit Designs
 * 
 */
public class AddOrdersActivity extends Activity {

	private static final int[] ITEM_DRAWABLES = { R.drawable.green_user, R.drawable.blue_user, R.drawable.blue2_user,
		R.drawable.brown_user, R.drawable.black_user, R.drawable.orange_user, R.drawable.purple_user, R.drawable.red_user,
		R.drawable.white_user, R.drawable.yellow_user};

	private int numClients;
	private String tableName;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle extras = getIntent().getExtras();
		String[] tableData = extras.getStringArray("tableData");
		tableName = tableData[0];
		numClients = Integer.parseInt(tableData[1]);
		
		
		setContentView(R.layout.main);
		TextView tv = (TextView) findViewById(R.id.tv1);
		tv.setText(tableData[0]);

		ArcMenu menu = (ArcMenu) findViewById(R.id.arc_menu);
		
		
//		final int itemCount = numClients;
		for (int i = 0; i < numClients; i++) {
			ImageView item = new ImageView(this);
			item.setImageResource(ITEM_DRAWABLES[i]);
			

			final int position = i;
			menu.addItem(item, new OnClickListener() {

				@Override
				public void onClick(View v) {
					Toast.makeText(AddOrdersActivity.this, "position: " + position, Toast.LENGTH_SHORT).show();
					setContentView(R.layout.add_order_layout);
				}
			});// Add a menu item
		}
	}




	public void createThisTable(View v){
		TableApp tables = ((TableApp)getApplicationContext());
		tables.addTable(new Table(numClients, tableName, System.currentTimeMillis()));

		Toast toast = Toast.makeText(this, "Table " + tableName + " added to \"My Tables\".",
				Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();

		finish();
	}

}

