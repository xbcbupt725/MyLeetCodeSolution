import java.util.List;


public class TestMain {
	public static void main(String[] args){
		Top_K_Frequent_Elements s = new Top_K_Frequent_Elements();
		int a[] ={1,1,1,2,2,3};
		int k = 2;
		List<Integer> list = s.topKFrequent(a, k);
		for(int i = 0; i < list.size(); ++i){
			System.out.println(list.get(i));
		}
	}
}
