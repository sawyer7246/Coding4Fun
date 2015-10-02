package fun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


public class FindFriday {
	//按照输入的日期区间，找到礼拜五最多的日子
	
	//保护性拷贝
	private Date startDate;
	private Date endDate;
	
	public  FindFriday(String start,String end) {
		//格式化日期  yyyy-MM-dd 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.startDate = df.parse(start);
			this.endDate = df.parse(end);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public Map getReport(){
		StringBuffer sb = new StringBuffer();
		
		SortedMap<Integer,Integer> map =  new TreeMap<Integer,Integer>(
		new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		}
		);
		for(int i = 1; i<=31;i++){
			map.put(i, 0);
		}
		
		Calendar   calendar   =   new   GregorianCalendar(); 
		calendar.setTime(startDate); 
		Calendar   calendarStop   =   new   GregorianCalendar(); 
		calendarStop.setTime(endDate); 
		
		while(calendar.before(calendarStop)){
		     calendar.add(calendar.DATE,1);
		     if(calendar.get(calendar.DAY_OF_WEEK)==calendar.FRIDAY){
		    	 Integer count = map.get(calendar.DATE);
		    	 //System.out.println(calendar.get(calendar.DATE));
		    	 count++;
		    	 map.put(calendar.get(calendar.DATE),count);
		     }
		}
		return map;
	}
	
}
