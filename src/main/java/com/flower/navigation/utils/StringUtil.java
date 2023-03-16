package com.flower.navigation.utils;

/**  

* <p>Title: StringUtil</p>  

* <p>Description:字符串工具类 </p>  

* @author QingFeng  

* @date 2020年8月14日  

*/  
public class StringUtil {
	
	/**  
	
	 * <p>Title: isString</p>  
	
	 * <p>Description:判断是否是有效的字符串 </p>  
	
	 * @param str
	 * @return  
	
	 */  
	public static boolean isString(String str) {
		if( null == str  ||str.trim().equals("")) {
			return false;
		}
		return true;
	}

}
