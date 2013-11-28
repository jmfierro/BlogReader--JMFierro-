package com.jmfierro.utad.android.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.TreeMap;

public class PostList {
	
	private ArrayList<Post> posts;
	private TreeMap<Long, Post> byId; // Para buscar en el array
	
	//Constructor
	public PostList() {
		posts= new ArrayList<Post>();
		byId = new TreeMap<Long, Post>();
	}
	
	private void add(Post... postArray) { //recibe array de post
		// Convierte un array en una lista
		this.posts.addAll(Arrays.asList(postArray));
		
		for (Post post : postArray) {
			this.byId.put(post.getId(), post);
		}
	}
	

	public Post get(long id) {  // Devuelve el array
		return byId.get(id);
	}
	

	
	public ArrayList<Post> getPosts() {
		return posts;
	}
	

	private static PostList singleInstance = null;
	// para evitar que se construya cada vez que se le llame. Devuelve un sólo un post
	public synchronized static PostList getInstance() {
		//PostList ret = new PostList();
		
		if (singleInstance == null){ 		   // La primera vez utiliza el constructor,
			singleInstance = new PostList();   // (Cada threard crearía uno.)
		
			singleInstance.add(
					new Post(101, new Date(), "http://www.u-tad.com", "Primer post", null, "Este es el extracto del blog.",
							"<p><b>Lorem ipsum</b> dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>"
							+ "<p><b>Lorem ipsum</b> dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>"
							+ "<p><b>Lorem ipsum</b> dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>"),
					new Post(102, new Date(), "http://www.u-tad.com", "Segundo post", null, "Este es el extracto del blog.", "Este es el <b>contenido</b> del blog."),
					new Post(103, new Date(), "http://www.u-tad.com", "Tercer post", null, "Este es el extracto del blog.", "Este es el <b>contenido</b> del blog."),
					new Post(104, new Date(), "http://www.u-tad.com", "Cuarto post", null, "Este es el extracto del blog.", "Este es el <b>contenido</b> del blog."),
					new Post(105, new Date(), "http://www.u-tad.com", "Quinto post", null, "Este es el extracto del blog.", "Este es el <b>contenido</b> del blog."),
					new Post(106, new Date(), "http://www.u-tad.com", "Sexto post", null, "Este es el extracto del blog.", "Este es el <b>contenido</b> del blog.")
			
			);
		}
			
		return singleInstance;
	}

	
} // Fin clase PostList
