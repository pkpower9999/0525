package kr.co.uk.vo;

public class PageVO {

	//최소페이지번호
	private int min;
	//최대페이지번호
	private int max;
	//이전 버튼의 페이지 번호
	private int prevPage;
	//다음 버튼의 페이지 번호
	private int nextPage;
	//전체 페이지 개수
	private int pageCnt;
	//현재 페이지 번호
	private int currentPage;
	
	//contentCnt: 전체글개수, currentPage:현재글 번호, contentPageCnt:페이지당글의개수, paginationCnt:페이지 버튼의개수
	public PageVO(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {
		
		//현재 페이지 번호
		this.currentPage = currentPage;
		
		//전체 페이지개수
		pageCnt = contentCnt / contentPageCnt;
		
		if(contentCnt % contentPageCnt > 0) {
			pageCnt++;
		}
		
		min = ((currentPage - 1)  / contentPageCnt) * contentPageCnt +1;
		max = min + paginationCnt - 1;
		
		if(max > pageCnt) {
			max = pageCnt;
		}
		
		prevPage = min - 1;
		nextPage = max + 1;
		if(nextPage > pageCnt) {
			nextPage = pageCnt;
		}
		
	}
	
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	
	
}
