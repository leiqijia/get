package com.jd.Massage.dao;

import java.util.List;

import com.jd.Massage.model.Message;

public interface MessageDao {
	public Message findById(int id);
	public List<Message> findAll();
	public void update(Message message);
	public void add(Message message);
	public void delete(int id);
	
}
