public class Solution008 {
	public static void main(String[] args){}
    public int myAtoi(String str) {
        try{
            return Integer.valueOf(str);
        }catch(Exception e){
            return 0;
        }
    }
}