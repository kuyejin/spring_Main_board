package edu.bit.board.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.bit.board.vo.UserVO;
import lombok.extern.log4j.Log4j;


/**
 * Handles requests for the application home page.
 */
//★★해킹을 막는 두번째 방법  ->2.인터셉터 (prehandler, posthandler 객체를 생성시킨다)
//filter는 web.xml에 설정 (filter는 서블릿 영역이기 때문에)
//db쪽은 root.xml에서 설정
//컨트롤까지 servlet.xml에서 설정

@Log4j
 public class BoardInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception{
		//preHandle함수안에서 컨트롤러 가기전에 막는다.
	
		log.info("preHandler 실행");

		//request객체안에 session을 가져온다
		HttpSession session = request.getSession();
		
		//login처리를 담당하는 사용자 정보를 담고 있는 객체를 가져옴
		UserVO user = (UserVO) session.getAttribute("user");
		
		if(user == null) {
			log.info("user가 null");
			
			//로그인이 안되어 있는 상태이므로 로그인 폼으로 다시 돌려보냄 (redirect)
			response.sendRedirect(request.getContextPath()); //context를  다시 새 방향으로 돌려 보낸다.
			
			return false; //더이상 컨트롤러 요청으로 가지 않도록 false로 반환함
		}
				
		return true;
	}
	
	@Override //끝까지 거친후 뷰까지 가져온다
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
	        throws Exception{
		
		super.postHandle(request,  response,  handler,  modelAndView);
		log.info("postHandle 실행");		
	}

	
}	
	

