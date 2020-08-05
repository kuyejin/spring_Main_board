package edu.bit.board.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
@AllArgsConstructor 
 class RestBoardSpring4BeforeController {
   
   
   private BoardService boardservice; 
   

   @ResponseBody  //restful관련 어노테이션.  http 프로토콜을 body쪽으로 보낸다는 의미.//메서드의 리턴타입을 기존과 다르게 처리한다는 것을 명시
   @RequestMapping("/restful/before")
   public List<BoardVO> before() {  //자바객체를 어떻게 body로 보내느냐(전달하느냐).. 스프링이 알아서 json내지 xml로 보낸다.
      //자바 객체를 XML로 바꿔주는 무언가(객체)가 있다.  pom.xml에서 jackson, gson
      log.info("rest/before");
      List<BoardVO> list = boardservice.getList();
     
      return list;  //return값이 예전에는 view이름이었는데 지금은 패러다임이 바꼇다.
      //예전에는 .jsp 를 기준으로 리턴했으나 지금은 참조형 list를 반환하고 있음. 새로운 패러다임이다. 
      
   }
   
   
   
}