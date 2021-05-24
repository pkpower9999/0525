package kr.co.uk.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.uk.mapper.BoardMapper;
import kr.co.uk.vo.BoardVO;
import kr.co.uk.vo.Criteria;
import kr.co.uk.vo.PageVO;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	BoardMapper mapper;
	
	@Override
	public List<BoardVO> getBoardList(RowBounds rowBounds) {
		return mapper.getBoardList(rowBounds);
	}
	@Override
	public void insertPost(BoardVO vo) {
			mapper.insertPost(vo);
	}
	@Override
	public BoardVO getPost(int seq) {
		return mapper.getPost(seq);
	}
	@Override
	public void updatePost(BoardVO vo) {
		mapper.updatePost(vo);
	}

	@Override
	public Integer getCount() {
		return mapper.getCount();
	}
	@Override
	public void deletePost(int seq) {
		mapper.deletePost(seq);
	}
	@Override
	public Integer getPassword(int seq, String password) {
		return mapper.getPassword(seq, password);
	}
	@Override
	public List<BoardVO> listPage(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.listPage(cri);
	}
	@Override
	public int listCount() {
		// TODO Auto-generated method stub
		return mapper.listCount();
	}
}
