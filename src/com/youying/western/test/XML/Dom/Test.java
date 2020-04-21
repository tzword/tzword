/**
 * 
 */
package com.youying.western.test.XML.Dom;

import java.io.File;


/**
 * @author jhy
 *
 */
public class Test {
	public static void main(String[] args) {
		String filepath = "D:\\dom13.xml";
//		File file = new File(filepath);
//		//如果存在就删除
//		if (file.exists()){
//			file.delete();
//		}
		//DOM 解析
		DomImpl dom =  new DomImpl();
		//初始化,获取document对象
		dom.init();
		//生成xml
		//dom.createXml(filepath);
		//解析xml
		dom.parserXml(filepath);
	}
}
