
public class Solution4 {
	public static void main(String[] args){
		int a[] = {1,3};
		int b[] = {2};
		Solution4 s = new Solution4();
		System.out.println(s.findMedianSortedArrays(a, b));
	}
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int maxLeft = 0;
		int minRight = 0;
        if(m > n){
        	return findMedianSortedArrays(nums2,nums1);
        }
        int begin = 0;
        int end = m;
        int i = (0+m)/2;
        int j = (n+m+1)/2-i;
        while(begin <= end){
        	if(i < m &&  j > 0 && nums1[i] < nums2[j-1]){
        		  begin = i+1;
        		  i = (begin + end)/2;  
        		  j = (n+m+1)/2-i;
        	}else if(i > 0 && j < n && nums1[i-1] > nums2[j]){
        		end = i-1;
      		  	i = (begin + end)/2;  
      		  	j = (n+m+1)/2-i;
        	}else{     		
        		break;
        	}      	
        }
        if(i == 0){
			maxLeft = nums2[j-1];
		}else if( j == 0){
			maxLeft = nums1[i-1];
		}else{
			maxLeft = Math.max(nums1[i-1], nums2[j-1]);
		}
        if((n+m)%2 == 1){
        	return maxLeft;
        }
        
        if(i == m){
        	minRight = nums2[j];
        }else if( j == n){
        	minRight = nums1[i];
        }else{
        	minRight = Math.min(nums1[i], nums2[j]);
        }
        return (maxLeft+minRight)/2.0;
    }
}
