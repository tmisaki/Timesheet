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

public class GetMemberCode extends SelectTable {

	@Override
	public String execute(LoginInputBean inputBean) {
		
		String memCode = null;
		Connection con = null;
		CreateDBConnection createCon = new CreateDBConnection();
		
		try {
			//DBに接続
			con = createCon.CreatConnection();
			
			//SQL文を発行
			String SELECT = GetMemCode(inputBean);
			PreparedStatement prst = con.prepareStatement(SELECT);
			
			//社員番号の取得開始
			ResultSet rs = prst.executeQuery();
			if(rs.next()){
				memCode = rs.getString("MEM_CODE");
			} else {
				System.out.println("社員番号の取得に失敗しました。");
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
		
		return memCode;
	}
	
	@Override
	public ArrayList<String> execute(ArrayList<String> errList,
			LoginInputBean inputBean) {
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
