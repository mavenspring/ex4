package com.choa.freeboard;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDAOimpl;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

@Service
public class FreeboardServiceimpl implements BoardDAO{

	@Inject
	private FreeboardDAOimpl freeboardDAOimpl;
	
	@Override
	public List<BoardDTO> boardList(Integer curPage) throws Exception {
		PageMaker pageMaker = new PageMaker(curPage);
		return freeboardDAOimpl.boardList(pageMaker.getRowMaker(null, null));
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void boardHit(int num) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
