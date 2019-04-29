package hackerearth;

import java.io.*;
import java.lang.reflect.Type;
import java.math.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import com.google.gson.*;
public class NoOfOccurence {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        long count = 0;
        long length = (long)s.length();
        int indexInString = 0;
        if(length == 1 && s.charAt(0) == 'a') {
            return n;
        }
        if(length == 1 && s.charAt(0) != 'a') {
            return 0;
        }
        int countInWord = 0;
        for(int i = 0;i<length;i++) {
            if(s.charAt(i) == 'a') {
                countInWord++;
            }
        }
        	/**
        	kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm
			736778906400
        	 */
            float totalOccurancesOfWord = n / length;
            long charsToCheck = (n % length);
            if(n % length == 0.00){
                return (long) ((long)totalOccurancesOfWord * countInWord);
            }else {
            
                int countNew = 0;
                for(int i = 0;i<charsToCheck;i++) {
                    if(s.charAt(i) == 'a') {
                        countNew++;
                    }                    
                }
                //return -1L;
                return (long) ((totalOccurancesOfWord * countInWord) + countNew);

            }
        
        //return count;

    }//51574523448

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	getHttp("spiderman");
    	
//    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        
//        
//        
//        String s = scanner.nextLine();
//
//        long n = scanner.nextLong();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        long result = repeatedString(s, n);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
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
	private static void getHttp(String title) throws IOException {
		
		String urlTitle = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + title;
		String urlTitleWithPage = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+ title +"&page=";
	     //print in String
	     //System.out.println(response.toString());
	     GsonBuilder gsonBuilder = new GsonBuilder();
	     
	     gsonBuilder.registerTypeAdapter(SearchData.class, new NoOfOccurence().new SearchDataCreator());
	      
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
	     System.out.println(sortedTitles);
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
