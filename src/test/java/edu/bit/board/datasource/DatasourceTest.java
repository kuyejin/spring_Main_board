package edu.bit.board.datasource;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class) //스프링테스트를 위한 환경구축 코드.  톰캣을 구동안해도 ioc컨테이너를 불러와서 테스트하는 것이다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //IOC 컨테이너를 활용하여 해당경로를 탐색
@Log4j //src/main/resources 폴더에 log4 프로퍼티 파일을 복붙하고 src/main/java 에도 해당 파일을 복붙하자.
public class DatasourceTest {

	@Inject //ioc컨테이너에 있는 데이터 소스를 아래 객체에 주입한다.
	private DataSource dataSource;
	
	@Test
	public void testDatasource() {
		//fail("Not yet implemented");
		
		System.out.println("Result: " + dataSource);
		
	}

}


//테스트 과정 : 단위(함수) -> 통합 -> 시스템 -> 인수
//정식스 코멘트: 단위테스트를 어떤 과정으로 했는지에 대해 PPT로 만들어서 어필하십시오. 나는 이렇게까지 꼼꼼하게 할줄 안다라는 것을 증명해야한다.


