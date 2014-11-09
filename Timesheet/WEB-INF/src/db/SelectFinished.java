package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.EntranceDBBean;
import bean.EntranceViewBean;
import bean.LoginInputBean;

import db.commom.CreateDBConnection;
import db.commom.SelectTable;

public class SelectFinished extends SelectTable {
	
	public ArrayList<String> execute(ArrayList<String> errList, EntranceDBBean dbBean, String today){
		
		Connection con = null;
		CreateDBConnection createCon = new CreateDBConnection();
		
		try {
			//DB接続
			con = createCon.CreatConnection();
			
			//SQL文を発行
			String SELECT = SelectForStartFinish(dbBean, today);
			PreparedStatement prst = con.prepareStatement(SELECT);
			
			//検索処理開始
			ResultSet rs = prst.executeQuery();
			if(rs.next()){
				System.out.println("出勤済みです。");
				errList.add("・本日は既に出勤しています。");
			}
			
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
		
		return errList;
	}

	@Override
	public EntranceViewBean execute(EntranceViewBean entranceViewBean,
			String memCode) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
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

}
