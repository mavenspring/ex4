package com.choa.freeboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;
import javax.xml.stream.events.Namespace;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDTO;
import com.choa.util.DBConnector;
import com.choa.util.RowMaker;

@Repository
public class FreeboardDAOimpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE ="FreeboardMapper.";

	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker,String search,String find) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"list", rowMaker);
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"view",num);
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"write",boardDTO);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"update",boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		
		
		return sqlSession.delete(NAMESPACE+"delete",num);
	}

	@Override
	public int boardCount() throws Exception {
		
	
		return sqlSession.selectOne(NAMESPACE+"count");
		
	}

	@Override
	public void boardHit(int num) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
