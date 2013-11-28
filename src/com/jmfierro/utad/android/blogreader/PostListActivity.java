package com.jmfierro.utad.android.blogreader;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.jmfierro.utad.android.model.PostList;

public class PostListActivity extends Activity {
	
	private PostList posts;
	private boolean inTablet;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post_list);
		
		// Datos para la lista
		posts = PostList.getInstance();
		// Lista
		final ListView l = (ListView) findViewById(R.id.postListView);
		l.setAdapter(new PostListAdapter(this,posts));
		
		l.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View arg1, int position,
					long id) {
				
				l.setItemChecked(position, true);
				
			} // fin onItemClick()
		}); // fin OnItemClickListener()
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.post_list, menu);
		return true;
		
	}

}
