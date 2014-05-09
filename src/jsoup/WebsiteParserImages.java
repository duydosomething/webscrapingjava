package jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebsiteParserImages {

	public static void main(String[] args)
	{
		Document document;
		//connect to yahoo and grab all the images in the format of png, jpeg, or gif
		try{
			document = Jsoup.connect("http://www.yahoo.com").userAgent("Chrome").get();
			Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
			for(Element image: images)
			{
				//print out the source, height, width, and alternative for the image
				System.out.println("src: " + image.attr("src"));
				System.out.println("height: " + image.attr("height") + " width: " + image.attr("width"));
				System.out.println("alt: " + image.attr("alt"));
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
