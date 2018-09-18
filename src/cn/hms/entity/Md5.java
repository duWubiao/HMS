package cn.hms.entity;

import com.ndktools.javamd5.Mademd5;

public class Md5 {

	public String md5(String value){
		Mademd5 md = new Mademd5();
		return md.toMd5(value); 
	}
}
