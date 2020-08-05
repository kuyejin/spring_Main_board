package edu.bit.board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


//Aspect: 공통기능이 들어있는 클래스(예제, 로깅.., 트랜잭션..)
//Advice: Aspect 클래스에 들어있느 공통기능(한마디로 Aspect 안의 함수)
//JoinPoint: advice 함수가 적용되는  함수.  =   공통기능이 들어가는  함수를 의미
//PointCut: Joinpoint의 부분으로 실제로 적용되는 함수내의 지점
//Weaving: Advice를 적용하는 행위

@Component   //객체로 올린다. aop-context.xml에<context:component-scan base-package="edu.bit.board.aop"></context:component-scan> 입력.
@Aspect
public class LogAOP {
	
	
	@Pointcut("execution(* edu.bit.board..*")
	private void pointcutMethod() {
		
	}
	//해당 함수 포인트값 지정
	
	@Around("within(edu.bit.board..*)") 
	//joinpoint: 공통기능 함수를 넣어야 하는 함수,list나 보드서비스에 들어있는 함수 에 넣어야 하는 기능에 대한 함수
	//보드컨트롤러 리스트를 가지고 있다.
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{  
		String signatureStr = joinpoint.getSignature().toShortString();  //보드컨트롤러 리스트를 가지고 있다.
		System.out.println( signatureStr + "is start.");
		
		
		long st = System.currentTimeMillis(); //공통기능
		
		try {
			Object obj = joinpoint.proceed();  //보드서비스.list다.(리스트실행)핵심기능에서 해당함수 실행시키는 부분.
			
			return obj;
		} finally {
			
			long et = System.currentTimeMillis();  //공통기능
			
			System.out.println( signatureStr + "is finished.");
			System.out.println( signatureStr + "경과시간 : " + (et - st));
		}
		
	}
}