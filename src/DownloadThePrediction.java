import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DownloadThePrediction implements Runnable{
    private static Document doc;
    public static String[] magicWords;
    private String regexOne = "[\\n\\p{Punct}\\da-zA-Z]";
    private String regexTwo = "^ +| +$|( )+";

    @Override
    public void run() {
        try{
            doc  = Jsoup.connect("https://uznayvse.ru/goroskop/all.html").get();
        } catch (IOException e){ System.out.println("Упс! Сегодня как-нибудь без помощи высших сил!");}

        Elements predictions = doc.select("article");
        String OneStringPrediction = predictions.toString().replaceAll(regexOne,"").replaceAll(regexTwo, " ").toLowerCase();
        
        magicWords = OneStringPrediction.split(" ");


    }

}
