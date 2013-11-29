package com.jmfierro.utad.android.blogreader;

import java.text.DateFormat;
import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jmfierro.utad.android.model.Post;
import com.jmfierro.utad.android.model.PostList;

public class PostFragment extends Fragment {
	
	public final static String POST_ID_EXTRA = "postId";
	private Post post;
	
//	public PostFragment (Post post) {
//		
//		this.post= post;
//		
//	}
//	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View vf = inflater.inflate(R.layout.fragment_post,container,false);
		
		Long postId = getArguments().getLong(POST_ID_EXTRA);
		post = PostList.getInstance().get(postId);
		
		TextView title = (TextView) vf.findViewById(R.id.titleTextView);
		title.setText(post.getTitle());
		
		TextView bodyTv = (TextView) vf.findViewById(R.id.bodyTextView);
		if (post.getBody() != null) {
			bodyTv.setText( Html.fromHtml(post.getBody()) );
		}
		
		TextView dateTv = (TextView) vf.findViewById(R.id.dateTextView);
		if (post.getDate() != null) {
			DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
			dateTv.setText( df.format(post.getDate()) );
		}
		
		return vf;
	}
 
}
