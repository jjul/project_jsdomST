package jsdom.board.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jsdom.board.dao.BoardDao;
import jsdom.board.domain.Board;


@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao; 

	
	public List<Board> list(int currentPage) {
		return boardDao.list(new RowBounds(currentPage, 10));
	}
	
	public int listCnt() {
		return boardDao.listCnt();
	}

	public List<Board> content(int no) {
		return boardDao.content(no);
	}
	
	public void write(Board board) {
		boardDao.write(board.getName(), board.getSubject(), board.getContent());	
	}
	
	public void update(Board board) {
		boardDao.update(board.getNo(), board.getSubject(), board.getContent());
	}
	
	public void delete(int no) {
		boardDao.delete(no);
	}
	
}
