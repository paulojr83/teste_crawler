package com.testecrawler.enums;

public enum Type {
	text( "text" ),
	image( "image" ),
	links( "links" );
    
	private String value;

	private Type( String value ) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
