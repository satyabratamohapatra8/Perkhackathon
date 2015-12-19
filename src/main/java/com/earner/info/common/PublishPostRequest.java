package com.earner.info.common;

public class PublishPostRequest {
	private String postContent;
	private short postType;
	private Long postAgainstPostId;
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
	public Long getPostAgainstPostId() {
		return postAgainstPostId;
	}
	public void setPostAgainstPostId(Long postAgainstPostId) {
		this.postAgainstPostId = postAgainstPostId;
	}
	
	
}
