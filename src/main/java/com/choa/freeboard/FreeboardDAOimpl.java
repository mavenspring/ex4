package com.choa.freeboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDTO;
import com.choa.util.DBConnector;
import com.choa.util.RowMaker;

@Repository
public class FreeboardDAOimpl implements BoardDAO {
	
	@Inject
	private DataSource dataSource;

	@Override
	public List<BoardDTO> boardList(RowMaker rowMaker) throws Exception {
		Connection con =dataSource.getConnection();
		PreparedStatement st=null;
		ResultSet rs = null;
		String sql="select * from "
				+ "(select rownum R, N.* from "
				+ "(select * from freeboard order by ref desc, step asc) N) "
				+ "where R between ? and ?";
		
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		
		st = con.prepareStatement(sql);
		st.setInt(1, rowMaker.getStartRow());
		st.setInt(2, rowMaker.getLastRow());
		rs = st.executeQuery();
		
		while(rs.next()){
			FreeboadDTO freeboadDTO = new FreeboadDTO();
			freeboadDTO.setNum(rs.getInt("num"));
			freeboadDTO.setWriter(rs.getString("writer"));
			freeboadDTO.setTitle(rs.getString("title"));
			freeboadDTO.setContents(rs.getString("contents"));
			freeboadDTO.setReg_date(rs.getDate("reg_date"));
			freeboadDTO.setHit(rs.getInt("hit"));	
			freeboadDTO.setRef(rs.getInt("ref"));
			freeboadDTO.setStep(rs.getInt("step"));
			freeboadDTO.setDepth(rs.getInt("depth"));
			ar.add(freeboadDTO);	
		}
		// close
		DBConnector.disConnect(rs, st, con);
		System.out.println(ar.size());
		return ar;
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		Connection con =dataSource.getConnection();
		PreparedStatement st=null;
		ResultSet rs = null;
		String sql="select * from freeboard where num=?";
		FreeboadDTO freeboadDTO =null;
		
		st = con.prepareStatement(sql);
		st.setInt(1, num);
		rs = st.executeQuery();
		if(rs.next()){
			freeboadDTO = new FreeboadDTO();
			freeboadDTO.setNum(rs.getInt("num"));
			freeboadDTO.setWriter(rs.getString("writer"));
			freeboadDTO.setTitle(rs.getString("title"));
			freeboadDTO.setContents(rs.getString("contents"));
			freeboadDTO.setReg_date(rs.getDate("reg_date"));
			freeboadDTO.setHit(rs.getInt("hit"));	
			freeboadDTO.setRef(rs.getInt("ref"));
			freeboadDTO.setStep(rs.getInt("step"));
			freeboadDTO.setDepth(rs.getInt("depth"));
		}
		
		//close
		DBConnector.disConnect(rs, st, con);
	
		return freeboadDTO;
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		Connection con =dataSource.getConnection();
		PreparedStatement st=null;
		int result=0;
		
		String sql="insert into freeboard values(notice_seq.nextval, ?,?,?, sysdate, 0)";
		
		st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getWriter());
		st.setString(2, boardDTO.getTitle());
		st.setString(3, boardDTO.getContents());
		result =st.executeUpdate();
		
		//close
		DBConnector.disConnect(st, con);
		
		
		return result;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement st =null;
		String sql =" update freeboard set writer=?, title=? , contents=? where num=?";
		int result =0;
		
		st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getWriter());
		st.setString(2, boardDTO.getTitle());
		st.setString(3, boardDTO.getContents());
		st.setInt(4, boardDTO.getNum());
		result =st.executeUpdate();

		//close
		DBConnector.disConnect(st, con);	
		
		return result;
	}

	@Override
	public int boardDelete(int num) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement st =null;
		String sql =" delete freeboard where num=?";
		int result=0;
		
		st = con.prepareStatement(sql);
		st.setInt(1, num);
		result = st.executeUpdate();
		
		//close
		DBConnector.disConnect(st, con);
		
		return result;
	}

	@Override
	public int boardCount() throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		int result=0;
		String sql ="select nvl(count(num),0) from freeboard ";
		
			st= con.prepareStatement(sql);
			rs = st.executeQuery();
			rs.next();
			result = rs.getInt(1);
			
			//close
			DBConnector.disConnect(rs, st, con);
	
		return result;
	}

	@Override
	public void boardHit(int num) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
