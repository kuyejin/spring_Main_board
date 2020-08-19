package edu.bit.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.page.Criteria;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

	

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private BoardMapper mapper;
	

	@Override
	public List<BoardVO> getList() {
		log.info("getList.........");				
		return mapper.getList();
	}


	
//	@Override
//	public BoardVO get(int bno) {
//		log.info("get.........");	
//		return mapper.read(bno);
//	}		
	@Override
	public BoardVO get(int bno) {
		log.info("get.........");		
		BoardVO boardVO = mapper.read(bno);
		                  mapper.upHit(bno);
		                  
		                  
		return boardVO;
	}


	@Override
	public int remove(int bno) {
		log.info("getremove.........");		
		return mapper.delete(bno);				
	}

//====================================================================================	
//	@Override
//	public void write(String bName, String bTitle, String bContent) {
//		log.info("getwrite.........");		
//		mapper.insertBoard(bName,bTitle,bContent);	
//	}	

	@Override
	public void write(BoardVO boardVO) {
		log.info("getwrite.........");		
		mapper.insertBoard(boardVO);				
	}

// [replyView는 작성할 필요없음]====================================================================================	
//	@Override
//	public BoardVO replyView(int bno) {
//		log.info("getreplyview.........");
//		return mapper.reply_view(bno);	
//	}

	
	
// [reply]====================================================================================	
//	@Override
//	public void reply(int bId, String bName, String bTitle, String bContent, 
//			          int bGroup, int bStep,int bIndent) {
//		log.info("getreply........");
//		mapper.insertReply(bId, bName, bTitle, bContent, bGroup, bStep, bIndent);
//	}	
	
	@Transactional(rollbackFor = Exception.class) 
	@Override
	public void reply(BoardVO boardVO) {		
		log.info("getreply........");				
		mapper.updateShape(boardVO);
		mapper.insertReply(boardVO);
	}
	/*	*reply 와 replyShape 처리
	 서비스단에서 함수 한개를 만들어서 맵퍼에서 호출해서 한꺼면에 묶는다
	  컨트롤러에서는 묶은것은 한개로 호출한다 ->이 방법으로 구현해야 한다.
	  서비스단은 비즈니스로직단이기 때문에 여기서 작업을 처리해야한다. 
	  컨트롤러는 로직을 위한단이 아니다 -> 캡슐화되어있어야 한다. */
	
	//
	


// [modify]====================================================================================	
//	@Override
//	public void modify(int bId, String bName, String bTitle, String bContent) {		
//		log.info("getmodify........");		
//		mapper.modify(bId, bName, bTitle, bContent);	
//	}
	
	@Override
	public void modify(BoardVO boardVO) {		
		log.info("getmodify........");		
		mapper.modify(boardVO);	
	}
	
	
	
	
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<BoardVO> getList(Criteria criteria) {
		log.info("get List with criteria"  + criteria);
		return mapper.getListWithPaging(criteria);
	}
	
	
	
	
	
}
