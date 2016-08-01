/**
 * 
 * @author xubocheng
 *
 */
//11. Container With Most Water
public class Solution11 {
	public static void main(String[] args){
		int[] a = {10,9,8,7,6,5,4,3,2,1};
		Solution11 s = new Solution11();
		System.out.println(s.maxArea(a));
	}
	public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
        	if(height[left] < height[right]){       		
        		max = Math.max(max, (right-left) * height[left++]);     		
        	}else{        		
        		max = Math.max(max, (right-left) * height[right--]);
        	}
        }
        return max;
    }
	
	public int maxArea1(int[] height) {
	    int left = 0, right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right])
					* (right - left));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}

		return maxArea;
	}
}
