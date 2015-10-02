package fun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FindFridatTestCase {
	public static void main(String[] args) {
		FindFriday ff = new FindFriday("1015-10-01","10000-10-31");
		
		long startTime  = System.currentTimeMillis();
		Map<Integer,Integer> map = ff.getReport();
		System.out.println("花费时间："+(System.currentTimeMillis()-startTime));
		
		List<Map.Entry<Integer,Integer>> list_Data = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());  
		
		Collections.sort(list_Data, new Comparator<Map.Entry<Integer,Integer>>()  
			      {   
					@Override
					public int compare(Entry<Integer, Integer> o1,
							Entry<Integer, Integer> o2) {
						return o2.getValue()-o1.getValue();
					} 
			}); 
		
		 for(Map.Entry<Integer, Integer> entry : list_Data){
			 System.out.println(entry.getKey()+"号 中礼拜五有"+entry.getValue()+"次");
		 }
		 
	 
	}
	

}
