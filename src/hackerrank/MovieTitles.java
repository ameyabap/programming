package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import com.google.gson.*;
public class MovieTitles {
    /*
     * Complete the function below.
     * Base url: https://jsonmock.hackerrank.com/api/movies/search/?Title=
     */

	public static void main(String[] args) throws IOException {
		String[] titles = getMovieTitles("spiderman");
		for (int i = 0; i < titles.length; i++) {
			System.out.println(titles[i]);
		}
	}
     private static String makeRequest(String urlTitle) throws IOException {
        
         URL obj = new URL(urlTitle);
         HttpURLConnection con = (HttpURLConnection) obj.openConnection();
         // optional default is GET
         con.setRequestMethod("GET");
         //add request header
         con.setRequestProperty("User-Agent", "Mozilla/5.0");
         int responseCode = con.getResponseCode();
         System.out.println("\nSending 'GET' request to URL : " + urlTitle);
         System.out.println("Response Code : " + responseCode);
         BufferedReader in = new BufferedReader(
                 new InputStreamReader(con.getInputStream()));
         String inputLine;
         StringBuffer response = new StringBuffer();
         while ((inputLine = in.readLine()) != null) {
             response.append(inputLine);
         }
         in.close();
         return response.toString();
    }
    static String[] getMovieTitles(String title) throws IOException {
        
        String urlTitle = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + title;
        String urlTitleWithPage = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+ title +"&page=";
         //print in String
         //System.out.println(response.toString());
         GsonBuilder gsonBuilder = new GsonBuilder();
         
         gsonBuilder.registerTypeAdapter(SearchData.class, new MovieTitles().new SearchDataCreator());
          
         Gson gson = gsonBuilder.create();
         //Gson gson = new Gson();
         String responseString = makeRequest(urlTitle);
         System.out.println(
             gson.fromJson(responseString,
             MovieSearchResult.class));
         MovieSearchResult searchResult = gson.fromJson(responseString, MovieSearchResult.class);
         System.out.println(searchResult);
         int pages = searchResult.total_pages;
         List<MovieSearchResult> results = new ArrayList<MovieSearchResult>();
         results.add(searchResult);
         for(int i = 2;i<=pages;i++) {
             
             String resp = makeRequest(urlTitleWithPage+i);
             MovieSearchResult pageResult = gson.fromJson(resp, MovieSearchResult.class);
             results.add(pageResult);
         }
         List<String> titles = new ArrayList<String>();
         for(int i = 0;i<results.size();i++) {
             MovieSearchResult result = results.get(i);
             for(int j = 0;j<result.data.size();j++) {
                 titles.add(result.data.get(j).Title);
             }
         }
         Collections.sort(titles); 
         String[] sortedTitles = titles.toArray(new String[titles.size()]);
        return sortedTitles;
    }
    
    class MovieSearchResult {
        int page, per_page, total, total_pages;
        List<SearchData> data;
    }
    class SearchData {
        /*
         *  "Poster": "N/A",
      "Title": "Spiderman 5",
      "Type": "movie",
      "Year": 2008,
      "imdbID": "tt3696826"
         */
        String Poster, Title, Type, Year, imdbID;
        public SearchData(Type arg0) {
            
        }

    }
    
    class SearchDataCreator implements InstanceCreator<SearchData> {
           

        @Override
        public SearchData createInstance(Type arg0) {
            // TODO Auto-generated method stub
            return new SearchData(arg0);
        }
    }
}