package edu.bit.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.UserVO;


public interface LogInMapper { 
	
	@Select("select * from users where username = #{username} and password = #{password}")
	UserVO LogInUser(@Param("username") String username, @Param("password") String password);
}

	
	
	
	
	
	
	