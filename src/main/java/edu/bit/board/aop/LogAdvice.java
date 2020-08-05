package edu.bit.board.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//Aspect: 공통기능이 들어있는 클래스(예제, 로깅.., 트랜잭션..)
//Advice: Aspect 클래스에 들어있느 공통기능(한마디로 Aspect 안의 함수)
//JoinPoint: advice 함수가 적용되는  함수.  =   공통기능이 들어가는  함수를 의미
//PointCut: Joinpoint의 부분으로 실제로 적용되는 함수내의 지점
//Weaving: Advice를 적용하는 행위

@Component
@Aspect   //공통기능이 들어 있는 클래스(예제, 로깅.., 트랜잭션..)
public class LogAdvice {
	@Before("within(edu.bit.board.*)")  //이번에는 전체.
	//@Before("within(edu.bit.board.service*)")   //여기에 있는 것을 집어넣겠다.  여기있는 함수가 시작되기 바로 직전에 printLogging()이 함수를 넣겠다.
	public void printLogging() {
		System.out.println("공통기능 - 프린트 로그");
	}  //공통기능을 다른쪽 함수에 이 함수를 집어넣어보겠다!!  스프링에서는 xml세팅을 통해 할 수 있도록 만들어놓았다.

}
