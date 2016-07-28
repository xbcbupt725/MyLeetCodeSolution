public class Solution10{
	public static void main(String[] args){
		String s = "aa";
		String p = "a*";
		Solution10 s10 = new Solution10();
		System.out.println(s10.isMatch(s, p));
	}
	public boolean isMatch(String s, String p) {
		if(p.isEmpty()) return s.isEmpty();
	    char[] sc = s.toCharArray();
	    char[] pc = p.toCharArray();
	    
	    if(pc.length > 1){
	    	if('*' == pc[1]){
	    		String subp = pc.length > 2? p.substring(2):new String();
	    		String subs = sc.length > 1? s.substring(1):new String();
	    		return isMatch(s,subp)|| (sc.length > 0 && (sc[0] == pc[0]||pc[0] == '.')) && isMatch(subs, p);
	    	}else{
	    		String subp = pc.length > 1? p.substring(1):new String();
	    		String subs = sc.length > 1? s.substring(1):new String();
	    		return (sc.length > 0 && (sc[0] == pc[0]||pc[0] == '.')) && isMatch(subs, subp);
	    	}
	    }else{
	    	return (sc.length == 1)&&(sc[0] == pc[0]||pc[0] == '.');
	    }
		
	}
}