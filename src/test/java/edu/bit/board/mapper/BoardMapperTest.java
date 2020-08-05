package edu.bit.board.mapper;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.bit.board.vo.BoardVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringRunner.class)  //1. 스프링테스트
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")//3. 해당 xml을 띄우기 위해서 필요하다.
@Log4j//3. log 롬복
public class BoardMapperTest {
	//5.주입은 3가지 방식이 있다.(생성자, setter함수, 필드에 다이렉트로 넣는 방법 @AutoWired를 입력하면 되는데, 좋지 않은 방법이다.(필드를 여러 개 쓰면 안좋아짐.)
	
	@Setter(onMethod_= @Autowired)  //5. 보드매퍼에 대한 세터함수를 생성합니다. 롬복
	//@Inject
	//2. mapper는 dao다. 그리고 인터페이스다. 커넥션풀을 가져와서 db접속을 해야 하니까 커넥션 풀에 대한 내용을 가져와야 한다. 
	//4. root-context.xml에 있는 id dataSource(커넥션풀)를 가져와야 한다. 그리고 핵심은(mybatis)는 sqlSessionFactory다. 
	private BoardMapper boardMapper;  
	
	@Test
	public void testBoardMapper() {
		log.info(boardMapper); //6. 객체가 없으면 null이 찍히겠고, 아니면 값이 나오겠지.
		}
	
	//7. test하자. 반복문
	@Test
	public void testBoardMapperList() {
		List<BoardVO>list = boardMapper.getList();
		
		for(BoardVO boardVO : list) {
			log.info(boardVO.getbContent());
			log.info(boardVO.getbName()); 
			//내가 어떻게 매퍼 테스트 했는지 ppt에 남겨줘야 합니다. junit 습관 들이자.
			//test get를 잘 잡아야 에러를 잡을 수 있다.
			
			//8. 컨트롤러를 테스트 해보자. 컨트롤러를 객체생성해서 mapping list 받아낼 수 있나? 객체만 생성한다고 무조건 되는거 아닙니다. 통신이기 때문에 웹브라우저 통해서 서버(톰캣)이 받아내야해요.
			//'/list'라는 것을 url이 받아내야하는데, 절대 스프링에서 하는 것이 아닌, 톰캣에서 url 치고 들어오는 것을 받아내야 합니다. 따라서 웹서버를 돌려야 합니다. 웹서버를 돌려서 테스트 할 바에는 실전에서   
		}
	}

}
