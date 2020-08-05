package edu.bit.board.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.board.mapper.LogInMapper;
import edu.bit.board.vo.BoardVO;
import edu.bit.board.vo.UserVO;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class LogInService {
	LogInMapper logInMapper;
	
	public UserVO loginUser(String id, String pw) {
		return logInMapper.LogInUser(id, pw);
	}
	
}
