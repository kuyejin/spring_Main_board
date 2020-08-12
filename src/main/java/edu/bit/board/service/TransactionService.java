package edu.bit.board.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class TransactionService {
	
	private BoardMapper boardMapper;
		
    public void transionTest1() {   
	    log.info("transionTest1()테스트");
	    
	    BoardVO boardVO = new BoardVO();
	    boardVO.setbContent("트랜잭션1");
	    boardVO.setbName("트랜잭션1");
	    boardVO.setbTitle("트랜잭션1");
	    
	    boardMapper.insertBoard(boardVO);
	    
	    
	    boardVO.setbContent("트랜잭션1-1");
	    boardVO.setbName("트랜잭션1-1");
	    boardVO.setbTitle("트랜잭션1-1");
	    
	    boardMapper.insertBoard(boardVO); 
	    
	  //db에 트랜잭션1과 1-1뜸 ->500에러가 뜬다
    }
        

	public void transionTest2() {
	  log.info("transionTest2()테스트");
	    
	    BoardVO boardVO = new BoardVO();
	    boardVO.setbContent("트랜잭션2");
	    boardVO.setbName("트랜잭션2");
	    boardVO.setbTitle("트랜잭션2");
	    
	    boardMapper.insertBoard(boardVO);
	    
	    
	    boardVO.setbContent("트랜잭션2-1");
	    boardVO.setbName("트랜잭션2-1");
	    boardVO.setbTitle("트랜잭션2-1");
	    
	    boardVO = null;
	    
	    boardMapper.insertBoard(boardVO);		
	
	  //db에 트랜잭션2만뜸 ->500에러가 뜬다
	}
	
	
	@Transactional
	public void transionTest3() {
		  log.info("transionTest3()테스트");
		    
		    BoardVO boardVO = new BoardVO();
		    boardVO.setbContent("트랜잭션3");
		    boardVO.setbName("트랜잭션3");
		    boardVO.setbTitle("트랜잭션3");
		    
		    boardMapper.insertBoard(boardVO);
		    
		    
		    boardVO.setbContent("트랜잭션3-1");
		    boardVO.setbName("트랜잭션3-1");
		    boardVO.setbTitle("트랜잭션3-1");
		    
		    //트랜잭션을 위해 일부러 에러를 나게 함 
		    //db에 트랜잭션 하나도 안들어감 -> 500에러남
		    //@Transactional이 이전상태로 롤백을 시켜줌 - 인서트했던 것도 날려줌
		    boardVO = null;
		    
		    boardMapper.insertBoard(boardVO);		
		}
	
	@Transactional
	public void transionTest4() {
		  log.info("transionTest4()테스트");
		    
		    BoardVO boardVO = new BoardVO();
		    boardVO.setbContent("트랜잭션4");
		    boardVO.setbName("트랜잭션4");
		    boardVO.setbTitle("트랜잭션4");
		    
		    boardMapper.insertBoard(boardVO);
		    		   
		    
		    throw new RuntimeException("RuntimeExcepion for rollback"); 
		    //강제적으로 에러나게 함 - RuntimeExcepion에러  
		    //-> 그러므로 트랜잭션이 에러전의 상태로 롤백해준다	-> db에 아무정보도 들어가지 않음
		    
		    
		}
	
	@Transactional
	public void transionTest5() throws IOException  {
		  log.info("transionTest5()테스트");
		    
		    BoardVO boardVO = new BoardVO();
		    boardVO.setbContent("트랜잭션5");
		    boardVO.setbName("트랜잭션5");
		    boardVO.setbTitle("트랜잭션5");
		    
		    boardMapper.insertBoard(boardVO);
		    		   
		  throw new IOException("IOException for rollback");
		  //try catch로 묶거나 throws로 던진다
		  //너가 알아서 하라고 예외처러하라고 강제적으로 시키기 때문에 롤백을 안된다.
		  //그렇기 때문에 db에 "트랜잭션5"가 삽입된다
		  
		  

	}
	
	//transionTest5()를 롤백이 되게 하려면?
	//@Transactional의 rollbackFor 옵션을 이용하면 Rollback이 되는 클래스를 지정가능함
	//Exception예외로 롤백을 하려면 다음과 같이 지정하면 됩니다
	//@Transactional(rollbackFor = Exception.class) 
	//여러개의 예외를 지정할 수도 있다.
	//@Transactional(rollbackFor = {RuntimeExcepion.class, Exception.class})
	
	@Transactional(rollbackFor = Exception.class) //다형성적용
	public void transionTest6() throws IOException  {
		  log.info("transionTest5()테스트");
		    
		    BoardVO boardVO = new BoardVO();
		    boardVO.setbContent("트랜잭션6");
		    boardVO.setbName("트랜잭션6");
		    boardVO.setbTitle("트랜잭션6");
		    
		    boardMapper.insertBoard(boardVO);
		    		   
		  throw new IOException("IOException for rollback");

        //롤백이 되었기 때문에 db에 아무정보도 들어가지 않는다
	}
	

	

}
