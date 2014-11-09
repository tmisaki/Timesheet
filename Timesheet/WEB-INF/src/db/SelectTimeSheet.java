package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.commom.CreateDBConnection;
import db.commom.SelectTable;
import bean.EntranceDBBean;
import bean.EntranceViewBean;
import bean.LoginInputBean;

public class SelectTimeSheet extends SelectTable {

	@Override
	public EntranceViewBean execute(EntranceViewBean entranceViewBean,
			String memCode) {
		
		Connection con = null;
		CreateDBConnection createCon = new CreateDBConnection();
//		ArrayList<String> start = new ArrayList<String>();
//		ArrayList<String> end = new ArrayList<String>();
//		ArrayList<String> commont = new ArrayList<String>();

		String[] START = new String[31];
		String[] END = new String[31];
		String[] COMMENT = new String[31];
		int COUNT = 0;
		
		try {
			//DBに接続
			con = createCon.CreatConnection();
			
			//SQL文を発行
			String SELECT = SelectTimeSheet(memCode);
			PreparedStatement prst = con.prepareStatement(SELECT);
			
			//検索開始
			ResultSet rs = prst.executeQuery();
			
			while(rs.next()){
//				start.add(rs.getString("START"));
//				end.add(rs.getString("END"));
//				commont.add("COMMENT");
				
				START[COUNT] = rs.getString("START");
				END[COUNT] = rs.getString("END");
				COMMENT[COUNT] = rs.getString("COMMENT");
				COUNT++;
				
			}
			
			entranceViewBean.setSTART(START);
			entranceViewBean.setEND(END);
			entranceViewBean.setCOMMENT(COMMENT);
			
		} catch (InstantiationException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		return entranceViewBean;
	}

	@Override
	public ArrayList<String> execute(ArrayList<String> errList,
			LoginInputBean inputBean) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String execute(LoginInputBean inputBean) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String execute(String memCode) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String execute(EntranceDBBean dbBean) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public ArrayList<String> execute(ArrayList<String> errList,
			EntranceDBBean dbBean, String today) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
