package cos.adroit.phone;

import java.util.LinkedList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ImageAdapter extends BaseAdapter {
	private Context context;
	private int numTables;
	private LinkedList<Table> orderedTables;
	private TableApp tables;


	public ImageAdapter(Context context, int numTables, LinkedList<Table> orderedTables, TableApp tables) {
		this.context = context;
		this.numTables = numTables;
		this.orderedTables = orderedTables;
		this.tables = tables;

	}




	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


		View gridView;



		gridView = new View(context);

		// get layout from mobile.xml
		gridView = inflater.inflate(R.layout.mobile, null);


		String tableName = orderedTables.get(position).getTableName();
		// set value into textviews
		TextView textView1 = (TextView) gridView
				.findViewById(R.id.grid_item_label);

		TextView textView2 = (TextView) gridView
				.findViewById(R.id.grid_item_numClients);


		textView1.setText(tableName);

		textView2.setText("(" + tables.getTable(tableName).getNumClients() + ")");



		// set image based on selected text
		ImageView imageView = (ImageView) gridView
				.findViewById(R.id.grid_item_image);


		int mod = position % 10;
		if(mod == 0 || mod == 3 || mod == 4 || mod == 7 || mod == 8)
			imageView.setImageResource(R.drawable.blue_table);
		else 
			imageView.setImageResource(R.drawable.pink_table);



		return gridView;
	}

	@Override
	public int getCount() {
		return numTables;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

}