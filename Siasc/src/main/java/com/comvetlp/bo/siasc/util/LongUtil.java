package com.comvetlp.bo.siasc.util;

public class LongUtil {
	
	public static boolean isNullOrZero(Long valor) {
		if(valor==null) {
			return true;
		}
		if(valor.equals(new Long("0"))) {
			return true;
		}
		return false;
	}

	public static Long toLong(String value){
		try{
			Long valorLong=new Long(value);
			return valorLong;
		}catch (Exception e){
			return null;
		}
	}

}
