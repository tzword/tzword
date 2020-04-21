package com.youying.western.tools;

import java.io.IOException;
import java.util.Properties;

public class IoTransUtil {
public static String ls_coreserver;
public static int ls_coreport;
public static String cardKey;
public static String merId;
public static String province; //手机受理省份
public static String district; //手机受理地区
public static String companycode;//手机受理公司。0：移动  1:联通  2：电信
public static void getIpAndPort() throws IOException{
	
	Properties p = new Properties();
	p.load(IoTransUtil.class.getResourceAsStream("/global.properties"));
	ls_coreserver=p.getProperty("xipip");
	ls_coreport=Integer.parseInt(p.getProperty("xipport"));
	cardKey=p.getProperty("cardKey");
	merId=p.getProperty("merId");
	province=p.getProperty("province");
	district=p.getProperty("district");
	companycode=p.getProperty("companycode");
}

public static String getIp(){
	if(ls_coreserver==null){
		try {
			getIpAndPort();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	System.out.println("IP:"+ls_coreserver);
	return ls_coreserver;
}
public static  int getPort(){
  if(ls_coreport==0){
	  try {
			getIpAndPort();
		} catch (IOException e) {
			e.printStackTrace();
		}
  }
  return ls_coreport;
}

public static String getCardKey(){
	if(cardKey==null){
		try {
			getIpAndPort();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	return cardKey;
}

public static String getMerId(){
	if(merId==null){
		try {
			getIpAndPort();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	return merId;
}
public static String getProvince(){
	if(province==null){
		try {
			getIpAndPort();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	return province;
}

public static String getDistrict(){
	if(district==null){
		try {
			getIpAndPort();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	return district;
}

public static String getCompanycode(){
	if(companycode==null){
		try {
			getIpAndPort();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	return companycode;
}
}
