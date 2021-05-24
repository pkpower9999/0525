package kr.co.uk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import kr.co.uk.vo.BoardVO;
import kr.co.uk.vo.Criteria;


@Mapper
public interface BoardMapper {

	 public List<BoardVO> listPage(Criteria cri);
	 public int listCount();
	 
	 public List<BoardVO> getBoardList(RowBounds rowBounds);
	 public void insertPost(BoardVO vo);
	 public BoardVO getPost(int seq);
	 public void updatePost(BoardVO vo);
	 public Integer getCount();
	 public void deletePost(int seq);
	 public Integer getPassword(int seq, String password);
	 
}
