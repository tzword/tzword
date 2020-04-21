/**
 * 
 */
package com.youying.western.test.XML.Sax;



/**
 * @author jhy
 *
 */
public class Test {
	public static void main(String[] args) {
		String filepath = "D:\\ReturnTest.xml";
//		File file = new File(filepath);
//		//如果存在就删除
//		if (file.exists()){
//			file.delete();
//		}
		//DOM 解析
		SaxImpl sax =  new SaxImpl();
		//生成xml
		//sax.createXml(filepath);
		//解析xml
		sax.parserXml(filepath);
	}
}
