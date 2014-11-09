package common;

public interface ErrorMsg {

	public static final String ID_EMPTY = "・IDが入力されていません";
	
	public static final String ID_OVER_LENGTH = "・IDは10文字以下で入力してください";

	public static final String PW_EMPTY = "・PWが入力されていません";
	
	public static final String PW_OVER_LENGTH = "・PWは12文字以下で入力してください";
	
	public static final String INVALID_ID_PW = "・ID,PWの組み合わせが正しくありません";

}
