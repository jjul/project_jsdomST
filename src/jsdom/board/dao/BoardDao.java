package jsdom.board.dao;

import java.util.List;

import jsdom.board.domain.Board;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BoardDao {
	
	public List<Board> list(RowBounds rb);
	
	public int listCnt();
	
	public List<Board> content(@Param("no") int no);
	
	public void write(@Param("name") String name, @Param("subject") String subject, @Param("content") String content);
	
	public void update(@Param("no") int no, @Param("subject") String subject, @Param("content") String content);
	
	public void delete(@Param("no") int no);
	
}
