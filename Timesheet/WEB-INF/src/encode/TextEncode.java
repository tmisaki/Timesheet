package encode;

import java.io.UnsupportedEncodingException;

public class TextEncode {
	
	public String doEncode(String str) throws UnsupportedEncodingException{
		
		//•¶šƒR[ƒh‚ğUTF-8‚É•ÏŠ·
		String ECD_str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
		
		return ECD_str;
	}
	
}
