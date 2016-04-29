package com.jd.Massage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.Massage.dao.MessageDao;
import com.jd.Massage.model.Message;
@Service
public class MessageService {
	@Autowired
	private MessageDao messageDao;
	public Message findById(int id){
		
		return messageDao.findById(id);
	}
	public List<Message> findAll(){
		return messageDao.findAll();
	}
	public void updateMessage(Message message){
		messageDao.update(message);
	}
	public void add(Message message){
		messageDao.add(message);
	}
	public void delete(int id){
		messageDao.delete(id);
	}

}
