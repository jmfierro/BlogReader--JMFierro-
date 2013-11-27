package com.jmfierro.utad.android.model;

import java.util.Date;

import com.utad.android.blogreader.model.Post;

import android.os.Parcel;
import android.os.Parcelable;

public class Post implements Parcelable{
	
	private long id;
	private Date date;
	private String title;
	private String picUrl;
	private String excerpt;
	private String body;
	private String url;
	
	
	// *************************************************************
	// Para pasar objeto Post como parametros a otra actividad
	// 
	// *************************************************************
	public final static Parcelable.Creator<Post> CREATOR = new Creator<Post>() {
		
		@Override
		public Post[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Post[size];
		}
		
		@Override
		public Post createFromParcel(Parcel source) {
			long id = source.readLong();

			String url = source.readString();
			String title = source.readString();
			String picUrl = source.readString();
			String excerpt = source.readString();
			String body = source.readString();
			long milliseconds = source.readLong();
			Date date = null;
			if (milliseconds != Long.MIN_VALUE) {
				date = new Date(milliseconds);
			}

			return new Post(id, date, url, title, picUrl, excerpt, body);
		}
	};


	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
	}


	public Post(long id, Date date, String title, String picUrl,
			String excerpt, String body, String url) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.picUrl = picUrl;
		this.excerpt = excerpt;
		this.body = body;
		this.url = url;
	} 
	
	
}
