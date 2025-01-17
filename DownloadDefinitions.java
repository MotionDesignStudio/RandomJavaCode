import java.io.IOException;

import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;  
import org.jsoup.select.Elements; 
import org.jsoup.HttpStatusException;
import org.jsoup.safety.Whitelist;

// I used this in d5 to arrange list alphabetically
import java.util.ArrayList;
import java.util.Collections;

// These I need to make a system call to mplayer
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DownloadDefinitions {
    // Help
    public static void HelpSection ( ) {
        System.out.printf("%s%n%n", "Example:  java -cp .:./jsoup-1.10.2.jar DownloadDefinitions " +'"'+ "d1"+'"'+ '"'+"love" +'"' );
        System.out.printf("%s%n", "Command | Searches ↓" );
        System.out.printf("%s%n", "     d1 | http://www.thefreedictionary.com" );
        System.out.printf("%s%n", "     d2 | https://www.merriam-webster.com" );
        System.out.printf("%s%n", "     d3 | http://www.dictionary.com" );
        System.out.printf("%s%n", "     d4 | https://en.wikipedia.org" );
        System.out.printf("%s%n", "     d5 | http://www.thesaurus.com" );
        System.out.printf("%s%n", "     d6 | http://www.etymonline.com" );
        System.out.printf("%s%n", "     d7 | http://medical-dictionary.thefreedictionary.com" );
        System.out.printf("%s%n", "     d8 | http://legal-dictionary.thefreedictionary.com" );
        System.out.printf("%s%n", "     d9 | http://acronyms.thefreedictionary.com" );
        System.out.printf("%s%n", "    d10 | http://www.urbandictionary.com" );
        System.out.printf("%s%n", "    d11 | https://www.merriam-webster.com/ Medical Dictionary" );
        System.out.printf("%s%n", "    d12 | http://www.netlingo.com" );
        System.out.printf("%s%n", "    d13 | http://dictionary.cambridge.org" );
        System.out.printf("%s%n", "    d14 | https://plato.stanford.edu" );
        System.out.printf("%s%n", "    d15 | https://www.merriam-webster.com/thesaurus" );
		System.out.printf("%s%n", "    d16 | http://suggest.aspell.net" );
		System.out.printf("%s%n", "    d17 | Pronounce Words Using Google" );
    }
    
    
    public static String br2nl(String html) {
        String returnMe="";
        String[] replaceMe = {"&lt;", "&gt;"};
        String[] replaceMeWith = {"<", ">"};
               
        if(html==null)
            return html;
        Document document = Jsoup.parse(html);
        document.outputSettings(new Document.OutputSettings().prettyPrint(false));//makes html() preserve linebreaks and spacing
        document.select("br").append("\\n");
        document.select("p").prepend("\\n");
        String s = document.html().replaceAll("\\\\n", "\n");
        returnMe = Jsoup.clean(s, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
        
        for ( int i = 0; i< replaceMe.length; i++ ) {
            returnMe = returnMe.replaceAll( replaceMe[i] , replaceMeWith[i] ); 
        }
        
        return returnMe;
    }
    
      
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
                                   
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (HttpStatusException e) {
            e.printStackTrace();
        } catch ( IOException e) {
            e.printStackTrace();
        }
        
       try { 
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
                
				// Arraylist to store values so they can be alphabetized
				ArrayList<String> alphabetizedMeSynonyms = new ArrayList<String>();
				ArrayList<String> alphabetizedMeAntonyms = new ArrayList<String>();
							
				// Begin select Synonyms
				Elements content = doc.getElementsByClass("css-1lc0dpe et6tpn80");
				Elements links = content.select("a[href]");
				Elements synonymslinks = content.get(0).select("a[href]");
				// End select Synonyms
				
				// Begin select Antonyms
				Elements contentAntonyms = doc.getElementsByClass("antonyms-container css-14xt5dz e1991neq0");
				Elements linksAntonyms = contentAntonyms.select("a[href]");
				// End select Antonyms
								
                System.out.printf("%nSEARCHING : %s%n%n", theUrl);   
				
				for ( Element link : synonymslinks ){
					alphabetizedMeSynonyms.add( link.text() );
				}
				
				Collections.sort(alphabetizedMeSynonyms);
				System.out.printf("%s  %n", "SYNONYMS :: \n\n" + alphabetizedMeSynonyms);
				
				for ( Element link : linksAntonyms ){
					alphabetizedMeAntonyms.add( link.text() );
				}
				Collections.sort(alphabetizedMeAntonyms);
				
				System.out.printf("%s  ", "\nANTONYMS :: \n\n" + alphabetizedMeAntonyms );
				
                System.out.printf("%n%n");
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

                System.out.printf("%nSEARCHING : %s%n%n", theUrl); 
                Element classOnPage;
                
                Elements definitionClass3 = doc.select ( "section" );               
                
                for ( int i =0; i < definitionClass3.size()-2; i++ ){
                    classOnPage = definitionClass3.get(i);
                    System.out.printf("%s%n%n", classOnPage.text());
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
            if ( whichSource.equals ("d8") ){
                theUrl = "http://legal-dictionary.thefreedictionary.com/" + s;
                
                Document doc = Jsoup.connect ( theUrl ).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").ignoreHttpErrors(true).referrer("http://www.google.com").get();

                System.out.printf("%nSEARCHING : %s%n%n", theUrl); 
                Element classOnPage;
                Elements definitionClass3 = doc.select ( "section" );
                
                for ( int i =0; i < definitionClass3.size()-2; i++ ){
                    classOnPage = definitionClass3.get(i);
                    System.out.printf("%s%n%n", classOnPage.text());
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
            if ( whichSource.equals ("d9") ){
                theUrl = "http://acronyms.thefreedictionary.com/" + s;
                
                Document doc = Jsoup.connect ( theUrl ).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").ignoreHttpErrors(true).referrer("http://www.google.com").get();

                System.out.printf("%nSEARCHING : %s%n%n", theUrl); 
                Element classOnPage;

                Elements definitionClass3 = doc.select ( "#Definition tr" );
                
                for ( int i =1; i < definitionClass3.size()-2; i++ ){
                    classOnPage = definitionClass3.get(i);
                    System.out.printf("%s%n", classOnPage.text());
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
            if ( whichSource.equals ("d10") ){             
                theUrl = "http://www.urbandictionary.com/define.php?term=" + s;
                
                Document doc = Jsoup.connect ( theUrl ).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").ignoreHttpErrors(true).referrer("http://www.google.com").get();

                System.out.printf("%nSEARCHING : %s%n%n", theUrl); 

                Element classOnPage;
                
                Elements definitionClass3 = doc.select ( ".meaning" );
                Elements definitionExamples = doc.select ( ".example" );
                
                Element definitionExample;
                                               
                for ( int i =0; i < definitionClass3.size(); i++ ){
                    classOnPage = definitionClass3.get( i );
                    definitionExample = definitionExamples.get( i );
                    System.out.printf("%s%nExample: %s%n%n", classOnPage.text(), definitionExample.text() );
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
            if ( whichSource.equals ("d11") ){             
                theUrl = "https://www.merriam-webster.com/dictionary/" + s +"#medicalDictionary";
                
                Document doc = Jsoup.connect ( theUrl ).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").ignoreHttpErrors(true).referrer("http://www.google.com").get();

                System.out.printf("%nSEARCHING : %s%n%n", theUrl); 

                Elements definitionClass = doc.select ( ".card-primary-content" );

                Element definitionExample;
                for ( int i =0; i < definitionClass.size(); i++ ){
                    definitionExample = definitionClass.get( i );
                    System.out.printf("%s%n%n", definitionExample.text() );
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
            if ( whichSource.equals ("d12") ){             
                theUrl = "http://www.netlingo.com/word/" + s +".php";
                
                Document doc = Jsoup.connect ( theUrl ).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").ignoreHttpErrors(true).referrer("http://www.google.com").get();

                System.out.printf("%nSEARCHING : %s%n%n", theUrl); 
                
                Elements definitionClass = doc.select ( ".body strong" );
                Element definitionExample;
                
                for ( int i =0; i < definitionClass.size()-1; i++ ){
                    definitionExample = definitionClass.get( i );
                    System.out.printf("%s%n%n", definitionExample.text() );
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
            if ( whichSource.equals ("d13") ){             
                theUrl = "http://dictionary.cambridge.org/us/dictionary/english/" + s;
                
                Document doc = Jsoup.connect ( theUrl ).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").ignoreHttpErrors(true).referrer("http://www.google.com").get();

                System.out.printf("%nSEARCHING : %s%n%n", theUrl);
                Elements definitionClass = doc.select ( ".sense-body" );
                
                Element definitionExample;
                
                for ( int i =0; i < definitionClass.size(); i++ ){
                    definitionExample = definitionClass.get( i );
                    System.out.printf("%s%n%n", definitionExample.text() );
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
            if ( whichSource.equals ("d14") ){             
                theUrl = "https://plato.stanford.edu/entries/" + s +"/";
                
                Document doc = Jsoup.connect ( theUrl ).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").ignoreHttpErrors(true).referrer("http://www.google.com").get();

                System.out.printf("%nSEARCHING : %s%n%n", theUrl); 
                
                Elements preambleID = doc.select ( "#preamble" );
                Elements tocID = doc.select ( "#toc" );
                
                Elements definitionClass = doc.select ( "#main-text" );
                
                System.out.printf("%s%n", br2nl ( preambleID.html() ));
                System.out.printf("%s", br2nl ( tocID.html() ));
                System.out.printf("%n%s%n%n", br2nl ( definitionClass.html() ));
            }
            
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (HttpStatusException e) {
            e.printStackTrace();
        } catch ( IOException e) {
            e.printStackTrace();
        }     
        
        try {
            if ( whichSource.equals ("d15") ){             
                theUrl = "https://www.merriam-webster.com/thesaurus/" + s;
                
                Document doc = Jsoup.connect ( theUrl ).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").ignoreHttpErrors(true).referrer("http://www.google.com").get();

                System.out.printf("%nSEARCHING : %s%n%n", theUrl); 
                
                Elements wordAttributes = doc.select ( ".word-attributes" );
                Elements theDefinitions = doc.select ( ".card-primary-content" );

                for ( int i =0; i < wordAttributes.size(); i++ ){
                    System.out.printf("%s :: %s", s, wordAttributes.get( i ).text() );
                    System.out.printf("%s", br2nl ( theDefinitions.get( i ).html() ) );   
                }
                
            }
            
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (HttpStatusException e) {
            e.printStackTrace();
        } catch ( IOException e) {
            e.printStackTrace();
        }

	/* http://suggest.aspell.net/index.php/advance?word=tesd&spelling=american&dict=normal&sugmode=slow */

        try {
            if ( whichSource.equals ("d16") ){             
                theUrl = "http://suggest.aspell.net/index.php/advance?word=" + s +"&spelling=american&dict=normal&sugmode=slow";
                
                Document doc = Jsoup.connect ( theUrl ).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").ignoreHttpErrors(true).referrer("http://www.google.com").get();

                System.out.printf("%nSEARCHING : %s%n%n", theUrl); 

				/*Search for all the anchor tags */
				Elements wordAttributes = doc.getElementsByTag("a");

                for ( int i =0; i < wordAttributes.size(); i++ ){
					/*Check if the anchor tag contains the string aspell-def then display the text within*/
					if ( wordAttributes.get( i ).outerHtml().indexOf("aspell-def") > -1 ) {
						System.out.printf("%s%n", wordAttributes.get( i ).text() );
					}
  
                }
	
            }
            
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (HttpStatusException e) {
            e.printStackTrace();
        } catch ( IOException e) {
            e.printStackTrace();
        }  
		
		// Play pronunciation
	
		// Open Compound Words
		// http://ssl.gstatic.com/dictionary/static/sounds/20160317/estrous_cycle--1_us_1.mp3
		// http://ssl.gstatic.com/dictionary/static/sounds/20160317/ontological--_us_1.mp3

           if ( whichSource.equals ("d17") ){  

			   if ( s.contains(" ") ) {
				   s = s.replaceAll(" ", "_");
				   s = s.concat ("--1_us_1.mp3");
			   }else{
				   s = s.concat ("--_us_1.mp3");
			   }	   

			   theUrl = "http://ssl.gstatic.com/dictionary/static/sounds/20160317/" + s ;

                System.out.printf("%nSEARCHING : %s%n%n", theUrl); 
			   
			   try {
					String cmd = "mplayer "+ theUrl;
					Runtime run = Runtime.getRuntime();
					Process pr = run.exec(cmd);
					//pr.waitFor();
					BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
					String line = "";

					while ((line=buf.readLine())!=null) {
						System.out.println(line);
					}
				   
			   	} catch (Exception e) {
					e.printStackTrace();
				}		
	
            }  // End if
            

    }	// END getDefinition 

    public static void main(String[] args) throws IOException {
        
        // Check how many arguments were passed in
        if (args.length == 0)
        {
            System.out.printf("%s%n%n", "Proper Usage is: " );
            System.out.printf("%s%n%n", "Example:  java -cp .:./jsoup-1.10.2.jar DownloadDefinitions " +'"'+ "d1"+'"'+ '"'+"love" +'"' );
            System.out.printf("%s%n%n", "Help: " );
            System.out.printf("%s%n%n", "Example:  java -cp .:./jsoup-1.10.2.jar DownloadDefinitions " +'"'+ "help"+'"' );
            System.out.printf("%s%n%n", "Compiling: " );
            System.out.printf("%s%n", "Example:  javac -cp jsoup-1.10.2.jar DownloadDefinitions.java" );
            System.exit(0);
        } else if (args.length == 1) {
            String findMe = args[0];
            if ( findMe.matches ("\\bhelp\\b") ){
                HelpSection ();
            }
        } else if (args.length == 2) {
            String lettersIhave = args[1];
            String findMe = args[0];
            
            if ( findMe.matches ("\\bd(?:1[0-7]|[1-9])\\b") ){
                getDefinition ( lettersIhave , findMe );
            }
        }

    }
        

    
}

