package format;

public class DBFormater {
	
	public String format(String str){
		
		String format_str=null;
		
		if(str==null){
			format_str = " ";
			
			return format_str;
			
		} else {
			
			return str;
		}
	}

}
