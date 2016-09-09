import java.util.Arrays;

public class Solution016 {
	public static void main(String[] args){
		int[] nums = {-1,2,1,-4};
		int target = 1 ;
		Solution016 s = new Solution016();
		System.out.println(s.threeSumClosest(nums, target));
	}
    public int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);
    	int minDistance = Integer.MAX_VALUE;
    	for(int i = 0; i < nums.length-2;++i){
    		if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
    			int low = i+1;
    			int high = nums.length-1;
    			int sum = target - nums[i];
    			while(low < high){
    				minDistance = Math.abs(minDistance)>Math.abs(nums[low] + nums[high] - sum)?nums[low] + nums[high] - sum:minDistance;
    				if(nums[low] + nums[high] == sum){
    					return target;
    				}else if(nums[low] + nums[high] < sum){
    					low++;
    				}else{
    					high--;
    				}
    			}
    		}
    	}
        return minDistance+target;
    }
}