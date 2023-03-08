package com.spring.bank.dto;

import java.sql.Timestamp;

public class CounselCommentDTO {
		private int comment_num; //pk 댓글 일련번호
		private int b_num; //foregin key, 게시글 번호
		private String writer; // 작성자
		private String content; // 글내용
		private Timestamp reg_date; // 작성일

		public CounselCommentDTO () {}

		public int getComment_num() {
			return comment_num;
		}

		public void setComment_num(int comment_num) {
			this.comment_num = comment_num;
		}

		public int getB_num() {
			return b_num;
		}

		public void setB_num(int b_num) {
			this.b_num = b_num;
		}

		public String getWriter() {
			return writer;
		}

		public void setWriter(String writer) {
			this.writer = writer;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Timestamp getReg_date() {
			return reg_date;
		}

		public void setReg_date(Timestamp reg_date) {
			this.reg_date = reg_date;
		}

		@Override
		public String toString() {
			return "CounselCommentDTO [comment_num=" + comment_num + ", b_num=" + b_num + ", writer=" + writer
					+ ", content=" + content + ", reg_date=" + reg_date + "]";
		}
}
