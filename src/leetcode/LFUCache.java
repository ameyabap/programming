package leetcode;

import java.util.HashMap;

public class LFUCache {
	static int currMinKey = Integer.MIN_VALUE;
    HashMap<Integer, Integer> map;
    int capacity;
    public LFUCache(int capacity) {
        map = new HashMap<Integer, Integer>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        
        if(map.containsKey(key) == true) {
            map.put(key, map.get(key) + 1);
            currMinKey = Math.max(a, b);
            return key;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.size() == capacity) {
        	
        }
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */