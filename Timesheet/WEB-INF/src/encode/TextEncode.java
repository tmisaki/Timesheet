package encode;

import java.io.UnsupportedEncodingException;

public class TextEncode {
	
	public String doEncode(String str) throws UnsupportedEncodingException{
		
		//�����R�[�h��UTF-8�ɕϊ�
		String ECD_str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
		
		return ECD_str;
	}
	
}
