package cn.edu.zhku.jsj.domain;

public class PageBean {
	private int totalCount;//总记录数
    private int pageLine;//每页查询记录数 （每页的商品个数）
    private int currentPage;//当前页码
    private int pageNum;//总页数
    private int start;//查询起始点
    private int end;//查询结束点
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageLine() {
		return pageLine;
	}
	public void setPageLine(int pageLine) {
		this.pageLine = pageLine;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	
}
