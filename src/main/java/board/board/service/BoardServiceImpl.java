package board.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.board.dto.BoardDto;
import board.board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public List<BoardDto> selectBoardList() throws Exception{
		return boardMapper.selectBoardList();
	}

	@Override
	public int insertBoard(BoardDto board) throws Exception {
		return boardMapper.insertBoard(board);
	}

	@Override
	public BoardDto selectBoardDetail(int boardIdx) throws Exception {
		boardMapper.updateHitCount(boardIdx);
		
		BoardDto board = boardMapper.selectBoardDetail(boardIdx);
		return board;
	}

	@Override
	public int updateBoard(BoardDto board) throws Exception {
		return boardMapper.updateBoard(board);
	}

	@Override
	public int deleteBoard(int boardIdx) throws Exception {
		return boardMapper.deleteBoard(boardIdx);
	}
	
}
