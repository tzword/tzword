package com.youying.western.tools;

public class Pager {
	private int totalRows;// 总条数
	private int pageSize=10;// 每页显示的条数
	private int currentPage;// 当前页面
	private int totalPage;// 总页数
	private int startRow;// 起始页

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public Pager(int totalRows) {
		this.totalRows = totalRows;
		totalPage = totalRows / pageSize;
		int mod = totalRows % pageSize;
		if (mod>0) {
			totalPage++;
		}
		currentPage = 1;
		startRow = 0;
	}

	// 这是用于链接首页的方法
	public void first() {
		currentPage = 1;
		startRow = 0;
	}

	// 这是用于链接上一页的方法
	public void previous() {
		startRow = (currentPage - 2) * pageSize;
	}

	// 这是用于链接下一也的方法
	public void next() {
		startRow = (currentPage - 1) * pageSize;
	}

	// 这是用于链接尾页的方法
	public void last() {
		currentPage = totalPage;
		startRow = (currentPage - 1) * pageSize;
	}

	// 这是用于获取此页面的页号
	public void refresh(int _currentPage) {
		currentPage = _currentPage;
		if (currentPage > totalPage) {
			last();
		}
	}
}