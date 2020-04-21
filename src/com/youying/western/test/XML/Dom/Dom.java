/**
 * 
 */
package com.youying.western.test.XML.Dom;

/**
 * @author jhy
 *
 */
public interface Dom {
	/**
	 * 建立XML文档
	 * 
	 * @param fileName
	 *            文件全路径名称
	 */
	public void createXml(String fileName);

	/**
	 * 解析XML文档
	 * 
	 * @param fileName
	 *            文件全路径名称
	 */
	public void parserXml(String fileName);
}
