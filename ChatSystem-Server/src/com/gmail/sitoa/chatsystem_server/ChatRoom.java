package com.gmail.sitoa.chatsystem_server;

public class ChatRoom {
	private String roomname;
	private String roommaker;
	
	public String getroomname(){
		String name = roomname;
		
		return name;
	}
	
	public void setname(String name){
		roomname = name;
	}
	
	public String getmaker(){
		String name = roommaker;
		
		return name;
	}
	
	public void setmaker(String name){
		roommaker = name;
	}

}
