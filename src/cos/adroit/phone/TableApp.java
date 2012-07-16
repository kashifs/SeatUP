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

import java.util.HashMap;


import android.app.Application;

/**
 * This is the About activity in the dashboard application.
 * It displays some text and provides a way to get back to the home activity.
 *
 */

public class TableApp extends Application 
{

	private HashMap<String, Table> _tables = new HashMap<String, Table>();


	public void addTable(Table table){
		_tables.put(table.getTableName(), table);
	}


	public void removeTable(String tableName){
		_tables.remove(tableName);
	}

	public int size(){
		return _tables.size();
	}



}
