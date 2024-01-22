package com.gz.chat.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.gz.chat.model.vo.Chat;
import com.gz.common.JDBCTemplate;
import com.gz.post.model.dao.PostDao;

public class ChatDao {
	
	private Properties prop = new Properties();

	public ChatDao() {

		try {
			String filePath = PostDao.class.getResource("/db/sql/chat-mapper.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	 public int saveChatMessage(String chatName, String chatContent, Connection conn) {
	        PreparedStatement pstmt = null;
	        int result = 0;

	        try {
	            String sql = prop.getProperty("insertChatMessage");
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, chatName);
	            pstmt.setString(2, chatContent);
	            result = pstmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            JDBCTemplate.close(pstmt);
	        }

	        return result;
	    }

	    public ArrayList<Chat> getChatMessages(Connection conn) {
	        PreparedStatement pstmt = null;
	        ResultSet rset = null;
	        ArrayList<Chat> list = new ArrayList<>();

	        try {
	            String sql = prop.getProperty("selectChatMessages");
	            pstmt = conn.prepareStatement(sql);
	            rset = pstmt.executeQuery();

	            while (rset.next()) {
	                Chat chat = new Chat();
	                chat.setChatName(rset.getString("CHAT_NAME"));
	                chat.setChatContent(rset.getString("CHAT_CONTENT"));
	                chat.setChatDate(rset.getDate("CHAT_DATE"));

	                list.add(chat);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            JDBCTemplate.close(rset);
	            JDBCTemplate.close(pstmt);
	        }

	        return list;
	}
	


	

}
