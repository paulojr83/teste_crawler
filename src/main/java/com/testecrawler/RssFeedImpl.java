package com.testecrawler;

import org.jsoup.nodes.Document;

import com.testecrawler.dto.Feed;

public interface RssFeedImpl {

	Document getFeed(String url);
	String feedGeneretionJson(Document doc);
	Feed feedGeneretion(Document doc);
}
