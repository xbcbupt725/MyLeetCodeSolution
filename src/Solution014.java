public class Solution014 {
	public  static void main(String[] args){
		String[] strs = {"app","apple","application"};
		Solution014 s = new Solution014();
		System.out.println(s.longestCommonPrefix(strs));
	}
	public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
    	StringBuilder sb = new StringBuilder();
    	String first = strs[0];
    	boolean b = true;
    	for(int i = 0;b && i < first.length() ; ++i){
    		for(int j = 1; j < strs.length; ++j){
    			String str = strs[j];
    			if(i >= str.length() || str.charAt(i) != first.charAt(i)){
    				b = false;
    			}
    		}
    		if(b)
    		sb.append(first.charAt(i));
    	}
        return sb.toString();
    }
}