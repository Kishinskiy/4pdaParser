package com.kishinskiy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Article> articleList = new ArrayList<>();

        Document doc = Jsoup.connect("http://4pda.ru").get();
        Elements h1Elements = doc.getElementsByAttributeValue("class","list-post-title");
        h1Elements.forEach(h1Element -> {
            Element aElement = h1Element.child(0);
            String url = aElement.attr("href");
            String title = aElement.child(0).text();

            articleList.add(new Article(url,title));
        });

        articleList.forEach(System.out::println);
    }
}
