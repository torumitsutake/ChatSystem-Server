package com.gmail.sitoa.chatsystem_server;

import java.util.ArrayList;

public class ChatServer {
private static ChatServer instance;

private ArrayList<ChatRoom> roomList;
private ArrayList<ChatClientUser> userList;
//コンストラクタ
	private ChatServer(){
	    roomList = new ArrayList<ChatRoom>();
	    userList = new ArrayList<ChatClientUser>();
	}
	//getinstance　メゾット
	public static ChatServer getInstance(){

		if (instance == null) {
	        instance = new ChatServer();
	    }

		return instance;

	}

	public static void main(String[] args) {


	}

	public void addChatRoom(ChatRoom newroom,String name,String maker){
		roomList.add(newroom);
		newroom.setname(name);
		newroom.setmaker(maker);
		
	}
	
	public ChatRoom getChatRoom(String name){
		ChatRoom chatroom = null;
		
		for(ChatRoom room:roomList){
			if(room.getroomname().equalsIgnoreCase(name)){
				chatroom = room;
				
			}
			
		}

		return chatroom;

	}
	public ArrayList<ChatRoom> getChatRooms(){
		
		
		return roomList;
		
	}
	public void removeChatRoom(ChatRoom room){
		roomList.remove(room);
	}
	public void clearChatRoom(){
		roomList.clear();
		
	}
	
	//ChatUser操作
	

}
