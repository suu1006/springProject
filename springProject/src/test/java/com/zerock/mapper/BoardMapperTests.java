package com.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_= @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("jeongsu");
		mapper.insert(board);
		log.info("testInsert=" + board);
	}
	
	@Test
	public void testInsertKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 selectKey");
		board.setContent("새로 작성하는 내용 selectKey");
		board.setWriter("jeongsu");
		mapper.insertSelectKey(board);
		log.info("testInsertKey=" + board);
	}
	
	@Test
	public void testRead() {
		BoardVO board  = mapper.read(7L);
		log.info("testRead=" + board);
	}
}
