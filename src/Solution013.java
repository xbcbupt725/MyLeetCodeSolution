public class Solution013 {
	public static void main(String[] args){
		String str = "MMMCMXCIX";
		Solution013 s = new Solution013();
		System.out.println(s.romanToInt(str));
	}
    public int romanToInt(String s) {
    	char[] cs = s.toCharArray();
    	int m = 0;
    	int h = 0;
    	int t = 0;
    	int o = 0;
    	for(int i = 0;i < cs.length; ++i){
    		switch(cs[i]){
    		case 'M':
    			++m;
    			break;
    		case 'D':
    			h += 5;
    			break;
    		case 'C':
    			if(i+1 < cs.length && (cs[i+1] == 'M' || cs[i+1] == 'D')){
    				--h;
    			}else{
    				++h;
    			}
    			break;
    		case 'L':
    			t += 5;
    			break;
    		case 'X':
    			if(i+1 < cs.length && (cs[i+1] == 'C' || cs[i+1] == 'L')){
    				--t;
    			}else{
    				++t;
    			}
    			break;
    		case 'V':
    			o += 5;
    			break;
    		case 'I':
    			if(i+1 < cs.length && (cs[i+1] == 'X' || cs[i+1] == 'V')){
    				--o;
    			}else{
    				++o;
    			}
    			break;
    		}
    	}
        return m*1000+h*100+t*10+o;
    }
}