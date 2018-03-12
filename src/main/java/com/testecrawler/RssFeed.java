package com.testecrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.testecrawler.dto.Content;
import com.testecrawler.dto.Feed;
import com.testecrawler.dto.Item;
import com.testecrawler.enums.Type;

public class RssFeed implements RssFeedImpl {
	
	
	@Override
	public Document getFeed(String url) {
		try {
			return Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String feedGeneretionJson(Document doc) {
		Feed feed = new Feed();
		Gson gson = new GsonBuilder().create();
		List<Item> items = new ArrayList<>();
		
		feed.setTitulo(doc.title());
		feed.setLink(doc.select("link").get(0).text());

		Elements elements = doc.select("item");
		for (Element element : elements) {
			Item item = new Item();
			List<Content> description = new ArrayList<>();
			
			item.setTitle(element.select("title").text());
			item.setLink(element.select("link").text());
			
			String descriptions = element.select("description").text();
			Element html = element.html(descriptions);
			
			Elements links = html.select("div a[href]");
			Elements imgs = html.select("div img[src]");
			Elements ps = html.select("p");
			
			Content imgContent = getImg(imgs);
			Content linkContent = getLinks(links);
			Content textContent = getText(ps);
			
			description.add(imgContent);
			description.add(linkContent);
			description.add(textContent);
			
			item.setContent(description);
			items.add(item);
			
			feed.setItems(items);
		}
		
		return gson.toJson(feed);
	}
	
	
	
	@Override
	public Feed feedGeneretion(Document doc) {
		Feed feed = new Feed();
		List<Item> items = new ArrayList<>();
		
		feed.setTitulo(doc.title());
		feed.setLink(doc.select("link").get(0).text());

		Elements elements = doc.select("item");
		for (Element element : elements) {
			Item item = new Item();
			List<Content> description = new ArrayList<>();
			
			item.setTitle(element.select("title").text());
			item.setLink(element.select("link").text());
			
			String descriptions = element.select("description").text();
			Element html = element.html(descriptions);
			
			Elements links = html.select("div a[href]");
			Elements imgs = html.select("div img[src]");
			Elements ps = html.select("p");
			
			Content imgContent = getImg(imgs);
			Content linkContent = getLinks(links);
			Content textContent = getText(ps);
			
			description.add(imgContent);
			description.add(linkContent);
			description.add(textContent);
			
			item.setContent(description);
			items.add(item);
			
			feed.setItems(items);
		}
		
		return feed;
	}
	
	
	private Content getLinks(Elements links) {
		Content contentLink = new Content();
		List<String> contentsItems = new ArrayList<String>();
		
		if (links.size() > 0) {
			
			contentLink.setType(Type.links);

			for (Element link : links) {
				contentsItems.add(link.attr("href"));
			}

			contentLink.setContent(contentsItems);
		}
		
		return contentLink;
	}
	
	private Content getText(Elements ps) {
		Content contentPs = new Content();
		List<String> contentsItems = new ArrayList<String>();
		
		if (ps.size() > 0) {
			contentPs.setType(Type.text);
			
			for (Element p : ps) {
				contentsItems.add(p.outerHtml());
			}
			contentPs.setContent(contentsItems);
		}
		return contentPs;
	}
	
	
	private Content getImg(Elements imgs) {
		Content contentImg = new Content();
		List<String> contentsItems = new ArrayList<String>();
		
		if (imgs.size() > 0) {
			
			contentImg.setType(Type.image);

			for (Element img : imgs) {
				contentsItems.add(img.attr("src"));
			}
			contentImg.setContent(contentsItems);
			
		}

		return contentImg;
	}
	
}

