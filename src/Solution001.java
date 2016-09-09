import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution001 {
	public static void main(String[] args){
		int[] nums ={3,2,4};
		int target = 6;
	    Solution001 s = new Solution001();
	    int[] result =s.twoSum(nums, target);
	    for(int i = 0; i < result.length; ++i){
	    	System.out.println(result[i]);
	    }
	}
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; ++i){
        	if(map.containsKey(target - nums[i])){
        		return new int[]{map.get(target - nums[i]),i};
        	}else{
        		map.put(nums[i], i);
        	}	
        }
        return null;
    }
}