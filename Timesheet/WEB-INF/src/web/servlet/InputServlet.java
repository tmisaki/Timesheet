package web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import check.TodayCheck;

import bean.EntranceDBBean;
import bean.EntranceViewBean;
import db.RegistDB;
import db.SelectFinished;
import db.SelectTimeSheet;

import format.DBFormater;
import format.TimeFormat;

public class InputServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<String> errList = new ArrayList<String>();
		String today;
		String now;
		String memCode;
		String comment;
		String time_type;
		String[] TodayNow = new String[2];
		
		EntranceViewBean entranceViewBean = new EntranceViewBean();
		
		String nextpage = null;
		
		ServletContext sc = getServletContext();
		HttpSession session = request.getSession();
		
		TimeFormat timeFormat = new TimeFormat();
		
		time_type = request.getParameter("time");
		
		//出勤を押下
		if(request.getParameter("START") != null){
			
			//現在時刻を取得
			Date date = new Date();
			SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm");
			SimpleDateFormat DateFormat = new SimpleDateFormat("YYYY/MM/dd");
			now = TimeFormat.format(date);
			today = DateFormat.format(date);
			//コメント取得
			comment = request.getParameter("COMMENT");
			//社員コードを取得
			memCode = (String) session.getAttribute("memCode");
			
			System.out.println("出勤：　" + today + "　" + now);
			
			
			//DB登録の事前処理
			EntranceDBBean dbBean =new EntranceDBBean();
			DBFormater dbFormater = new DBFormater();
			
			//コメント欄は日本語入力なのでフォーマットをかけること
			comment = dbFormater.format(comment);
			
			//時間の区切り処理
			TimeFormat format = new TimeFormat();
			TodayNow = format.doFormatStart(today, now, time_type);
			
			dbBean.setMEMCODE(memCode);
			dbBean.setTODAY(TodayNow[0]);
			dbBean.setNOW(TodayNow[1]);
			dbBean.setCOMMENT(comment);
			
			//日付を変えた時のために代入する
			today = TodayNow[0];
			
			//既に出勤をしているか判定
			SelectFinished finished = new SelectFinished();
			errList = finished.execute(errList, dbBean, today);
			
			if(errList.size() == 0){
				//勤怠を付けなかった日は休みとする
				new TodayCheck().doCheck(today, dbBean);
				
				//DBに登録(出勤)
				new RegistDB().execute(dbBean);
				
				//現時点での勤怠情報を取得
				SelectTimeSheet selectTimeSheet = new SelectTimeSheet();
				entranceViewBean = selectTimeSheet.execute(entranceViewBean, memCode);
				
				//ボタンコントロール用に今日の【日】をbeanにセット
				entranceViewBean.setToday(Integer.parseInt(today.substring(8)));
				
				//sessionにBean,社員コード,名前をセット
				session.setAttribute("entranceViewBean", entranceViewBean);
				session.setAttribute("memCode", memCode);
				
				nextpage = "/InputTime.jsp";
			
			} else {
				
				//現時点での勤怠情報を取得
				SelectTimeSheet selectTimeSheet = new SelectTimeSheet();
				entranceViewBean = selectTimeSheet.execute(entranceViewBean, memCode);
				
				//ボタンコントロール用に今日の【日】をbeanにセット
				entranceViewBean.setToday(Integer.parseInt(today.substring(8)));
				
				//エラー情報をbeanにセット
				entranceViewBean.setErrList(errList);
				
				//セッションにBea,社員コード,名前をセット
				session.setAttribute("entranceViewBean", entranceViewBean);
				session.setAttribute("memCode", memCode);
				
				nextpage = "/InputTime.jsp";
			}
		}
		//退勤を押下
		else if(request.getParameter("END") != null) {
			
			//現在時刻を取得
			Date date = new Date();
			SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm");
			SimpleDateFormat DateFormat = new SimpleDateFormat("YYYY/MM/dd");
			now = TimeFormat.format(date);
			today = DateFormat.format(date);
			//コメント取得
			comment = request.getParameter("COMMENT");
			//社員コードを取得
			memCode = (String) session.getAttribute("memCode");
			
			System.out.println("出勤：　" + today + "　" + now);
			
			
			//DB登録の事前処理
			EntranceDBBean dbBean =new EntranceDBBean();
			DBFormater dbFormater = new DBFormater();
			
			comment = dbFormater.format(comment);
			
			//時間の区切り処理
			TimeFormat format = new TimeFormat();
			TodayNow = format.doFormatEnd(today, now, time_type);
			
			dbBean.setMEMCODE(memCode);
			dbBean.setTODAY(TodayNow[0]);
			dbBean.setNOW(TodayNow[1]);
			dbBean.setCOMMENT(comment);
			
			//DBに登録(退勤)
			new RegistDB().executeUp(dbBean);
			
			//現時点での勤怠情報を取得
			SelectTimeSheet selectTimeSheet = new SelectTimeSheet();
			entranceViewBean = selectTimeSheet.execute(entranceViewBean, memCode);
			
			//ボタンコントロール用に今日の【日】をbeanにセット
			entranceViewBean.setToday(Integer.parseInt(today.substring(8)));
			
			//sessionにBean,社員コード,名前をセット
			session.setAttribute("entranceViewBean", entranceViewBean);
			session.setAttribute("memCode", memCode);
			
			nextpage = "/InputTime.jsp";
			
		}
		//修正を押下
		else if(request.getParameter("MODIFY") != null) {
			
			nextpage = "/InputTime.jsp";
		}
		//ページ遷移処理
		sc.getRequestDispatcher(nextpage).forward(request, response);
	}
	
}
