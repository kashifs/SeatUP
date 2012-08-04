package cos.adroit.internet;
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


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * This program gets the items and prices of a store.
 * Requires a developer KEY and depends on the database at allmenus.com
 */
public class GetMenu {
	public static void main(String[] args) throws IOException {
		String url = "http://api.allmenus.com/restaurant?type=menu&restaurant_id=295328&v=2&api_key=cc2xghs2kr2xx9xd8yv6wum7";
		Document doc = Jsoup.connect(url).get();


		Elements categories = doc.select("category");
		for(Element category: categories){
			
			System.out.print(category.child(0).text() + " ");
			System.out.println();

			Elements items = category.select("item");

			for(Element item: items){
				System.out.println(item.child(0).text().split("\\(")[0]); //get rid of parenthetical information
				
				System.out.println(item.child(2).text());
				System.out.println();
			}
			//		System.out.println(doc.toString());
		}
	}
}