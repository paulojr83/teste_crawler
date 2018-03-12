package com.testecrawler.dto;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable{

	private static final long serialVersionUID = 2608000030351135832L;
	
	private String  title;
	private String link;
	private List<Content> content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<Content> getContent() {
		return content;
	}
	public void setContent(List<Content> content) {
		this.content = content;
	}
	
}
