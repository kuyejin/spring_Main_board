package edu.bit.board.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;



//우리가 여태까지 datasource한거는 servlet-context.xml에 넣었다. 컨트롤러가  servlet-context.xml에 들어있다. 객체 생성을 해서 그 객체를 통해 간다.
//클라이언트가 웹브라우저에서 url로 입력하게 되면 디스패처 서블릿에서 처리해주는데, 디스패처 서블릿 오기 전에 web.xml에서 미리 한 번 필터 거친다. 한글 utf 처리. 디스패처서블릿까지는 web.xml에서 객체 생성한다. 
//(통신)컨트롤러하기 위해서는 핸들러 매핑, 핸들러 아답타에서 컨트롤러에 있는 함수 실행하고, viewresolver까지는 servlet.xml에서 세팅해놨습니다. 그러고 에노테이션 드리븐해서 객체생성했습니다. 
//더 들어가게되며느, db부분이 있고, dao는  root.xml로 세팅했습니다.

//9.
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) //두 개 다 읽어온다. root-context.xml에 <context:component-scanbase-package="edu.bit.board.service"> 여기서 읽어들인다.
@Log4j
//8. test만들었따.
public class BoardControllerTest {
	//10. BoardControllerTest 안에다가 webApplicationContext(스프링 mvc= IOC컨테이너이다. 객체 전부다 관리하는 IOC컨테이너 없으면 스프링 아닙니다.) 언제 생성된다?
	//    얘에 대한  setter함수 만들고, ctx에 4바이트 객체 주소 넣겠다는건데, 어디서 가져오는거지?
	//	  set함수 하나 만들어서 autowired하라는데, webApplicationContext 안에 컨트롤러가 들어가있다. servlet, root 읽는다.
	//    스프링에 프레임워크를 만들어야하는 상황이 온다. 컨트롤 c+v할게 아니다.
	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;
	
	//11. mockMvc 안에 ctx 넣어놓으면, 해당 컨트롤러를 컨트롤 할 수 있다. 
	//MockMvc란? 실제 객체와 비슷하지만 테스트에 필요한 기능만 가지는 가짜 객체를 만들어서 애플리케이션 서버에 배포하지 않고도 스프링 mvc 동작을 재현할 수 있는 클래스 의미한다.
	//한마디로 서버 역할을 할 수 있다. (서버 역할 할 수 있는 함수를 가지고 있다.) 
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	/*
	 @GetMapping("/list")
	 public void list(Model model) {	컨트롤러에서 앞에 void가 있으면, 모델앤뷰에서 리턴값이 list.jsp로 갑니다. 
		 log.info("list");
		 model.addAttribute("list", service.getList());	
	 }*/
	
	@Test
	public void testList() throws Exception {
		 mockMvc.perform(get("/list"))  //get방식으로 list 치고 들어가면,
		 .andExpect(status().isOk())//응답 검증.  목이 알아서 테스트 해준다.
		 .andDo(print()) //andDo: 응답에 대한 프로토콜 메세지를 뿌려준다.
         .andExpect(forwardedUrl("/WEB-INF/views/list.jsp"));
	}

	//단위테스트 했다는거 목록에 다 넣자......!!!!!!!!!!!!!!!!!

}
