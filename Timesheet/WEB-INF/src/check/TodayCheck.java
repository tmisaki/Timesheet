package check;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.EntranceDBBean;
import db.GetLastDate;
import db.InsertHoliday;

public class TodayCheck {
	
	public void doCheck(String today, EntranceDBBean dbBean){
		int DATE_num;
		String LastDate;
		String day = null;
		int LastDate_num;
		int SDM_num;
		int count;
		
		//今日の日付を8桁に変換
		DATE_num = convertDateNum(today);
		
		//DBの最終勤怠日を取得
		GetLastDate getLastDate = new GetLastDate();
		LastDate = getLastDate.execute(dbBean);
		
		//最終勤怠日が取得できたら日時の【日】のみ取得	
		if(LastDate != null){
			day = LastDate.substring(8);
		}
		
		if(LastDate!=null && !"01".equals(day)){
			
			//最終勤怠日を8桁に変換
			LastDate_num = convertDateNum(LastDate);
			
			//2つの差の分だけDBに空文字を挿入
			count = DATE_num - LastDate_num;
			
			if(count != 0){
				InsertHoliday insertHoliday = new InsertHoliday();
				//休みの日を算出
				createHoliday(LastDate_num, count, dbBean);
				//休みの日の出退勤は空で挿入
				insertHoliday.execute(dbBean);
			
			}
		} else if("01".equals(day)) {
			
			//最終勤怠日を8桁に変換
			LastDate_num = convertDateNum(LastDate);
			
			//2つの差の分だけDBに空文字を挿入
			count = DATE_num - LastDate_num;
			
			if(count != 0){
					//休みの日を算出
					createFirstHoliday(LastDate_num, count, dbBean);
					
					//休みの日の出退勤は空で挿入
					InsertHoliday insertHoliday = new InsertHoliday();
					insertHoliday.execute(dbBean);
			}
		} else {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY/MM");
			String startDayOfMonth = dateFormat.format(date) + "01";
			
			SDM_num = convertDateNum(startDayOfMonth);
			
			//2つの差の分だけDBに空文字を挿入
			count = DATE_num - SDM_num;
			
			if(count != 0){
					//休みの日を算出
					createHoliday(SDM_num, count, dbBean);
					
					//休みの日の出退勤は空で挿入
					InsertHoliday insertHoliday = new InsertHoliday();
					insertHoliday.execute(dbBean);
			}
		}
	}
	
	public int convertDateNum(String date){
		String date_num = null;
		
		date_num = date.replace("/", "");
		
		return Integer.parseInt(date_num);
		
	}
	
	public void createHoliday(int date, int count, EntranceDBBean dbBean){
		
		//日時の【日】のみ取得
		String day = String.valueOf(date).substring(6);
		ArrayList<String> holiday = new ArrayList<String>();
		
		//月初めなのか判定
		if("01".equals(day)){
			
			for(int i=0; i<count; i++){
				//数値化された日付から休みの日を求め元のフォーマットに戻す(20140717→2014/07/17)
				StringBuffer sb = new StringBuffer(String.valueOf(date));
				sb.insert(4, "/");
				sb.insert(7, "/");
				holiday.add(sb.toString());
				date += 1;
				sb = null;
			}
			
		} else {
			for(int i=0; i<count-1; i++){
				//数値化された日付から休みの日を求め元のフォーマットに戻す(20140717→2014/07/17)
				date += 1;
				StringBuffer sb = new StringBuffer(String.valueOf(date));
				sb.insert(4, "/");
				sb.insert(7, "/");
				holiday.add(sb.toString());
				sb = null;
			}
		}
		dbBean.setHOLIDAY(holiday);
	}
	
	//最終勤怠が取得できなかった場合の処理
	public void createFirstHoliday(int date, int count, EntranceDBBean dbBean){
		
		ArrayList<String> holiday = new ArrayList<String>();
		
		for(int i=0; i<count-1; i++){
			//数値化された日付から休みの日を求め元のフォーマットに戻す(20140717→2014/07/17)
			date += 1;
			StringBuffer sb = new StringBuffer(String.valueOf(date));
			sb.insert(4, "/");
			sb.insert(7, "/");
			holiday.add(sb.toString());
			sb = null;
		}
		//DB登録用Beanにセット
		dbBean.setHOLIDAY(holiday);
	}
}
