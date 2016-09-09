import java.util.HashMap;
import java.util.Map;


public class Solution003 {
	public static void main(String[] args){
		String str = "abcabcbb";
		Solution003 s = new Solution003();
		System.out.println(s.lengthOfLongestSubstring(str));
	}
	public int lengthOfLongestSubstring(String s) {
		if(s == null) return 0;
		char[] cs = s.toCharArray();
		int table[] = new int[256];
		int max = 0, track = 0;
		for(int i = 0; i < cs.length; ++i){
			while(table[cs[i]] == 1) table[cs[track++]] = 0;
			table[cs[i]] = 1;
			max = Math.max(max, i - track + 1);
		}
		return max;      
    }
}
