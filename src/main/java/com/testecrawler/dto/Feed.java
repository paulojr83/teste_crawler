package com.testecrawler.dto;

import java.io.Serializable;
import java.util.List;

public class Feed implements Serializable {

	private static final long serialVersionUID = -1104951321120179566L;
	
	private String titulo;
	private String link;
	private List<Item> items;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Feed [titulo=");
		builder.append(titulo);
		builder.append(", link=");
		builder.append(link);
		builder.append(", items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
