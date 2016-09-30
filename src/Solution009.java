public class Solution009 {
	public static void main(String[] args){
		Solution009 s = new Solution009();
		System.out.println(s.isPalindrome(121));
	}
   
    public boolean isPalindrome(int x) {
    	if(x < 0)   return false;
    	if(x < 10)   return true;
    	if(x%10 == 0) return false;
    	int base = 0;
    	while(x > base){
    		base = base*10+x%10;
    		x = x/10;
    	}
    	return base == x || base%10 == x;
    }
}