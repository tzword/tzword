package com.youying.western.tools;

import org.apache.struts2.ServletActionContext;

public class PagerHelp {
	public static Pager getPager(int totalRows) {
		Pager pager=new Pager(totalRows);
		String currentPage=ServletActionContext.getRequest().getParameter("currentPage");
		String pageMethod=ServletActionContext.getRequest().getParameter("pageMethod");
		if (currentPage!=null) {
			pager.refresh(Integer.parseInt(currentPage));
		}
		if (pageMethod==null||pageMethod.equals("first")) {
			pager.first();
			return pager;
		}else if (pageMethod.equals("previous")) {
			pager.previous();
		}else if (pageMethod.equals("next")) {
			pager.next();
		}else if(pageMethod.equals("last")){
			pager.last();
		}
		return pager;
	}
}
