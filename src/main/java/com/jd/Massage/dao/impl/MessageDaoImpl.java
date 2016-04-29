package com.jd.Massage.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javassist.expr.NewArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.jd.Massage.dao.MessageDao;
import com.jd.Massage.model.Message;
@Repository
public class MessageDaoImpl implements MessageDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Message findById(int id) {
		String sql="select * from t_message where id=?";
		Object[] params=new Object[]{id};
		final Message message=new Message();
		jdbcTemplate.query(sql, params,new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				message.setContent(rs.getString("content"));
				message.setTitle(rs.getString("title"));
				message.setCreateTime(rs.getDate("createTime"));
				message.setId(rs.getInt("id"));
			}
		});
		return message;
	}
	@Override
	public List<Message> findAll() {
		String sql="select * from t_message order by id desc";
		final List<Message> messages=new ArrayList<Message>(); 
		jdbcTemplate.query(sql, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				Message message=new Message();
				message.setContent(rs.getString("content"));
				message.setTitle(rs.getString("title"));
				message.setCreateTime(rs.getDate("createTime"));
				message.setId(rs.getInt("id"));
				messages.add(message);
			}
		});
		return messages;
	}
	@Override
	public void update(Message message) {
		String sql="update t_message set title=?,content=? where id=?";
		Object[] params= new Object[]{ message.getTitle(),message.getContent(),message.getId()};
		jdbcTemplate.update(sql, params);
		
	}
	@Override
	public void add(Message message) {
		String sql="insert into t_message (title,content,createTime)values(?,?,?)";
		Object[] params=new Object[]{message.getTitle(),message.getContent(),new Date()};
		jdbcTemplate.update(sql, params);
		
	}
	@Override
	public void delete(int id) {
		String sql="delete from t_message where id=?";
		Object[] params=new Object[]{id};
		jdbcTemplate.update(sql, params);
		
	}

}
