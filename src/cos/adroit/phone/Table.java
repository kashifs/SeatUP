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

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import android.util.Log;



public class Table 
{
	private String TAG = "Table";
	private int _numClients;
	private Customer[] _customers;
	private final static String _storeURL = "http://www.allmenus.com/pa/philadelphia/64620-papa-johns-pizza/menu/";

	//constructor
	public Table(int numClients){
		this._numClients = numClients;
		this._customers = new Customer[_numClients];
	}






	private class Customer{
		private boolean _adult, _gender; // "true" is female
		private Order _order;


		private Customer(boolean adult, boolean gender, Order order){
			this._adult = adult;
			this._gender = gender;
			this._order = order;
		}




		private class Order{
			private String _entree, _drink;
			private float _price;

			private Order(String entree, String drink){
				if(entree == null)
					Log.e(TAG, "FAILED TO PASS ENTREE CORRECTLY!");
				if(drink == null)
					Log.e(TAG, "FAILED TO PASS DRINK CORRECTLY");

				this._entree = entree;
				this._drink = drink;

				getOrderTotal();
			}

			private Order(String entree){
				if(entree == null)
					Log.e(TAG, "FAILED TO PASS ENTREE CORRECTLY!");


				this._entree = entree;
				this._drink = "water";


				getOrderTotal();
			}



			private void getOrderTotal() {


				Document doc = null;
				try {
					doc = Jsoup.connect("http://en.wikipedia.org/").get();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Elements newsHeadlines = doc.select(".name .price");
				System.out.println(newsHeadlines.toString());
				
				

			}
		}
	}
}



