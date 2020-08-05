package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import edu.bit.board.vo.BoardVO;



public interface BoardMapper { 
	//DAO와 같은 역할
	//Mapper는 무조건 인터페이스로 생성
	
	public abstract List<BoardVO> getList();
	//getList를 xml에서 처리한다

	public abstract BoardVO read(int bno);

	@Delete("Delete from mvc_board where bId = #{bno}") // xml에서 설정안해도 됨
	public abstract int delete(int bno);
	
	
	
	//public abstract void insertBoard(@Param("bName") String bName, @Param("bTitle") String bTitle, @Param("bContent") String bContent);
	public abstract void insertBoard(BoardVO boardvo);
	
	
// [reply_view는 작성할 필요없음]=============================================================================	
	//@Select("select * from mvc_board where bId = #{bno}")
	//public abstract BoardVO reply_view(int bno);

	
	
// [reply]===================================================================================================================================	
	//public abstract void insertReply(@Param("bId")int getbId, @Param("bName")String getbName, @Param("bTitle") String getbTitle, @Param("bContent") String getbContent, 
	//		@Param("bGroup") int getbGroup, @Param("bStep") int getbStep, @Param("bIndent") int getbIndent);	
	
	public abstract void updateShape(@Param("boardVO")BoardVO boardVO);
	public abstract void insertReply(BoardVO boardVO);
	//@Param("boardVO")로 넘기고 있는 데 mapper.xml에서는 #{boardVO.bGroup}, #{boardVO.bStep}만 받고 있다 ? 어떻게 전달?
	//#{bGroup}는 getbName을 내부적으로 호출한다
	//#{}는 getter함수를 호출하는 것
	

//[modify]=============================================================================================================================	
//	@Update("update mvc_board set bName = #{bName}, bTitle = #{bTitle}, bContent = #{bContent} where bId = #{bid}")
//	public abstract void modify(@Param("bid") int bId, @Param("bName") String bName, @Param("bTitle") String bTitle, @Param("bContent") String bContent);
	
	public abstract void modify(@Param("boardVO")BoardVO boardVO);
	
	
	
// [upHit]==================================================================================================	
	@Update("update mvc_board set bHit = bHit + 1 where bId = #{bno}")
	public abstract void upHit(int bno);
}	
	
	
	
	
	
	
	
	