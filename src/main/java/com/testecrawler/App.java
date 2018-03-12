package com.testecrawler;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Document;

import com.testecrawler.dto.Feed;
import com.testecrawler.dto.Item;

public class App 
{
    public static void main( String[] args ) throws IOException
    {

    	String url = "https://revistaautoesporte.globo.com/rss/ultimas/feed.xml";
		Document doc = new RssFeed().getFeed(url);
		String json = new RssFeed().feedGeneretionJson(doc);
		//Feed feed = new RssFeed().feedGeneretion(doc);
		System.out.println(json);
		/*
		 * List<Item> items = feed.getItems();
		for (Item item : items) {
			System.out.println(item.getTitle());
		}
		*/

    }
}
