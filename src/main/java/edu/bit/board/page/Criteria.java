package edu.bit.board.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Criteria {
	
	//페이징 처리를 위해선 페이지 번호(pageNum)와 한 페이지당  몇 개의 데이터(amount)를 보여줄 것인지 결정되어야 함.

	
	private int pageNum; //페이지 번호
	private int amount; //한 페이지당 몇 개의 데이터를 보여줄 것인가?
	
	public Criteria() { //디폴트
		this(1,10); // 기본 값  1페이지에 데이터 수는 10개로 지정
	}
	
	public Criteria(int pageNum, int amount) { //생성자
		this.pageNum = pageNum;
		this.amount = amount;
	}

}
