package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.ErrorMsg;

import bean.EntranceDBBean;
import bean.EntranceViewBean;
import bean.LoginInputBean;

import db.commom.CreateDBConnection;
import db.commom.SelectTable;

public class SelectLoginCheck extends SelectTable {
	
	public ArrayList<String> execute(ArrayList<String> errList, LoginInputBean inputBean){
		
		Connection con = null;
		try {
			
			CreateDBConnection dbConnection = new CreateDBConnection();
			//DB接続
			con = dbConnection.CreatConnection();
			
			//SQL発行
			String SELECT = SelectForLogin(inputBean);
			PreparedStatement prst = con.prepareStatement(SELECT);
			
			//検索開始
			ResultSet rs = prst.executeQuery();
			
			if(!rs.next()){
				System.out.println("ID,PWの組み合わせが正しくありません");
				errList.add(ErrorMsg.INVALID_ID_PW);
			} else {
				System.out.println("認証成功");
			}
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
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
