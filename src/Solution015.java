
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author xubocheng
 *	Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 *  Find all unique triplets in the array which gives the sum of zero.
 */
public class Solution015 {
	public static void main(String[] args){
		int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		Solution015 s = new Solution015();
		List<List<Integer>> ll = s.threeSum1(nums);
		for(List<Integer> l : ll){
			for(Integer i : l){
				System.out.print(i + " ");
			}
			System.out.print("\n");
		}
}
	
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> ll = new ArrayList<List<Integer>>();
    	if(nums.length < 3){
    		return ll;
    	}
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i = 0; i < nums.length; ++i){
    		if(map.containsKey(nums[i])){
    			map.put(nums[i], map.get(nums[i])+1);
    		}else{
    			map.put(nums[i], 1);
    		}
    	}
    	if(map.containsKey(0) && map.get(0) >= 3){
    		List l = new ArrayList<Integer>();
    		l.add(0);
    		l.add(0);
    		l.add(0);
    		ll.add(l);
    	}
    	Set<Integer> set = map.keySet();
    	Object[] nums1 =set.toArray();
    	Arrays.sort(nums1);
    	for(int i = 0; i < nums1.length; ++ i){
    		int first = (Integer)nums1[i];
    		if(first != 0 && map.get(first) > 1){
				if(map.containsKey(-(first+first))){
					List<Integer> l = new ArrayList<Integer>();
					l.add(first);
					l.add(first);
					l.add(-(first+first));
					ll.add(l);
				}
			}
    		for(int j = i+1; j < nums1.length; ++j){
    			
    			int second = (Integer)nums1[j];
    			
    			int temp = -(first + second);
    			int count = 0;
    			if(map.containsKey(temp)){
    				++count;
    				if(temp == first) ++count;
    				if(temp == second) ++count;
    				if(map.get(temp) >= count && temp > second){
    					List<Integer> l = new ArrayList<Integer>();
    					l.add(first);
    					l.add(second);
    					l.add(temp);
    					ll.add(l);
    				}
    			}
    		}
    	}
		return ll;


	}
    public List<List<Integer>> threeSum1(int[] nums){
    	List<List<Integer>> ll = new ArrayList<>();
    	if(nums.length < 3){
    		return ll;
    	}
    	Arrays.sort(nums);
    	for(int i = 0; i < nums.length-2; ++i){
    		if(i == 0 || (i>0&& nums[i]!=nums[i-1])){
    			int low = i +1;
    			int high = nums.length-1;
    			int sum = 0-nums[i];
    			while(low < high){
    				if(nums[low] + nums[high] == sum){
        				List<Integer> l = Arrays.asList(nums[i],nums[low],nums[high]);
        				ll.add(l);
        				while(low < high && nums[low] == nums[low+1]) low++;
        				while(low < high && nums[high] == nums[high-1])high--;
        				low++;
        				high--;
        			}else if(nums[low] + nums[high] < sum){
        				low++;
        			}else{
        				high--;
        			}
    			}		
    		}
    	}
    	return ll;
    }
}
