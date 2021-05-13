package com.youying.western.exportExcel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


/**
 * @deprecated:将oracle中的数据表结构导入到excel中保存(多sheet)
 * @author:jhy 
 * @date:2016-5-6 下午5:32:02
 */

public class DataToExcelWorkWiki {
	public static void main(String[] args) {
		String result = "";
		System.out.println("正在读取数据库中所有的表");
		String FileName = "";
		FileOutputStream fos = null;
		try {
			List tableList = getTableList();
			List tableInfoList = getTableInfoList();
			System.out.println("数据库表读取完成");
			FileName = "D:" + "\\" + "数据字典(经济观察报).xls";
			fos = new FileOutputStream(FileName);
			HSSFWorkbook wb = new HSSFWorkbook();
			// 创建新的sheet并设置名称
			HSSFSheet s1 = wb.createSheet();
			wb.setSheetName(0, "目录");
			List<Map<String, String>> tableNamelist = new ArrayList<Map<String, String>>();
			for (int i = 0; i < tableInfoList.size(); i++) {
				// 创建新的sheet并设置名称
				String[] strings = (String[]) tableInfoList.get(i);
				String tableName = strings[0].toString();
				String tableComment = "";
				if (strings[1] != null) {
					tableComment = strings[1].toString();
				}
				Map<String, String> map = new HashMap<String, String>();
				map.put("tableName", tableName);
				map.put("tableComment", tableComment);
				tableNamelist.add(map);
			}
			result = createIndexToExcel(tableNamelist, null,s1,fos,wb);
			System.out.println(result);
			for (int i = 0; i < tableList.size(); i++) {
				// 创建新的sheet并设置名称
				String[] strings = (String[]) tableList.get(i);
				String tableName = strings[0].toString();
				String tableComment = "";
				if (strings[1] != null) {
					tableComment = strings[1].toString();
				}
				HSSFSheet s = wb.createSheet();
				wb.setSheetName(i+1, tableName);
				List list = new ArrayList();
				list.add(tableComment+"("+tableName+")");
				list.add(getStructOfTable(tableName));
				System.out.println("正在生成表" + tableName + "的结构");
				result = TableStructInfoToExcel(list, null,s,fos,wb);
			}
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			File file = new File(e.getMessage().toString());
			if (file.exists()) {
				file.delete();
			}
		}
		System.out.println(result);
	}

	/**
	 * @deprecated:获取数据库中所有的表
	 * @author:jhy 
	 * @date:2016-5-6 下午5:32:02
	 */
	public static List getTableList() {
		String sql = "select table_name tableName, table_comment tableComment, engine, create_time createTime from information_schema.tables where table_schema = (select database())";
		return getResult(sql, 2);
	}

	/**
	 * @deprecated:根据表名
	 * @author:jhy 
	 * @date:2016-5-6 下午5:32:02
	 */
//	public static List getStructOfTable(String tableName) {
//		String sql = "select column_name columnName, data_type dataType,character_maximum_length charLength ,numeric_precision numericPrecision,numeric_scale numericScale,is_nullable isNullbale,column_default columnDefault, column_comment columnComment, column_key columnKey from information_schema.columns"
//				+ " WHERE table_name='"
//				+ tableName
//				+ "' and table_schema = (select database()) order by ordinal_position";
//		return getResult(sql, 9);
//	}
//		String[] tableFiled = { "列名", "字段类型", "字符串长度",
//				"浮点长度", "小数点后长度", "是否为空", "默认值",
//				"注释","主键" };
//	String[] tableFiled = { "字段名", "字段类型", "是否为空",
//			"是否主键", "默认值", "备注" };
	public static List getStructOfTable(String tableName) {
		String sql = "select column_name columnName, data_type dataType,character_maximum_length charLength ,numeric_precision numericPrecision,numeric_scale numericScale,is_nullable isNullbale,column_key columnKey,column_default columnDefault, column_comment columnComment  from information_schema.columns"
				+ " WHERE table_name='"
				+ tableName
				+ "' and table_schema = (select database()) order by ordinal_position";
//		System.out.println("导出的sql："+sql);
		return getResult2(sql, 9);
	}


	/**
	 * @Description:获取表的信息
	 * @author:jhy
	 * @date:2017年4月7日 上午10:36:35
	 */
	public static List getTableInfoList() {
		String sql = "select table_name tableName, table_comment tableComment from information_schema.tables where table_schema = (select database())";
		return getResult(sql, 2);
	}


	/**
	 * @deprecated:获取结果的公用类(特定数据)
	 * @author:jhy
	 * @date:2016-5-6 下午5:32:02
	 * @param sql
	 * @param length
	 * @return
	 */

	public static List getResult2(String sql, int length) {
		List list = new ArrayList();
		ResultSet rs = null;
		ConnectionMysql c = new ConnectionMysql();
		try {
			rs = c.executeQuery(sql);
			while (rs.next()) {
				String[] string = new String[length];
//				for (int i = 1; i < length + 1; i++) {
//					string[i - 1] = rs.getString(i);
//				}
				//字段名
				string[0] = rs.getString(1);
				//字段类型=字段长度+（浮点长度，小数点后长度）
				String zdlx = rs.getString(2);
				//字符串长度
				String zfccd = rs.getString(3);
				//浮点长度
				String fdcd = rs.getString(4);
				//小数点后长度
				String xsdhcd = rs.getString(5);

				//如果字符串长度没有值
				if(zfccd == null){
					//如果浮点长度有值
					if(fdcd != null){
						//如果小数点后长度为空或者是0
						if (null == xsdhcd || "0".equals(xsdhcd)){
							string[1] = zdlx + "("+ fdcd +")";
						}else{
							string[1] = zdlx + "("+ fdcd +","+xsdhcd+")";
						}
					}else {
						string[1] = zdlx;
					}
				}else{
					//如果字符串长度有值，那字段类型就是 字段类型（字符串长度）
					string[1] = zdlx + "("+ zfccd +")";
				}
				//是否为空
				String sfwk = rs.getString(6);
				if (sfwk != null && sfwk.equals("YES")){
					string[2] = "Y";
				}else{
					string[2] = "N";
				}
				//是否主键
				String zj = rs.getString(7);
				if (zj != null && zj.equals("PRI")){
					string[3] = "Y";
				}
				//默认值
				string[4] = rs.getString(8);
				//备注
				string[5] = rs.getString(9);

				list.add(string);
			}

			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	/**
	 * @deprecated:获取结果的公用类
	 * @author:jhy 
	 * @date:2016-5-6 下午5:32:02
	 * @param sql
	 * @param length
	 * @return
	 */

	public static List getResult(String sql, int length) {
		List list = new ArrayList();
		ResultSet rs = null;
		ConnectionMysql c = new ConnectionMysql();
		try {
			rs = c.executeQuery(sql);
			while (rs.next()) {
				String[] string = new String[length];
				for (int i = 1; i < length + 1; i++) {
					string[i - 1] = rs.getString(i);
				}
				list.add(string);
			}

			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	/**
	 * @deprecated:输出对应list中的数据
	 * @author:jhy 
	 * @date:2016-5-6 下午5:32:02
	 */
	public static void showView(List list) {
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String[] name = (String[]) iterator.next();
			for (int i = 0; i < name.length; i++) {
				System.out.println(name[i]);
			}
		}
	}

	/**
	 * 
	 * @deprecated:将数据导入到excel中
	 * @author:jhy 
	 * @param list
	 * @param path
	 * @return
	 * @throws Exception
	 */

	public static String TableStructInfoToExcel(List list, String path,HSSFSheet s,FileOutputStream fos,HSSFWorkbook wb)
			throws Exception {
		HSSFRow row = null;
		HSSFCell cell = null;
		HSSFCellStyle style = null;
		HSSFFont font = null;
		int currentRowNum = 0;
//		String[] tableFiled = { "列名", "字段类型", "字符串长度",
//				"浮点长度", "小数点后长度", "是否为空", "默认值",
//				"注释","主键" };
		String[] tableFiled = { "字段名", "字段类型", "是否为空",
				"是否主键", "默认值", "备注" };
		try {
				style = wb.createCellStyle();
				font = wb.createFont();
				// 新建一行,再在行上面新建一列
				row = s.createRow(currentRowNum);
				int pad = currentRowNum;
				currentRowNum++;
				// 设置样式
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 字体加粗
				style.setFont(font);
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居中
				style.setFillForegroundColor((short) 13);// 设置背景色
				style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
				for (int i = 0; i < tableFiled.length; i++) {
					cell = row.createCell((short) i);
					cell.setCellValue("");
					cell.setCellStyle(style);
				}

				row.getCell((short) 0).setCellValue(
						"数据库表" + list.get(0).toString());
				
				
				HSSFFont hlink_font = wb.createFont();
				HSSFCellStyle hlink_style = wb.createCellStyle();
				hlink_font.setUnderline(HSSFFont.U_SINGLE);
				hlink_font.setColor(HSSFColor.BLUE.index); 
				hlink_style.setFont(hlink_font);
				
				HSSFCell cell2 = row.createCell((short) 9);
				cell2.setCellValue("返回到目录");
				HSSFHyperlink link = new HSSFHyperlink(HSSFHyperlink.LINK_DOCUMENT);
				link.setAddress("目录!A1");
				cell2.setHyperlink(link);
				cell2.setCellStyle(hlink_style);
				// 创建第二行
				row = s.createRow(currentRowNum);
				currentRowNum++;
				for (int i = 0; i < tableFiled.length; i++) {
					// 创建多列并设置每一列的值和宽度
					cell = row.createCell((short) i);
					cell.setCellValue(new HSSFRichTextString(tableFiled[i]));
					s.setColumnWidth((short) i, (short) 5000);
				}
				List list2 = (List) list.get(1);
				for (int i = 0; i < list2.size(); i++) {
					row = s.createRow(currentRowNum);
					currentRowNum++;
					String[] strings = (String[]) list2.get(i);
					for (int j = 0; j < strings.length; j++) {
						cell = row.createCell((short) j);
						cell.setCellValue(new HSSFRichTextString(strings[j]));
					}
				}

				// 合并单元格
				s.addMergedRegion(new Region(pad, (short) 0, pad,
						(short) (tableFiled.length - 1)));
				currentRowNum++;
		} catch (Exception e) {
			e.printStackTrace();
			fos.close();
			throw new Exception("");

		}
		return "数据库表结构生成成功";
	}
	
	
	
	/**
	 * 
	 * @deprecated:将表目录导入到excel中
	 * @author:jhy 
	 * @param list
	 * @param tableName
	 * @param path
	 * @return
	 * @throws Exception
	 */

	public static String createIndexToExcel(List<Map<String, String>> list, String path,HSSFSheet s,FileOutputStream fos,HSSFWorkbook wb)
			throws Exception {
		HSSFRow row = null;
		HSSFCell cell = null;
		HSSFCell cell2 = null;
		HSSFCellStyle hlink_style = wb.createCellStyle();
		HSSFFont hlink_font = wb.createFont();
		try {
			hlink_font.setUnderline(HSSFFont.U_SINGLE);
			hlink_font.setColor(HSSFColor.BLUE.index); 
			hlink_style.setFont(hlink_font);
			for (int i = 0; i < list.size(); i++) {
				row = s.createRow(i);
				cell = row.createCell((short) 0);
				cell.setCellValue(list.get(i).get("tableName"));
				HSSFHyperlink link = new HSSFHyperlink(HSSFHyperlink.LINK_DOCUMENT);
				link.setAddress(list.get(i).get("tableName")+"!A1");
				cell.setHyperlink(link);
				cell.setCellStyle(hlink_style);
				s.setColumnWidth((short) 0, (short) 10000);
				
				cell2 = row.createCell((short) 1);
				cell2.setCellValue(list.get(i).get("tableComment"));
				s.setColumnWidth((short) 1, (short) 10000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fos.close();
			throw new Exception("");

		}
		return "目录生成成功";
	}

}
