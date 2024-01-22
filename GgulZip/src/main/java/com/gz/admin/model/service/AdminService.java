package com.gz.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.gz.admin.model.dao.AdminDao;
import com.gz.member.model.vo.Member;
import com.gz.common.JDBCTemplate;
import com.gz.common.model.vo.PageInfo;

public class AdminService {

	// 회원 개수 조회
	public int listCount() {
		Connection conn = JDBCTemplate.getConnection();

		int count = new AdminDao().listCount(conn);

		JDBCTemplate.close(conn);

		return count;
	}

	// 회원 목록 조회
	public ArrayList<Member> selectUserList(PageInfo pi) {
		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Member> list = new AdminDao().selectUserList(conn, pi);

		JDBCTemplate.close(conn);

		return list;
	}

	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();

	int result1 = new AdminDao().updateMember(conn, m);
    int result2 = 1;

    if (result1 > 0) {
    	// 상태값이 "N"인 경우에만 추가 작업 수행
            if("Y".equals(m.getStatus())) { // 등급이 "Y"로 변경된 경우
                result2 = new AdminDao().deleteDisable(conn); // 정지회원 테이블에서 제거
                result2 = new AdminDao().updateMember(conn, m); 
            }
            
            else if("N".equals(m.getStatus())) { // 등급이 "N"으로 변경된 경우
                result2 = new AdminDao().insertDisable(conn, m); // 정지회원 테이블에 추가
                result2 = new AdminDao().updateMember(conn, m);
            }
            

        

        if(result1 * result2 > 0) {
            JDBCTemplate.commit(conn);
        } else{
            JDBCTemplate.rollback(conn);
        }
    } 

		    JDBCTemplate.close(conn);
		
		    return result1 * result2;
	}
	

	// 회원 아이디,이름으로 검색 후 조회
	public ArrayList<Member> selectUserList2(String searchText, String searchField) {

		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Member> fist = new AdminDao().selectUserList2(conn, searchText, searchField);

		JDBCTemplate.close(conn);

		return fist;
	}

	// 정지회원 조회
	public ArrayList<Member> selectDisableList() {

		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Member> dlist = new AdminDao().selectDisableList(conn);

		JDBCTemplate.close(conn);

		return dlist;
	}

	public int updateDisable(Member d) {

		Connection conn = JDBCTemplate.getConnection();

		int result = new AdminDao().updateDisable(conn, d);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);

		return result;

	}


}