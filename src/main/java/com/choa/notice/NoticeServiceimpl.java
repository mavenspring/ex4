package com.choa.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.MakePage;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

@Service
// NoticeService noticeService = new NoticeService();
public class NoticeServiceimpl implements BoardService{
	
	@Inject
	private NoticeDAOimpl noticeDAO;
	
	/*public NoticeService(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	*/
	
	@Override
	public List<BoardDTO> boardList(Integer curPage,String search, String find) throws Exception {
		int result = noticeDAO.boardCount(); //페이징할때 필요
		PageMaker pageMaker = new PageMaker(curPage);
		
		
		return noticeDAO.boardList(pageMaker.getRowMaker(null, null),search,find);
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		return noticeDAO.boardView(num);
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardWrite(boardDTO);
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardUpdate(boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		return noticeDAO.boardDelete(num);
	}

}
