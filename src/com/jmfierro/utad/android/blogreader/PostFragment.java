package com.jmfierro.utad.android.blogreader;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jmfierro.utad.android.model.Post;

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
		
		TextView title = (TextView) vf.findViewById(R.id.titleTextView);
		
		
		return vf;
	}

}
