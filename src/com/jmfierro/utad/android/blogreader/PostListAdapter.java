package com.jmfierro.utad.android.blogreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmfierro.utad.android.model.PostList;

public class PostListAdapter extends BaseAdapter {
	
	private PostList posts;
	private Context ctx;
	
	PostListAdapter (Context ctx, PostList posts){
		
		this.posts = posts;
		this.ctx = ctx;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		
		return posts.getPosts().size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return posts.getPosts().get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return posts.getPosts().get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Si no existe crea nueva vista
		if (convertView == null) {
			LayoutInflater inflater  = 
					(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.post_list_item, null);
		}
		
		// Sentencia Item
		TextView title  = (TextView) convertView.findViewById(R.id.postTitle);
		title.setText(posts.getPosts().get(position).getTitle());
		
		// icono Item
		ImageView imagen = (ImageView) convertView.findViewById(R.id.thumbnail);
		//
		if (this.posts.getPosts().get(position).getPicUrl() == null) {
		    imagen.setImageResource(R.drawable.ic_launcher);
		}
		return convertView;
	}

}
