package edu.bit.board.service;

import java.util.List;

import edu.bit.board.vo.BoardVO;

public interface BoardService {
	
	//게시판 리스트
	public abstract List<BoardVO> getList();

	public abstract BoardVO get(int bno);

	public abstract int remove(int bno);

	//public abstract void write(String bName, String bTitle, String bContent);
	public abstract void write(BoardVO boardvo);

	
	//public abstract BoardVO replyView(int bno);

    
	//public abstract void reply(int bId, String bName, String bTitle, String bContent, int bGroup,int bStep, int bIndent);
	public abstract void reply(BoardVO boardVO);
	

	
	//public abstract void modify(int bId, String bName, String bTitle, String bContent);
	public abstract void modify(BoardVO boardVO);


	

}
