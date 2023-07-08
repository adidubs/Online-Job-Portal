package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.entity.*;

public class JobDAO {
	private Connection conn;

	public JobDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addJobs(Job j) {
		boolean f = false;
		try {
			String sql = "insert into jobs(title,description,category,status,location) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Job> getAllJobs(){
		List<Job> list = new ArrayList<Job>();
		Job j = null;
		try {
			String sql = "select * from jobs order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				j = new Job();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7)+"");
				list.add(j);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Job getJobById(int id){
		
		Job j = null;
		try {
			String sql = "select * from jobs where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				j = new Job();
				j.setId(rs.getInt(1));
				j.setTitle(rs.getString(2));
				j.setDescription(rs.getString(3));
				j.setCategory(rs.getString(4));
				j.setStatus(rs.getString(5));
				j.setLocation(rs.getString(6));
				j.setPdate(rs.getTimestamp(7)+"");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return j;
	}
	
	public boolean updateJobs(Job j) {
		boolean f = false;
		try {
			String sql = "update jobs set title = ?,description = ? ,category = ?,status = ?,location = ? where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());
			ps.setInt(6,j.getId());
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f; 
	}
}
