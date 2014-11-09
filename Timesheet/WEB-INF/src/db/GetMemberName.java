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

public class GetMemberName extends SelectTable {
	
	@Override
	public String execute(String memCode) {
		
		CreateDBConnection createCon = new CreateDBConnection();
		Connection con = null;
		String name = null;
		
		try {
			//DBに接続
			con = createCon.CreatConnection();
			
			//社員名取得用SQL文を発行
			String SELECTname = GetMEN_NAME(memCode);
			PreparedStatement prst = con.prepareStatement(SELECTname);
			
			//社員名の取得開始
			ResultSet rs = prst.executeQuery();
			if(rs.next()){
				name = rs.getString("NAME");
			} else {
				System.out.println("★★★社員名の取得に失敗しています。");
				name = "";
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
		
		return name;
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
	public EntranceViewBean execute(EntranceViewBean entranceViewBean,
			String memCode) {
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
