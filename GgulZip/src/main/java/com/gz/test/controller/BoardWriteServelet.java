package com.gz.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gz.test.model.service.BoardService;
import com.gz.test.model.vo.Board;

/**
 * Servlet implementation class BoardWriteServelet
 */
@WebServlet("/binsert")
public class BoardWriteServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteServelet() {
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
		HttpSession session = request.getSession();
		
		String boardTitle = request.getParameter("btitle");
		String boardWriter = request.getParameter("bwriter");
		String boardContent = request.getParameter("bcontent");
	
		Board b = new Board();
		b.setBoardTitle(boardTitle);
		b.setBoardWriter(boardWriter);
		b.setBoardContent(boardContent);
		
		
		int result = new BoardService().insertBoard(b);
		
		if(result>0) {
			response.sendRedirect(request.getContextPath()+"/blist?currentPage=1");
			
		}else {
			session.setAttribute("message", "게시글 등록 실패!");
			request.getRequestDispatcher(" WebContent/views/common/error.jsp").forward(request, response);
		}
		
		
		
	
	}

}
