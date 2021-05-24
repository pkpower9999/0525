package kr.co.uk.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.uk.dao.BoardDao;
import kr.co.uk.vo.BoardVO;
import kr.co.uk.vo.Criteria;
import kr.co.uk.vo.PageVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao dao;
	
	@Override
	public List<BoardVO> getBoardList(int page) {
		
		int page_listcnt = 10;
		int start = (page -1) * page_listcnt;
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
		
		return dao.getBoardList(rowBounds);
	}
	@Override
	public void insertPost(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.insertPost(vo);
	}
	@Override
	public BoardVO getPost(int seq) {
		// TODO Auto-generated method stub
		return dao.getPost(seq);
	}
	@Override
	public void updatePost(BoardVO vo) {
		// TODO Auto-generated method stub
		dao.updatePost(vo);
	}
	@Override
	public PageVO getCount(int currentPage) {
		int page_listcnt = 10;
		int page_paginationcnt = 10;
		int content_cnt = dao.getCount();
		PageVO pageVO = new PageVO(content_cnt, currentPage, page_listcnt, page_paginationcnt);
		
		return pageVO;
	}
	
	@Override
	public void deletePost(int seq) {
		// TODO Auto-generated method stub
		dao.deletePost(seq);
	}
	
	@Override
	public Integer getPassword(int seq, String password) {
		// TODO Auto-generated method stub
		return dao.getPassword(seq, password);
	}
	
	@Override
	public List<BoardVO> listPage(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.listPage(cri);
	}
	@Override
	public int listCount() {
		// TODO Auto-generated method stub
		return dao.listCount();
	}
}
