package com.testecrawler.dto;

import java.io.Serializable;
import java.util.List;

import com.testecrawler.enums.Type;

public class Content implements Serializable{

	private static final long serialVersionUID = 4139521177528588334L;
	
	private Type type;
    private List<String> content;
	
    public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public List<String> getContent() {
		return content;
	}
	public void setContent(List<String> content) {
		this.content = content;
	}
	
}
