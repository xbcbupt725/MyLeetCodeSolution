public class Solution010{
	public static void main(String[] args){
		String s = "aa";
		String p = "a**";
		Solution010 s10 = new Solution010();
		System.out.println(s10.isMatch(s, p));
		System.out.println(s10.isMatch1(s, p));
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
	
	/**
     * f[i][j]: if s[0..i-1] matches p[0..j-1]
     * if p[j - 1] != '*'
     *      f[i][j] = f[i - 1][j - 1] && s[i - 1] == p[j - 1]
     * if p[j - 1] == '*', denote p[j - 2] with x
     *      f[i][j] is true iff any of the following is true
     *      1) "x*" repeats 0 time and matches empty: f[i][j - 2]
     *      2) "x*" repeats >= 1 times and matches "x*x": s[i - 1] == x && f[i - 1][j]
     * '.' matches any single character
     */
	public boolean isMatch1(String s, String p){
		char[] sc = s.toCharArray();
		char[] pc = p.toCharArray();
		int size_sc = sc.length;
		int size_pc = pc.length;
		if(size_pc == 0) return size_sc == 0;
		boolean[][] f = new boolean[size_sc+1][size_pc+1];
		f[0][0] = true;
		if( size_pc > 2 && '*' == pc[1]){
			f[0][2] = true;
		}
		for (int j = 1; j <= size_pc; j++)
            f[0][j] = j > 1 && '*' == pc[j - 1] && f[0][j - 2];
		for(int i = 1; i < size_sc+1; ++i){
			for(int j = 1; j < size_pc+1;++j){
				if(j > 1 && '*' == pc[j-1]){
					f[i][j] = f[i][j-2] || (sc[i-1] == pc[j-2] || '.' == pc[j-2]) && f[i-1][j];
				}else{
					f[i][j] = f[i-1][j-1] && (sc[i-1] == pc[j-1] || '.' == pc[j-1]);
				}				
			}
		}
		return f[size_sc][size_pc];
	}
}