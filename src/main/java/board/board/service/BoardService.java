package board.board.service;

import java.util.List;

import board.board.dto.BoardDto;

public interface BoardService {
	
	List<BoardDto> selectBoardList() throws Exception;
	
	int insertBoard(BoardDto board) throws Exception;
	
	BoardDto selectBoardDetail(int boardIdx) throws Exception;
	
	int updateBoard(BoardDto board) throws Exception;

	int deleteBoard(int boardIdx) throws Exception;
}
