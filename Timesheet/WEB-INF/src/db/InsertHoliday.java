package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.EntranceDBBean;
import db.commom.CreateDBConnection;
import db.commom.InsertTable;

public class InsertHoliday extends InsertTable {

	@Override
	public void execute(EntranceDBBean dbBean) {
		
		Connection con = null;
		CreateDBConnection createCon = new CreateDBConnection();
		
		try {
			//DBに接続
			con = createCon.CreatConnection();
			
			for(int i=0; i<dbBean.getHOLIDAY().size(); i++){
				//SQL文を発行
				String INSERT = InsertHolday(dbBean, i);
				PreparedStatement prst = con.prepareStatement(INSERT);
				
				//DBにinsert
				int num = prst.executeUpdate();
				if(num == 0){
					System.out.println("★★★挿入に失敗");
				}
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
		// TODO 自動生成されたメソッド・スタブ

	}

}
