package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class ParseStarterProjectActivity extends Activity {
	/**
	 * Called when the activity is first created.
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		ParseAnalytics.trackAppOpenedInBackground(getIntent());

		final List<Stories> stories = new ArrayList<Stories>();

//	@Override
//	public void onCreate (Bundle savedInstanceState){
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.parse_list);

		ParseQuery<Stories> query = new ParseQuery<Stories>("Stories");
		query.findInBackground(new FindCallback<Stories>() {
			@Override
			public void done(List<Stories> list, ParseException e) {
				if (e != null) {
					Toast.makeText(ParseListActivity.this, "Error " + e, Toast.LENGTH_SHORT).show();
				}
				for (Stories stories1 : list) {
					Stories newStories = new Stories();
					newStories.setTitle(Stories.getTitle());
					newStories.setbody(Stories.getbody());
					newStories.setimage(Stories.getimage());
					stories.add(newStories);
				}

				ArrayAdapter<Stories> adapter = new ArrayAdapter<Stories>(ParseListActivity.this, android.R.layout.simple_list_item_1, stories);
				setListAdapter(adapter);
			}
		});
	}
//}
}




