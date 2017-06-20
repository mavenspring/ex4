package com.choa.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.choa.board.BoardDTO;
import com.choa.ex4.MyTestConfiguration;
import com.choa.util.ListInfo;
import com.choa.util.PageMaker;


public class NoticeDAOimplTest extends MyTestConfiguration{

	@Inject
	private  NoticeDAOimpl noticeDAOimpl;
	
	/*//@Test
	public void connectionTest()throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(55);
		noticeDTO.setWriter("Americano");
		noticeDTO.setTitle("커피 꿀맛");
		noticeDTO.setContents("hohoho");
		int result =  noticeDAOimpl.boardUpdate(noticeDTO);
		System.out.println("result Test : "+result);
		assertEquals(1, result);
	}*/
	/*//@Test
	public void deleteTest()throws Exception{
		int num = 441;
		int result =  noticeDAOimpl.boardDelete(num);
		System.out.println("result Test : "+result);
		assertEquals(1, result);
	}*/
	@Test
	public void list_Test()throws Exception{
		ListInfo listInfo = new ListInfo();
		listInfo.setFind("test");
		listInfo.setSearch("writer");
		int count =noticeDAOimpl.boardCount(listInfo);
		
		System.out.println("count : "+count);
		assertNotEquals(0, count);
		
	}
	/*//@Test
	public void count_Test()throws Exception{
		int count = noticeDAOimpl.boardCount();
		System.out.println("count : "+count);
		assertNotEquals(0, count);
		
	}*/
}
