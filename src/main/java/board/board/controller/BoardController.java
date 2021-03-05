package board.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



import board.board.dto.BoardDto;
import board.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	//@RequestMapping("/board/openBoardList.do")
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public ModelAndView openBoardList() throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardList");
		log.debug("openBoardList");
		//에러 발생용
		//int i = 10 / 0 ;
		
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		
		return mv;
	}
	
	//@RequestMapping("/board/openBoardWrite.do")
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String openBoardWrite() throws Exception{
		return "/board/boardWrite";
	}
	
	//@RequestMapping("/board/insertBoard.do")
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String insertBoard(BoardDto board) throws Exception{
		int result = boardService.insertBoard(board);
		if(result == 1) {
			//성공 메시지
		}
		
		return "redirect:/board";
	}
	
	//@RequestMapping("/board/openBoardDetail.do")
	@RequestMapping(value="/board/{boardIdx}", method=RequestMethod.GET)
	public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardDetail");
		
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		
		return mv;
	}
	
	//@RequestMapping("/board/updateBoard.do")
	@RequestMapping(value="/board/{boardIdx}", method=RequestMethod.PUT)
	public String updateBoard(BoardDto board) throws Exception{
		int result = boardService.updateBoard(board);
		if(result == 1) {
			//성공 메시지
		}
		
		return "redirect:/board";
	}
	
	//@RequestMapping("/board/deleteBoard.do")
	@RequestMapping(value="/board/{boardIdx}", method=RequestMethod.DELETE)
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
		int result = boardService.deleteBoard(boardIdx);
		if(result == 1) {
			//성공 메시지
		}
		
		return "redirect:/board";
	}
	
	
}
