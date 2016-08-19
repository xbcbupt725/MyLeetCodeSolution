import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution18 {
	public static void main(String[] args) {
		int[] nums = { -3, -2, -1, 0, 0, 1, 2, 3 };
		int target = 0;
		Solution18 s = new Solution18();
		List<List<Integer>> ll = s.fourSum(nums, target);
		for (List<Integer> l : ll) {
			for (Integer i : l) {
				System.out.print(i + " ");
			}
			System.out.print("\n");
		}
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> ll = new ArrayList<>();
		if (nums.length < 4) {
			return ll;
		}
		int max = nums[nums.length-1];
		for (int i = 0; i < nums.length - 3; ++i) {
			int a = nums[i];
			if (a + 3 * max < target) // z is too small
				continue;
			if (4 * a > target) // z is too large
				break;
			if (4 * a == target) { // z is the boundary
				if (i + 3 < nums.length && nums[i + 3] == a)
					ll.add(Arrays.asList(a,a, a, a));
				break;
			}
			if (i > 0 && a == nums[i - 1])
				continue;
				for (int j = i + 1; j < nums.length - 2; ++j) {
					if (j > i + 1 && nums[j] == nums[j - 1]) 
						continue;
						int b = nums[j];
						int low = j + 1;
						int high = nums.length - 1;
						while (low < high) {
							if (nums[low] + nums[high] == target - a - b) {
								ll.add(Arrays.asList(a, b, nums[low],
										nums[high]));

								while (low < high && nums[low] == nums[low + 1])
									low++;
								while (low < high
										&& nums[high] == nums[high - 1])
									high--;

								++low;
								--high;
							} else if (nums[low] + nums[high] < target - a - b) {
								++low;
							} else {
								--high;
							}
						}

					}
				}
			
		

		return ll;
	}
}