package com.jmfierro.utad.android.model;

import java.util.ArrayList;
import java.util.TreeMap;

public class PostList {
	
	private ArrayList<Post> posts;
	private TreeMap<Long, Post> byId; // Para buscar en el array
	
	//Constructor
	public PostList() {
		posts= new ArrayList<Post>();
		byId = new TreeMap<Long, Post>();
	}
	

}
