package com.gz.test.model.vo;

import java.sql.Date;

public class Board {
	
	
	
		private int boardNum	;					//	BOARD_NUM NUMBER,
		private String boardWriter;				//
		private String boardTitle;						//	BOARD_WRITER VARCHAR2(20) NOT NULL,
		private String boardContent;						//
		private Date boardDate;						//	BOARD_TITLE VARCHAR2(50) NOT NULL,
													//
													//	BOARD_CONTENT VARCHAR2(2000) NOT NULL,
													//
													//	BOARD_DATE DATE DEFAULT SYSDATE,
													//
													//	CONSTRAINT PK_BOARD PRIMARY KEY (BOARD_NUM),
		public Board() {
			super();
		}
		
		public Board(int boardNum, String boardWriter, String boardTitle, String boardContent, Date boardDate) {
			super();
			this.boardNum = boardNum;
			this.boardWriter = boardWriter;
			this.boardTitle = boardTitle;
			this.boardContent = boardContent;
			this.boardDate = boardDate;
		}

		public int getBoardNum() {
			return boardNum;
		}

		public void setBoardNum(int boardNum) {
			this.boardNum = boardNum;
		}

		public String getBoardWriter() {
			return boardWriter;
		}

		public void setBoardWriter(String boardWriter) {
			this.boardWriter = boardWriter;
		}

		public String getBoardTitle() {
			return boardTitle;
		}

		public void setBoardTitle(String boardTitle) {
			this.boardTitle = boardTitle;
		}

		public String getBoardContent() {
			return boardContent;
		}

		public void setBoardContent(String boardContent) {
			this.boardContent = boardContent;
		}

		public Date getBoardDate() {
			return boardDate;
		}

		public void setBoardDate(Date boardDate) {
			this.boardDate = boardDate;
		}

		@Override
		public String toString() {
			return "Test [boardNum=" + boardNum + ", boardWriter=" + boardWriter + ", boardTitle=" + boardTitle
					+ ", boardContent=" + boardContent + ", boardDate=" + boardDate + "]";
		}
		
		
		
		

}
