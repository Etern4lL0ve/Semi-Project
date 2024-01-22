package com.gz.test.model.service;

import java.sql.Connection;

import com.gz.common.JDBCTemplate;
import com.gz.test.model.dao.BoardDao;
import com.gz.test.model.vo.Board;

public class BoardService {

	public int insertBoard(Board b) {

		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BoardDao().insertBoard(conn,b);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
			
		}else {
			
			JDBCTemplate.rollback(conn);
		}
			JDBCTemplate.close(conn);
		
		
		return result;
	}

}
