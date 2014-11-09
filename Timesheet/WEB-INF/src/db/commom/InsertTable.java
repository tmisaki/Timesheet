package db.commom;

import bean.EntranceDBBean;

public abstract class InsertTable {

	public abstract void execute(EntranceDBBean dbBean);

	public abstract void executeUp(EntranceDBBean dbBean);
	
	
	public String Insert(EntranceDBBean dbBean){
		
		//勤怠登録SQL文を作成
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO timesheet (");
		sb.append("MEMCODE, ");
		sb.append("DATE, ");
		sb.append("START, ");
		sb.append("END, ");
		sb.append("CREATE_TIME, ");
		sb.append("UPDATE_TIME, ");
		sb.append("COMMENT) ");
		sb.append("VALUES ( ");
		sb.append(dbBean.getMEMCODE() + ", ");
		sb.append("'" + dbBean.getTODAY() + "', ");
		sb.append("'" + dbBean.getNOW() + "', ");
		sb.append("'', ");
		sb.append("CURRENT_TIMESTAMP(), ");
		sb.append("CURRENT_TIMESTAMP(), ");
		sb.append("'" + dbBean.getCOMMENT() + "') ");
		
		System.out.println("登録用SQL分：　" + sb.toString());
		
		return sb.toString();
		
	}
	
	public String InsertHolday(EntranceDBBean dbBean, int i){
		
		//勤怠登録SQL文を作成
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO timesheet (");
		sb.append("MEMCODE, ");
		sb.append("DATE, ");
		sb.append("START, ");
		sb.append("END, ");
		sb.append("CREATE_TIME, ");
		sb.append("UPDATE_TIME, ");
		sb.append("COMMENT) ");
		sb.append("VALUES ( ");
		sb.append(dbBean.getMEMCODE() + ", ");
		sb.append("'" + dbBean.getHOLIDAY().get(i) + "', ");
		sb.append("'', ");
		sb.append("'', ");
		sb.append("CURRENT_TIMESTAMP(), ");
		sb.append("CURRENT_TIMESTAMP(), ");
		sb.append("'')");
		
		System.out.println("登録用SQL分：　" + sb.toString());
		
		return sb.toString();
		
	}
	
	public String Update(EntranceDBBean dbBean){
		
		//勤怠登録SQL文を作成
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE timesheet SET ");
		sb.append("MEMCODE=" + dbBean.getMEMCODE() + ", ");
		sb.append("END = '" + dbBean.getNOW() + "', ");
		sb.append("UPDATE_TIME=CURRENT_TIMESTAMP, ");
		sb.append("COMMENT = '" + dbBean.getCOMMENT() + "' ");
		sb.append("where ");
		sb.append("MEMCODE = " + dbBean.getMEMCODE());
		sb.append(" AND ");
		sb.append("DATE = '" + dbBean.getTODAY() + "'");
		
		System.out.println("登録用SQL分：　" + sb.toString());
		
		return sb.toString();
		
	}

}
