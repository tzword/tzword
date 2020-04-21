package com.youying.western.tools;

public class Pager {
	private int totalRows;// ������
	private int pageSize=10;// ÿҳ��ʾ������
	private int currentPage;// ��ǰҳ��
	private int totalPage;// ��ҳ��
	private int startRow;// ��ʼҳ

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

	// ��������������ҳ�ķ���
	public void first() {
		currentPage = 1;
		startRow = 0;
	}

	// ��������������һҳ�ķ���
	public void previous() {
		startRow = (currentPage - 2) * pageSize;
	}

	// ��������������һҲ�ķ���
	public void next() {
		startRow = (currentPage - 1) * pageSize;
	}

	// ������������βҳ�ķ���
	public void last() {
		currentPage = totalPage;
		startRow = (currentPage - 1) * pageSize;
	}

	// �������ڻ�ȡ��ҳ���ҳ��
	public void refresh(int _currentPage) {
		currentPage = _currentPage;
		if (currentPage > totalPage) {
			last();
		}
	}
}