package com.gz.chat.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.gz.chat.model.service.ChatService;
import com.gz.chat.model.vo.Chat;

/**
 * Servlet implementation class InsertChatController
 */
@WebServlet("/selectChat.ch")
public class SelectChatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ChatService chatService = new ChatService();


       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectChatController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	// ChatService를 호출하여 채팅 메시지 조회
        ArrayList<Chat> chatMessages = chatService.getChatMessages();

        // 조회 결과를 JSON 형식으로 응답
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(chatMessages));
	}


}