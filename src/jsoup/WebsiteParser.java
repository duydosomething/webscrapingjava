package jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebsiteParser {

	public static void main(String[] args)
	
	{
		Document document;
		
		try
		{
			//http protocol
			document = Jsoup.connect("http://steamcommunity.com/").userAgent("Chrome").get();
			
			//grab page title
			String title = document.title();
			System.out.println("The site name is: " + title);
			
			//grab all the links and print out the name of link as well as the link
			
			Elements links = document.select("a[href]");
			for(Element link: links)
			{
				System.out.println("text : " + link.text());
				System.out.println("link : " + link.attr("href"));
				
			}
		}
		//print error trace
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
