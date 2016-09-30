public class Solution008 {
	public static void main(String[] args){
		Solution008 s = new Solution008();
		String str = String.valueOf(Integer.MIN_VALUE);
		System.out.println(s.myAtoi2(str));
		
	}
	
	int myAtoi2(String s) {
		char[] str = s.toCharArray();
		final int INT_MAX = Integer.MAX_VALUE;
	    final int INT_MIN = Integer.MIN_VALUE;
	    int sign = 1, base = 0, i = 0;
	    while (i < str.length && str[i] == ' ') { i++; }
	    if (i < str.length && (str[i] == '-' || str[i] == '+')) {
	        sign = 1 - 2 * (str[i++] == '-'?1:0); 
	    }
	    while (i < str.length && (str[i] >= '0' && str[i] <= '9')) {
	        if (base >  INT_MAX / 10 || (base == INT_MAX / 10 && str[i] - '0' > 7)) {
	            if (sign == 1) return INT_MAX;
	            else return INT_MIN;
	        }
	        base  = 10 * base + (str[i++] - '0');
	    }
	    return base * sign;
	}
	
	
	
    public int myAtoi(String str) {
    	if(str == null || str.isEmpty()) return 0;
        char[] cs = str.toCharArray();
        int index = 0;
        boolean positive = true;
        while(index < cs.length){
        	if(cs[index] == ' '){
        		index++;
        	}else{
        		if(cs[index] == '-'){
            		positive = false;
            		index++;
            		break;
            	}
        		if(cs[index] == '+'){
            		index++;
            		break;
            	}
        		break;
        	} 
        }
        int sum = 0;
        for(int i = index; i < cs.length; ++i){
        	int number = cs[i] - '0';
        	if(number >= 0 && number <= 9){
        		if(positive){
        			if(sum < Integer.MAX_VALUE/10){
        				sum = sum*10+number;
        			}else if(sum > Integer.MAX_VALUE/10){
        				return Integer.MAX_VALUE;
        			}else{
        				if(number <= Integer.MAX_VALUE % 10){
        					sum = sum*10+number;
        				}else{
        					return Integer.MAX_VALUE;
        				}
        			}
        		}else{
        			if(sum > Integer.MIN_VALUE/10){
        				sum = sum*10-number;
        			}else if(sum < Integer.MIN_VALUE/10){
        				return Integer.MIN_VALUE;
        			}else{
        				if(number <= Integer.MIN_VALUE % 10 *(-1)){
        					sum = sum*10-number;
        				}else{
        					return Integer.MIN_VALUE;
        				}
        			}
        		}
        	}else{
        		break;
        	}
        }
        return sum;
    }
    
    
}