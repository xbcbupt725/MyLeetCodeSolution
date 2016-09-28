public class Solution007 {
	public static void main(String[] args){
		Solution007 s = new Solution007();
		System.out.println(s.reverse(1534236469));
	}
    public int reverse(int x) {
        long ret = 0;
        int c = x < 0?-1:1;
        while(x != 0){
        	ret =ret*10 + x%10;
        	x /= 10;
        }
        if(c*ret > Integer.MAX_VALUE || c*ret < Integer.MIN_VALUE){
        	return 0;
        }
        if(c < 0){
        	return (int)ret | 0x80000000;
        }else{
        	return (int)ret;
        }
    }   
}