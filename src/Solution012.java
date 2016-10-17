public class Solution012 {
	public static void main(String[] args){
		int num = 3999;
		Solution012 s = new Solution012();
		System.out.println(s.intToRoman(num));
	}
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        final String[][] set ={ 
        	{"","I","II","III","IV","V","VI","VII","VIII","IX"},
        	{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
        	{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
        	{"","M","MM","MMM","","","","","","",""},
        };
        int m = num / 1000;
        int h = (num % 1000) / 100;
        int t = (num % 100) / 10;
        int o = num % 10;
        sb.append(set[3][m]);
        sb.append(set[2][h]);
        sb.append(set[1][t]);
        sb.append(set[0][o]);
        return sb.toString();
    }
}