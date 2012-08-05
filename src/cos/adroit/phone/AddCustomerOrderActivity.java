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

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author Adroit Designs
 * 
 */
public class AddCustomerOrderActivity extends Activity {

	private static final int[] ITEM_DRAWABLES = { R.drawable.green_user, R.drawable.blue_user, R.drawable.blue2_user,
		R.drawable.brown_user, R.drawable.black_user, R.drawable.orange_user, R.drawable.purple_user, R.drawable.red_user,
		R.drawable.white_user, R.drawable.yellow_user};


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		Bundle extras = getIntent().getExtras();
		int customerNum = extras.getInt("customerNum");



		setContentView(R.layout.add_customer_order_layout);
		LinearLayout mainLL = (LinearLayout) findViewById(R.id.main_linear_layout);



		LayoutParams lparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);


		TextView tv;
		Spinner spin;
		String[] spinArrayName;
		String[] spinArrayPrice;
		ArrayAdapter<String> spinnerArrayAdapter;





		String url = "http://api.allmenus.com/restaurant?type=menu&restaurant_id=59434&v=2&api_key=cc2xghs2kr2xx9xd8yv6wum7";
		Document doc;
		try {
			doc = Jsoup.connect(url).get();



			Elements categories = doc.select("category");
			for(Element category: categories){

				//				System.out.print(category.child(0).text());
				tv=new TextView(this);
				spin = new Spinner(this);
				tv.setText(category.child(0).text());
				tv.setGravity(Gravity.CENTER_HORIZONTAL);
				tv.setTextAppearance(this, R.style.TitleBarText);
				mainLL.addView(tv);

				Elements items = category.select("item");
				int i = 1;
				spinArrayName = new String[items.size() + 1];
				spinArrayName[0] = "";
				
				spinArrayPrice = new String[items.size() + 1];
				spinArrayPrice[0] = "";
				for(Element item: items){

					spinArrayName[i] = item.child(0).text().split("\\(")[0];// + "\t" + item.child(2).text();
					
					spinArrayPrice[i++] = item.child(2).text();


				}
				
//				Arrays.sort(spinArray);
				

				final List<NamePrice> spinnerContent = new LinkedList<NamePrice>();
				
				for(int z = 0; z < spinArrayName.length; z++){
					spinnerContent.add(new NamePrice(spinArrayName[z], spinArrayPrice[z]));
				}
				final MenuSpinnerAdapter adapter = new MenuSpinnerAdapter(spinnerContent, this);
				spin.setAdapter(adapter);
				

				

				mainLL.addView(spin);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {



		Toast.makeText(this, "text", Toast.LENGTH_SHORT).show();
		

	


	}


}

