import java.util.List;

public class Solution18 {
	public static void main(String[] args){
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		Solution18 s = new Solution18();
		List<List<Integer>> ll = s.fourSum(nums,target);
		for(List<Integer> l : ll){
			for(Integer i : l){
				System.out.print(i + " ");
			}
			System.out.print("\n");
		}
	}
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return null;
    }
}