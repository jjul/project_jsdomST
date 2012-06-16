package jsdom.board.web;

import java.util.List;

import jsdom.board.domain.Board;
import jsdom.board.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	
	@RequestMapping(value="/list/{currentPage}", method=RequestMethod.GET) 
	public String list(ModelMap model, @PathVariable("currentPage") int currentPage) {
		model.addAttribute("list", boardService.list((currentPage-1)*10));
		model.addAttribute("listCnt", boardService.listCnt());
		return "list";
	}
	
	
	// @ResponseBody 적용해서 json 타입으로 받을수 있게한다
	// org.springframework.http.converter.json.MappingJacksonHttpMessageConverter 를 설정해야 json 타입으로 받을수 있다 
	// lib => jackson-core-asl-1.9.6.jar, jackson-mapper-asl-1.9.6.jar 추가함 
	// 설정안하면 406 에러남 ㅋㅋ 
	@RequestMapping(value="/listJson/{currentPage}", method=RequestMethod.GET) 
	@ResponseBody
	public List<Board> listJson(ModelMap model, @PathVariable("currentPage") int currentPage) {
		return boardService.list((currentPage-1)*10);
	}
	
	
	// @ResponseBody 사용시 한글깨져서 문제였는데 jsdom.com.util.UTF8StringBeanPostProcessor 로 해결함 ㅋㅋ
	// UTF8StringBeanPostProcessor 를 적용안하면  @ResponseBody 대신에  handleAJAX() 처럼 적용해서 사용하면 된다
	@RequestMapping(value="/Utf8Test", method=RequestMethod.GET)
	public ResponseEntity<String> handleAJAX() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		return new ResponseEntity<String>("한글 테스트 ㅋ", responseHeaders, HttpStatus.CREATED);
	} 
	
	
	@RequestMapping(value="/content/{no}", method=RequestMethod.GET)
	public String content(ModelMap model, @PathVariable("no") int no) {
		model.addAttribute("content", boardService.content(no));
		return "/content";
	}  
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(ModelMap model, @ModelAttribute Board board) {
		boardService.write(board);
		return "redirect:/list/1";
	}
	
	@RequestMapping(value="/update/{no}", method=RequestMethod.GET)
	public String update(ModelMap model, @PathVariable("no") int no) {
		model.addAttribute("update", boardService.content(no));
		return "/write";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute Board board) {
		boardService.update(board);
		return "redirect:/list/1";
	}
	
	@RequestMapping(value="/delete/{no}", method=RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable("no") int no) {
		boardService.delete(no);
		return"redirect:/list/1";
	}
	
}


