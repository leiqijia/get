package com.jd.Massage.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jd.Massage.model.Message;
import com.jd.Massage.service.MessageService;


@RestController
@RequestMapping(value="/message")
public class MessageController {
	@Autowired
	private MessageService messageService;
	@RequestMapping(value="/index")
	public ModelAndView show(){
		ModelAndView modelAndView=new ModelAndView("/massage");
		return modelAndView;
	}
	@RequestMapping(value="/cxyt{id}",method=RequestMethod.POST)
	public Message getMessage(@PathVariable int id){
		
		return messageService.findById(id);
		 
	}
	@RequestMapping(value="/all")
	public List<Message> getMessage1(){
		return  messageService.findAll();
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Message message){
		messageService.updateMessage(message);
		String aString="{\"code\":1}";
		return aString;
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void addMessage(Message message){
		messageService.add(message);
	}
	@RequestMapping(value="/delete{id}")
	public Message delete(@PathVariable int id){
		Message message=new Message();
		messageService.delete(id);
		return message;
		
	}
	@RequestMapping(value="/img/rain")
	public void getImage(HttpServletResponse response){
		response.setContentType("img/jif");
		File file=new File("E:"+File.separator+"rain.jpg");
		FileInputStream fis=null;
		OutputStream output=null;
		try {
			fis =new FileInputStream(file);
			output=response.getOutputStream();
			byte[] buffer=new byte[fis.available()];
			fis.read(buffer);
			output.write(buffer);
			output.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
