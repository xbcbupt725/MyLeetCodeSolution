
public class Solution371 {
	public static void main(String[] args){
		int a = 1;
		int b = 2;
		Solution371 s = new Solution371();
		System.out.println(s.getSum(a, b));
	}
	public int getSum(int a, int b) {
        int r1 = 0;
        int r2 = 0;
        while( a != 0){
            r1 = a ^ b;
            r2 = a & b;
            r2 <<= 1;
            a = r2;
            b = r1;
        }
        return b;
    }
}
