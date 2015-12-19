package com.earner.info.core.model;

public class Post {
	private long postId;
	private long postedBy;
	private String postContent;
	private short postType;
	public long getPostId() {
		return postId;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}
	public long getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(long postedBy) {
		this.postedBy = postedBy;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public short getPostType() {
		return postType;
	}
	public void setPostType(short postType) {
		this.postType = postType;
	}
	
}
