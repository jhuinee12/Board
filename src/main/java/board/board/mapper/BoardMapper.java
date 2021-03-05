package board.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import board.board.dto.BoardDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> selectBoardList() throws Exception;
	
	int insertBoard(BoardDto board) throws Exception;
	
	BoardDto selectBoardDetail(int boardIdx) throws Exception;
	
	int updateHitCount(int boardIdx) throws Exception;
	
	int updateBoard(BoardDto board) throws Exception;

	int deleteBoard(int boardIdx) throws Exception;
}
