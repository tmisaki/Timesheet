package format;

import format.common.TimeType;

public class TimeFormat {
	
	public String[] doFormatStart(String today, String now, String time_type){

		String[] TodayNow = new String[2];
		
		//現在時刻を『時』,『分』に分割
		String[] HHMM = now.split(":");
		int HH = Integer.parseInt(HHMM[0]);
		int MM = Integer.parseInt(HHMM[1]);
		
		if(time_type.equals(TimeType.TYPE_10)){
			//時間を10分刻みに変更
			TodayNow = createStart10(today, HH, MM);
		}
		
		return TodayNow;
	}
	
	public String[] doFormatEnd(String today, String now, String time_type){

		String[] TodayNow = new String[2];
		
		//現在時刻を『時』,『分』に分割
		String[] HHMM = now.split(":");
		int HH = Integer.parseInt(HHMM[0]);
		int MM = Integer.parseInt(HHMM[1]);
		
		if(time_type.equals(TimeType.TYPE_10)){
			//時間を10分刻みに変更
			TodayNow = createEnd10(today, HH, MM);
		}
		
		return TodayNow;
	}


	private String[] createStart10(String today, int HH, int MM){
		
		String[] todayNow = new String[2];
		
		if(0<=MM & MM<11){
			
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":10";
			
		} else if(11<=MM & MM<21) {
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":20";
			
		} else if(21<=MM & MM<31) {
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":30";
			
		} else if(31<=MM & MM<41) {
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":40";
			
		} else if(41<=MM & MM<51) {
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":50";
			
		} else if(51<=MM & MM<=59) {
			HH++;
			//24時を回るか判定
			if(HH<24){
				todayNow[0] = today;
				todayNow[1] = String.valueOf(HH) + ":00";
			} else {
				//日付を次の日に変更
				todayNow[0] = createNextDay(today);
				todayNow[1] = "00:00";
			}
		}
		
		return todayNow;
	}

	private String[] createStart15(String today, int HH, int MM){
		
		String[] todayNow = new String[2];
		
		if(0<=MM & MM<16){
			
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":15";
			
		} else if(16<=MM & MM<31) {
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":30";
			
		} else if(31<=MM & MM<46) {
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":45";
			
		} else if(46<=MM & MM<=59) {
			HH++;
			//24時を回るか判定
			if(HH<24){
				todayNow[0] = today;
				todayNow[1] = String.valueOf(HH) + ":00";
			} else {
				//日付を次の日に変更
				todayNow[0] = createNextDay(today);
				todayNow[1] = "00:00";
			}
		}
		
		return todayNow;
	}
	
	private String[] createStart30(String today, int HH, int MM){
		
		String[] todayNow = new String[2];
		
		if(0<=MM & MM<31){
			
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":15";
			
		} else if(31<=MM & MM<=59) {
			HH++;
			//24時を回るか判定
			if(HH<24){
				todayNow[0] = today;
				todayNow[1] = String.valueOf(HH) + ":00";
			} else {
				//日付を次の日に変更
				todayNow[0] = createNextDay(today);
				todayNow[1] = "00:00";
			}
		}
		
		return todayNow;
	}
	

	private String[] createEnd10(String today, int HH, int MM) {
		
		String[] todayNow = new String[2];
		
		if(0<=MM & MM<10){
			
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":00";
			
		} else if(10<=MM & MM<20) {
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":10";
			
		} else if(20<=MM & MM<30) {
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":20";
			
		} else if(30<=MM & MM<40) {
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":30";
			
		} else if(40<=MM & MM<50) {
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":40";
			
		} else if(50<=MM & MM<=59) {
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":50";
			
		}
		
		return todayNow;
	}

	private String[] createEnd15(String today, int HH, int MM) {
		
		String[] todayNow = new String[2];
		
		if(0<=MM & MM<15){
			
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":00";
			
		} else if(15<=MM & MM<30) {
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":15";
			
		} else if(310<=MM & MM<45) {
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":30";
			
		} else if(45<=MM & MM<=59) {
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":45";
			
		}
		
		return todayNow;
	}

	private String[] createEnd30(String today, int HH, int MM) {
		
		String[] todayNow = new String[2];
		
		if(0<=MM & MM<30){
			
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":00";
			
		} else if(30<=MM & MM<=59) {
			todayNow[0] = today;
			todayNow[1] = String.valueOf(HH) + ":30";
			
		}
		
		return todayNow;
	}
	
	
	public String createNextDay(String today){
		
		StringBuffer nextDay;
		int today_num;
		
		today_num = Integer.parseInt(today.replace("/", "")) + 1;
		
		nextDay = new StringBuffer(String.valueOf(today_num));
		nextDay.insert(4, '/');
		nextDay.insert(7, '/');
		
		return nextDay.toString();
	}
	
}
