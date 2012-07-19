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
import java.util.LinkedList;
import java.util.PriorityQueue;

import android.app.Application;

/**
 * This is the About activity in the dashboard application.
 * It displays some text and provides a way to get back to the home activity.
 *
 */



public class TableApp extends Application 
{


	public class NameDate implements Comparable<NameDate>{
		private long createDate;
		private String tableName;
		
		private NameDate(long createDate, String tableName){
			this.createDate = createDate;
			this.tableName = tableName;
		}
		
		public String getString(){
			return this.tableName;
		}
		
		public long getCreateDate(){
			return this.createDate;
		}



		@Override
		public int compareTo(NameDate that) {
			if(this.createDate < that.createDate)
				return -1;
			else if (this.createDate > that.createDate)
				return 1;
			else
				return 0;
		}

	}


	private HashMap<String, Table> _tables = new HashMap<String, Table>();
	private LinkedList<Table> orderedTables = new LinkedList<Table>();

	public void addTable(Table table){
		_tables.put(table.getTableName(), table);
		orderedTables.add(table);

	}
	
	public Table getTable(String tableName){
		return _tables.get(tableName);
	}
	
	public boolean hasTableName(String tableName){
		
		return _tables.containsKey(tableName);
		
	}


	public void removeTable(String tableName){
		_tables.remove(tableName);
	}

	public int size(){
		return _tables.size();
	}

	public LinkedList<Table> getOrderedTables(){
		return orderedTables;

	}



}
