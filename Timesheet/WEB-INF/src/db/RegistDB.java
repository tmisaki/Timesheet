package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.EntranceDBBean;

import db.commom.CreateDBConnection;
import db.commom.InsertTable;

public class RegistDB extends InsertTable {
	
	public void execute(EntranceDBBean dbBean){
		
		Connection con = null;
		CreateDBConnection createCon = new CreateDBConnection();
		
		try {
			//DB接続
			con = createCon.CreatConnection();
			
			//SQL文を発行
			String INSERT = Insert(dbBean);
			PreparedStatement prst = con.prepareStatement(INSERT);
			
			//登録処理
			int num = prst.executeUpdate();
			if(num == 1){
				System.out.println("出勤時間登録完了");
			} else {
				System.out.println("★★★登録失敗");
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
	}

	@Override
	public void executeUp(EntranceDBBean dbBean) {
		
		Connection con = null;
		CreateDBConnection createCon = new CreateDBConnection();
		
		try {
			//DB接続
			con = createCon.CreatConnection();
			
			//SQL文を発行
			String UPDATE = Update(dbBean);
			PreparedStatement prst = con.prepareStatement(UPDATE);
			
			//登録処理
			int num = prst.executeUpdate();
			if(num != 0){
				System.out.println("退勤時間登録完了");
			} else {
				System.out.println("★★★登録失敗");
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
	}
}
