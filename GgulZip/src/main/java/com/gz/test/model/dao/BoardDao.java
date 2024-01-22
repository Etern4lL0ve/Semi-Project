package com.gz.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.gz.common.JDBCTemplate;
import com.gz.test.model.vo.Board;

public class BoardDao {

	public int insertBoard(Connection conn, Board b) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO BOARD(BOARD_NUM,BOARD_TITLE,BOARD_WRITER,BOARD_CONTENT) VALUSE(SEQ_BNO.NEXTVAL,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardWriter());
			pstmt.setString(3, b.getBoardContent());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(pstmt);
			
		}
		
		
		return result;
	}

}
