package com.gz.chat.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gz.chat.model.dao.ChatDao;
import com.gz.chat.model.vo.Chat;
import com.gz.common.JDBCTemplate;

public class ChatService {



    public int saveChatMessage(String chatName, String chatContent) {
    	
    	Connection conn = JDBCTemplate.getConnection();
    	
    	int result = new ChatDao().saveChatMessage(chatName, chatContent,conn);
    	
    	if(result>0) {
    		JDBCTemplate.commit(conn);
    	}else {
    		JDBCTemplate.rollback(conn);
    	}
    	JDBCTemplate.close(conn);
    	
    	
    	return result;
    }

	
	public ArrayList<Chat> getChatMessages() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Chat> list = new ChatDao().getChatMessages(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}


	}


