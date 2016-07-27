import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Top_K_Frequent_Elements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
        for(int i = 0; i < nums.length; ++i){
            if(treeMap.containsKey(nums[i])){
                int occurence = treeMap.get(nums[i]);
                treeMap.put(nums[i],++occurence);
            }else{
                treeMap.put(nums[i],1);
            }
        }
        List<Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(treeMap.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
            //ÉıĞòÅÅĞò
            public int compare(Entry<Integer, Integer> o1,
                    Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
            
        });
        Iterator<Map.Entry<Integer, Integer>> iter = list.iterator();
        List<Integer> arraylist = new ArrayList<Integer>();
        while (iter.hasNext()) {
		    Map.Entry<Integer, Integer> entry = iter.next();
		    int key = entry.getKey();
		    int val = entry.getValue();
		    if(k-- != 0){
		    	arraylist.add(key);
		    }else{
		    	break;
		    }
		}
		return arraylist;
    }
 
}