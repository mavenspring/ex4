package com.choa.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.choa.board.BoardDTO;
import com.choa.ex4.MyTestConfiguration;
import com.choa.util.PageMaker;


public class NoticeDAOimplTest extends MyTestConfiguration{

	@Autowired
	private NoticeDAOimpl noticeDAO;
	
	//@Test 이렇게 만해주면 실행안됨
	public void test()throws Exception {
		PageMaker pageMaker = new PageMaker(1,10);
		
		List<BoardDTO> ar = noticeDAO.boardList(pageMaker.getRowMaker(null, null));
		assertEquals(0, ar.size());    // null 이면 빨간색 not null 이면 초록색	
	}
	
	@Test
	public void test2()throws Exception{
		int result = noticeDAO.boardDelete(32);
		assertEquals(1, result); // (예상값, 코드 결과값) 
	}

}
