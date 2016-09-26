public class Solution006 {
	public static void main(String[] args){
		String str = "PAYPALISHIRING";
		Solution006 s = new Solution006();
		System.out.println(s.convert(str, 3).equals("PAHNAPLSIIGYIR"));
	}
    public String convert(String s, int numRows) {
    	if(numRows == 1){
    		return s;
    	}
    	
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int step = (numRows-1)*2;
        for(int i = 0; i < numRows; ++i){
        	for(int j = 0; j*step+i < cs.length; ++j){
        	     sb.append(cs[j*step+i]); 
        	     if(i != 0 && i != numRows-1){
        	    	 if((j+1)*step-i < cs.length){
        	    		 sb.append(cs[(j+1)*step-i]);
        	    	 } 	
        	     }
        }
        	
        }
        return sb.toString();
    }
}