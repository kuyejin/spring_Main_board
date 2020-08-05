package edu.bit.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
//spring v4.0 이후 버전(@Controller + @ResponseBody)  //기존문법 무시
@RestController //(Controller+@ResponseBody) 예전에 만들었던 기존 문법을 버리는거. 
//@Controller
@Log4j
@AllArgsConstructor 
 class RestBoardSpring4AfterController {
   
   
   private BoardService boardservice; 
   
   //메서드의 리턴타입을 기존과 다르게 처리한다는 것을 명시 
   //@ResponseBody  //@RestController적으면 ResponseBody필요없다.
   @CrossOrigin //같은 로컬접속 
   @RequestMapping("/restful/after")
   public List<BoardVO> before() {  //자바객체를 어떻게 body로 보내느냐(전달하느냐).. 스프링이 알아서 json내지 xml로 보낸다.
      //자바 객체를 XML로 바꿔주는 무언가(객체)가 있다.  pom.xml에서 jackson, gson
      log.info("rest/after");
      List<BoardVO> list = boardservice.getList();
     
      return list;  //return값이 예전에는 view이름이었는데 지금은 패러다임이 바꼇다.
      //예전에는 .jsp 를 기준으로 리턴했으나 지금은 참조형 list를 반환하고 있음. 새로운 패러다임이다. 
      //또다른 @RestController 문법을 따르겠다는 의미.
      //이번에는 데이터를 집접 받아와보자. view로 가서 jquesryList ctrl c,v하여 ajaxlist
      
   }
   
   
   //content_view.jsp에서 delete받아내야함
    @DeleteMapping("/rest/delete/{bId}")//도 가능
   //@RequestMapping(value = "/rest/delete/{bId}", method = RequestMethod.DELETE)
	public int restDelete(@PathVariable("bId") int bId) {
   	
   	    log.info("restDelete");
		return  boardservice.remove(bId);
	}
   
   
}