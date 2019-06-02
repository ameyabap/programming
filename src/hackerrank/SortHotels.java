package hackerrank;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class SortHotels {

	static List<Integer> sort_hotels(String keywords, List<Integer> hotel_ids, List<String> reviews) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
    	String[] words = keywords.split(" ");
		Set<String> set = new HashSet<String>();
    	for(int i = 0; i< words.length;i++) {
    		set.add(words[i]);
    	}
    	
    	for(int i = 0; i< hotel_ids.size();i++) {
    		String s = reviews.get(i);
    		String[] reviewWords = s.split(" ");
    		int cnt = 0;
    		for(int j = 0;j<reviewWords.length;j++) {
    			s = reviewWords[j].replaceAll("[+.^:,']", "");
    			if(set.contains(s)) {
    				cnt++;
    			}
    		}
    		if(map.containsKey(hotel_ids.get(i))) {
    			map.put(hotel_ids.get(i), map.get(hotel_ids.get(i) + cnt));
    		}else {
    			map.put(hotel_ids.get(i), cnt);
    		}
    		
    	}
    	
    	Map sortedMap = sortByValues(map);
    	 
        // Get a set of the entries on the sorted map
        Set set1 = sortedMap.entrySet();
     
        // Get an iterator
        Iterator i = set1.iterator();
        List<Integer> result = new ArrayList<Integer>();
        // Display elements
        while(i.hasNext()) {
          Map.Entry me = (Map.Entry)i.next();
          result.add((Integer)me.getKey());
        }
    	
		
    	return result;
    }
	
	public static <K, V extends Comparable<V>> Map<K, V> 
    sortByValues(final Map<K, V> map) {
    Comparator<K> valueComparator = 
             new Comparator<K>() {
      public int compare(K k1, K k2) {
        int compare = 
              map.get(k2).compareTo(map.get(k1));
        if (compare == 0) 
          return 1;
        else 
          return compare;
      }
    };
 
    Map<K, V> sortedByValues = 
      new TreeMap<K, V>(valueComparator);
    sortedByValues.putAll(map);
    return sortedByValues;
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
