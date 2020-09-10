package edu.bit.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.page.Criteria;
import edu.bit.board.page.PageDTO;
import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
//test
@Controller
@Log4j
@AllArgsConstructor  //롬복. 컨트롤러에 대해서 보드서비스 데이터 맴버를 집어 넣으라 해서 자동으로 생성됨. 생성자가 있으면 아래서 auto로 넣어준다.
public class BoardController {
	

	private BoardService service; //비즈니스로직(처리해야할것들)이 보드서비스에 들어간다
	//new도 안했고 AutoWired(Inject)도 안했는데 어떻게 가져왔을까?
	//-스프링5에서는 생성자가 있으면 Auto(자동)로 넣어준다
	//@AllArgsConstructor를 넣어주면 자동으로 밑에 코드를 생성해준다
    //@Inject
	//public BoardService(BoardService service){	
	//    this.service = service;
	
	
	
	@GetMapping("/list") //get방식으로 받겠다
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());		
		//test하려면 url(/list)를 받아내야 한다 - 받아내는 주체는 톰캣이다 ->테스트하려면 웹서버돌려야함				
	}
	
	
	//★★해킹을 막는 첫번째 방법  -> 1. 날코딩 방법
	/*
	 * @GetMapping("/list") public String list(HttpServletRequest req, Model model)
	 * {
	 * 
	 * HttpSession session = request.getSession(); UserVO = (UserVO)
	 * session.getAttribute("user");
	 * 
	 * if(user != null) { model.addAttribute("list", service.getList()); }else {
	 * retrun "redirect:" }
	 *}
	 */
	
  
	@GetMapping("/content_view") //get방식으로 받겠다
	public String content_view(BoardVO boardVO, Model model) {
		log.info("content_view");
		model.addAttribute("content_view", service.get(boardVO.getbId()));//model에id가 들어간다
		
		return "content_view";
	}	
	
	
	@GetMapping("/delete") //get방식으로 받겠다
	public String delete(BoardVO boardVO) {
		log.info("delete");
		service.remove(boardVO.getbId());
		
		return "redirect:list";
	}
	

	@GetMapping("/write_view") 
	public String write_view() {
		log.info("write_view");
			
		return "write_view";
	}
	
	
//===================================================================================================	
	/*
	 * @GetMapping("/write") public String write_view(BoardVO boardVO) throws Exception { 
     * log.info("write");
	 * service.write(boardVO.getbName(), boardVO.getbTitle(), boardVO.getbContent()
	 * );
	 * return "redirect:list"; }
	 */
	
	@GetMapping("/write") 
	public String write_view(BoardVO boardVO) throws Exception {
		log.info("write");
	    service.write(boardVO);			
		return "redirect:list";
	}
//===========================================================================================	


	
	@GetMapping("/reply_view") 
	public String reply_view(BoardVO boardVO, Model model) {
		log.info("reply_view");			
		model.addAttribute("reply_view", service.get(boardVO.getbId()));			
		return "reply_view";
	}
	
			

//====================================================================================================	
	/*
	 * @GetMapping("/reply") public String reply (BoardVO boardVO, Model model) {
	 * log.info("reply");
	 * service.reply(boardVO.getbId(), boardVO.getbName(),
	 * boardVO.getbTitle(),boardVO.getbContent(), boardVO.getbGroup(),
	 * boardVO.getbStep(), boardVO.getbIndent());
	 * return "redirect:list"; }
	 */
				
	@GetMapping("/reply") 
	  public String reply (BoardVO boardVO, Model model) throws Exception{
		  log.info("reply");		  
		  service.reply(boardVO);		  		  
		  return "redirect:list"; 
	}
		 
	
	
//=========================================================================================================	
//	@GetMapping("/modify") 
//	public String modify (BoardVO boardVO, Model model) {
//		log.info("modify");		
//		service.modify(boardVO.getbId(), boardVO.getbName(), boardVO.getbTitle(),boardVO.getbContent());					
//		return "redirect:list";
//	}
	
	@PostMapping("/modify") 
	public String modify (BoardVO boardVO, Model model) {
		log.info("modify");		
		service.modify(boardVO);					
		return "redirect:list";
	}
	
	
	@GetMapping("/jquerylist") 
	public String jquerylist(Model model) {
	   log.info("jquerylist");
	   model.addAttribute("list", service.getList()); 
	   return "jqueryList";
	}	
	
	//ajax 통신
	   @RequestMapping("/ajax/list")
	   public String ajaxList() {
	      
	      log.info("ajaxList");
	      return "ajaxlist";
	   }
	   
	   
	   
	   
	   @GetMapping("/list3") //void이므로 list3는 jsp여야 한다.
		 public void list2(Criteria cri, Model model) {	
			 log.info("list3");
			 log.info(cri);
			 model.addAttribute("list", service.getList(cri));	
			 
			 int total = service.getTotal(cri);
			 log.info("total" + total);
			 
			 model.addAttribute("pageMaker", new PageDTO(cri,total));	
		 }
	   //Criteria는 커멘드 객체
	   
	   
	
}
	

