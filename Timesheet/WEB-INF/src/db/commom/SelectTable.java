package db.commom;

import java.util.ArrayList;

import bean.EntranceDBBean;
import bean.EntranceViewBean;
import bean.LoginInputBean;

public abstract class SelectTable {
	
	public abstract EntranceViewBean execute(EntranceViewBean entranceViewBean, String memCode);
	
	public abstract ArrayList<String> execute(ArrayList<String> errList, LoginInputBean inputBean);
	
	public abstract String execute(LoginInputBean inputBean);
	
	public abstract String execute(String memCode);
	
	public abstract String execute(EntranceDBBean dbBean);
	
	public abstract ArrayList<String> execute(ArrayList<String> errList, EntranceDBBean dbBean, String today); 
	
	
	public String SelectForLogin(LoginInputBean inputBean){
		
		//ログイン用のSELECT文を作成
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("ID, ");
		sb.append("PW, ");
		sb.append("MEM_CODE ");
		sb.append("FROM ");
		sb.append("members ");
		sb.append("where ");
		sb.append("ID = '" + inputBean.getID() + "' ");
		sb.append("AND ");
		sb.append("PW = '" + inputBean.getPW() + "'");
		
		System.out.println("SQL文を発行：　" + sb.toString());
		
		return sb.toString();
	}
	
	public String GetMEN_NAME(String memCode){
		
		//ログイン用のSELECT文を作成
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("NAME ");
		sb.append("FROM ");
		sb.append("members ");
		sb.append("where ");
		sb.append("MEM_CODE = " + memCode);
		
		System.out.println("SQL文を発行：　" + sb.toString());
		
		return sb.toString();
	}
	
	public String GetMemCode(LoginInputBean inputBean){
		
		//社員コード取得用のSELECT文を作成
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("MEM_CODE ");
		sb.append("FROM ");
		sb.append("members ");
		sb.append("where ");
		sb.append("ID = '" + inputBean.getID() + "'");
		
		System.out.println("SQL文を発行：　" + sb.toString());
		
		return sb.toString();
	}
	
	public String SelectTimeSheet(String memCode){
		
		//出退勤データ出力用のSELECT文を作成
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("MEMCODE, ");
		sb.append("START, ");
		sb.append("END, ");
		sb.append("CREATE_TIME, ");
		sb.append("UPDATE_TIME, ");
		sb.append("COMMENT ");
		sb.append("FROM ");
		sb.append("timesheet ");
		sb.append("where ");
		sb.append("MEMCODE = '" + memCode + "'");
		
		System.out.println("SQL文を発行：　" + sb.toString());
		
		return sb.toString();
	}
	
	public String SelectCurrentDate(EntranceDBBean dbBean){
		
		//SQL文を作成
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("DATE ");
		sb.append("FROM ");
		sb.append("timesheet ");
		sb.append("where ");
		sb.append("MEMCODE = " + dbBean.getMEMCODE());
		
		System.out.println("最新日付用SQL文：　"+ sb.toString());
		
		return sb.toString();
	}
	
	public String SelectForStartFinish(EntranceDBBean dbBean, String today){
		
		//SQL文を作成
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("DATE, ");
		sb.append("START ");
		sb.append("FROM ");
		sb.append("timesheet ");
		sb.append("where ");
		sb.append("MEMCODE = " + dbBean.getMEMCODE());
		sb.append(" AND ");
		sb.append("DATE = '" + dbBean.getTODAY() + "'");
		
		System.out.println("出勤済判定SQL文：　" + sb.toString());
		
		return sb.toString();
	}

}
