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

import check.CheckForLogin;
import db.GetMemberCode;
import db.GetMemberName;
import db.SelectLoginCheck;
import db.SelectTimeSheet;

import bean.EntranceViewBean;
import bean.LoginInputBean;
import bean.LoginViewBean;

import prmset.PrmSetInputLoginBean;

import encode.TextEncode;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String memCode = null;
		String name = null;
		String nextpage = "";
		ArrayList<String> errList = new ArrayList<>();
		LoginViewBean viewBean = new LoginViewBean();
		EntranceViewBean entranceViewBean = new EntranceViewBean();
		
		ServletContext sc = getServletContext();
		HttpSession session = request.getSession();
		
		if(!request.getParameter("LOGIN").isEmpty()){
		
			//リクエストからID,PWを取得
			String ID = request.getParameter("ID");
			String PW = request.getParameter("PW");
			
			//UTF-8にエンコード
			TextEncode textEncode = new TextEncode();
			ID = textEncode.doEncode(ID);
			PW = textEncode.doEncode(PW);
			
			//ID,PWをbeanにセット
			PrmSetInputLoginBean setbean = new PrmSetInputLoginBean();
			LoginInputBean inputBean = new LoginInputBean();
			inputBean = setbean.setInputLoginBean(inputBean, ID, PW);
			
			//入力チェック
			CheckForLogin check = new CheckForLogin();
			errList = check.doCheck(inputBean, errList);
			
			if(errList.size() == 0){
				//ログイン処理
				SelectLoginCheck loginCheck = new SelectLoginCheck();
				errList = loginCheck.execute(errList, inputBean);
				
				//遷移先の設定
				if(errList.size() == 0){
					
					//現在時刻を取得
					Date date = new Date();
					SimpleDateFormat TimeFormat = new SimpleDateFormat("HH:mm");
					SimpleDateFormat DateFormat = new SimpleDateFormat("YYYY/MM/dd");
					String now = TimeFormat.format(date);
					String today = DateFormat.format(date);
					
					//社員番号を取得
					GetMemberCode getMemberCode = new GetMemberCode();
					memCode = getMemberCode.execute(inputBean);
					
					//社員名の取得
					GetMemberName getMemberName = new GetMemberName();
					name = getMemberName.execute(memCode);
					
					System.out.println("ログイン情報：　" + name + "　" + today + "　" + now);
					
					//現時点での勤怠情報を取得
					SelectTimeSheet selectTimeSheet = new SelectTimeSheet();
					entranceViewBean = selectTimeSheet.execute(entranceViewBean, memCode);

					//ボタンコントロール用に今日の【日】をbeanにセット
					entranceViewBean.setToday(Integer.parseInt(today.substring(8)));
					
					//sessionにBean,社員コード,名前をセット
					session.setAttribute("entranceViewBean", entranceViewBean );
					session.setAttribute("memCode", memCode);
					session.setAttribute("name", name);
					
					nextpage = "/InputTime.jsp";
					
				} else {
					
					nextpage = "/Login.jsp";
					//beanにエラー内容をセット
					viewBean.setErrList(errList);
				}
				
			} else {
				
				System.out.println("★★★入力エラーです");
				nextpage = "/Login.jsp";
				//beanにエラー内容をセット
				viewBean.setErrList(errList);
			}
			
		}
		//ボタン情報が異常値の時
		else {
			
			System.out.println("不明なボタンが押されました");
			nextpage = "/Login.jsp";
			
		}
		
		request.setAttribute("viewBean", viewBean);
		
		sc.getRequestDispatcher(nextpage).forward(request, response);
	}

}
