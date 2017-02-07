// import java.io.IOException;
// export CLASSPATH=$CLASSPATH:jsoup-1.10.2.jar
   
import java.io.IOException;

import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements; 
import org.jsoup.HttpStatusException;

public class DownloadDefinitions {
      
    public static void getDefinition ( String s , String whichSource) throws IOException {

        String theUrl = "";
        try {
            if ( whichSource.equals ("d1") ){
                theUrl = "http://www.thefreedictionary.com/" + s;
                
                Document doc = Jsoup.connect ( theUrl ).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").ignoreHttpErrors(true).referrer("http://www.google.com").get();
                
                Element definitionClass = doc.getElementsByClass ( "pseg").first();
                System.out.printf("%nSEARCHING : %s%n%n", theUrl); 
                
                Elements classesOnPage = doc.select(".pseg .ds-list");
                Element classOnPage;
                

                for ( int i =0; i < classesOnPage.size(); i++ ){
                    classOnPage = classesOnPage.get(i);
                        System.out.printf("%s%n", classOnPage.text());
                }
                
//                if ( definitionClass != null ) {
//                    System.out.printf("%s : %s%n", s,  definitionClass.text()); 
//                } else {
//                    System.out.printf("%s%n", "No definition found try another source." );
//                    System.out.printf("%s%n", "\"d2\""+ "\""+ s + "\"" + " \"d3\""+ "\""+ s + "\"" + " or \"d4\""+ "\""+ s );
//                }
            }
            
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (HttpStatusException e) {
            e.printStackTrace();
        } catch ( IOException e) {
            e.printStackTrace();
        }
        
        try {
            if ( whichSource.equals ("d2") ){
                theUrl = "https://www.merriam-webster.com/dictionary/" + s;
                
                Document doc = Jsoup.connect ( theUrl ).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").ignoreHttpErrors(true).referrer("http://www.google.com").get();
                
                Element definitionClass = doc.getElementsByClass ( "card-primary-content").first();
                System.out.printf("%nSEARCHING : %s%n%n", theUrl); 
                
                Elements spansOnPage = doc.select(".card-primary-content span");
                Element spanOnPage;
                               
                for ( int i =0; i < spansOnPage.size(); i++ ){
                    spanOnPage = spansOnPage.get(i);
                    if ( !spanOnPage.text().equals (":") ) {
                        System.out.printf("%s%n", spanOnPage.text());
                    }
                }
                
//                if ( definitionClass != null ) {
//                    System.out.printf("%s : %s%n", s,  definitionClass.text()); 
//                } else {
//                    System.out.printf("%s%n", "No definition found try another source." );
//                    System.out.printf("%s%n", "\"d1\""+ "\""+ s + "\"" + " \"d3\""+ "\""+ s + "\"" + " or \"d4\""+ "\""+ s );
//                }
                
            }
        
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (HttpStatusException e) {
            e.printStackTrace();
        } catch ( IOException e) {
            e.printStackTrace();
        }
        
        try {
            if ( whichSource.equals ("d3") ){
                theUrl = "http://www.dictionary.com/browse/" + s;
                
                Document doc = Jsoup.connect ( theUrl ).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").ignoreHttpErrors(true).referrer("http://www.google.com").get();
                
                Element definitionClass = doc.getElementsByClass ( "source-data").first();
                System.out.printf("%nSEARCHING : %s%n%n", theUrl); 
                
                Elements divsOnPage = doc.select(".def-set");
                Element divOnPage;
                
                for ( int i =0; i < divsOnPage.size(); i++ ){
                    divOnPage = divsOnPage.get(i);
                    System.out.printf("%s%n", divOnPage.text());
                }
                   
//                if ( definitionClass != null ) {
//                    System.out.printf("%s : %s%n", s,  definitionClass.text()); 
//                } else {
//                    System.out.printf("%s%n", "No definition found try another source." );
//                    System.out.printf("%s%n", "\"d1\""+ "\""+ s + "\"" + " \"d2\""+ "\""+ s + "\"" + " or \"d4\""+ "\""+ s );
//                }
                
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (HttpStatusException e) {
            e.printStackTrace();
        } catch ( IOException e) {
            e.printStackTrace();
        }
        
       try { // Wikipedia
            if ( whichSource.equals ("d4") ){
                theUrl = "https://en.wikipedia.org/wiki/" + s;
                Document doc = Jsoup.connect ( theUrl ).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").ignoreHttpErrors(true).referrer("http://www.google.com").get();
                
                Elements paragraphs = doc.select(".mw-content-ltr p");
                Element p;
                
                System.out.printf("%nSEARCHING : %s%n%n", theUrl); 
                
                if ( paragraphs.size() >3 ) {
                    for ( int ii =0; ii < 4; ii++ ){
                        p = paragraphs.get(ii);
                        System.out.printf("%s%n%n", p.text());
                    }
                
                }
                
            }
        } catch ( IOException e) {
            e.printStackTrace();
        }
        
         try { 
            if ( whichSource.equals ("d5") ){
                theUrl = "http://www.thesaurus.com/browse/" + s +"?s=t";
                Document doc = Jsoup.connect ( theUrl ).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").ignoreHttpErrors(true).referrer("http://www.google.com").get();
                
                Elements paragraphs = doc.select(".relevancy-list  .text");
                Element p;

                System.out.printf("%nSEARCHING : %s%n%n", theUrl);          

                    for ( int ii =0; ii < paragraphs.size(); ii++ ){
                        p = paragraphs.get(ii);
                        //System.out.printf("%s%n", p.text());
                        System.out.printf("%s  ", p.text());
                    }
                System.out.printf("%n");
            }
        } catch ( IOException e) {
            e.printStackTrace();
        }
        
        
        try { 
            if ( whichSource.equals ("d6") ){
                theUrl = "http://www.etymonline.com/index.php?term=" + s;
                Document doc = Jsoup.connect ( theUrl ).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").ignoreHttpErrors(true).referrer("http://www.google.com").get();
                
                Element paragraphs = doc.select("dd").first();
                Elements bquote = doc.select("#dictionary blockquote");
                Element paragraphs2 = doc.select("dd").last();
                
                Elements dts = doc.select("dt");
                Element dt1;
                Element dt2;
                
                int dds = doc.select("dd").size();
                
                String a = "";
                String firstParagraphText = "";
                
               // System.out.printf("XXXXXXXXX :: %d%n", dds );
                
                System.out.printf("%nSEARCHING : %s%n%n", theUrl); 
                                
                if ( ( dds >1 ) && ( paragraphs != null ) ){
                    
                    a = Jsoup.parse( paragraphs.html().replaceAll ("(?i)<br[^>]*>", "br2n").replaceAll ("<\\/?blockquote>", "XXXX") ).text();
                    firstParagraphText = a.replaceAll("br2n", "\n").replaceAll("XXX.*XXX *", "");
                    
                    dt1 = dts.get(0); 
                    dt2 = dts.get(1); 
                    
                    System.out.printf("%s%n", dt1.text() );
                    System.out.printf("%n%s%n", firstParagraphText );
                    System.out.printf("%n%s%n", bquote.text() );
                    System.out.printf("%n%s%n", dt2.text() );
                    System.out.printf("%n%s%n", paragraphs2.text() );
                } else if ( ( dds < 2 ) && ( paragraphs != null ) ){
                    a = Jsoup.parse( paragraphs.html().replaceAll ("(?i)<br[^>]*>", "br2n").replaceAll ("<\\/?blockquote>", "XXXX") ).text();
                    firstParagraphText = a.replaceAll("br2n", "\n").replaceAll("XXX.*XXX *", "");
                    dt1 = dts.get(0);             
                    System.out.printf("%s%n", dt1.text() );
                    System.out.printf("%n%s%n", firstParagraphText );
                    System.out.printf("%n%s%n", bquote.text() ); 
                } else {   
                    System.out.printf("%n%s%n", "No matching terms found at " + theUrl );  
                }
                
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (HttpStatusException e) {
            e.printStackTrace();
        } catch ( IOException e) {
            e.printStackTrace();
        }
        
        try {
            if ( whichSource.equals ("d7") ){
                theUrl = "http://medical-dictionary.thefreedictionary.com/" + s;
                
                Document doc = Jsoup.connect ( theUrl ).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").ignoreHttpErrors(true).referrer("http://www.google.com").get();
                
                Element definitionClass = doc.getElementsByClass ( "pseg").first();
                System.out.printf("%nSEARCHING : %s%n%n", theUrl); 
                
                Elements classesOnPage = doc.select(".pseg .ds-list");
                Element classOnPage;
                
                //Elements definitionClass2 = doc.getElementsByClass ( "pseg");
                Elements definitionClass2 = doc.select ( ".pseg");
                
                Element partOfSpeachs = definitionClass2.get (0);
                //Element partOfSpeach;
                //partOfSpeach = partOfSpeachs.get(2); 
                
               // System.out.printf("%s%n", definitionClass2.text() );
                //System.out.printf("%d%n", definitionClass2.size() );
                System.out.printf("%s%n", partOfSpeachs );

                //for ( int i =0; i < classesOnPage.size(); i++ ){
                    //classOnPage = classesOnPage.get(i);
                    //System.out.printf("%s%n", classOnPage.text());
                //}
                

            }
            
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (HttpStatusException e) {
            e.printStackTrace();
        } catch ( IOException e) {
            e.printStackTrace();
        }
        
                
    }
    
   
    public static void main(String[] args) throws IOException {

        String lettersIhave = args[1];
        String findMe = args[0];        
        
        if ( findMe.matches ("d[1-7]") ){
            getDefinition ( lettersIhave , findMe );
        }

        
    }
        

    
}

