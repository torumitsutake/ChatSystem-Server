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
		
		for(ChatRoom room:roomList){
			if(room.getroomname().equalsIgnoreCase(name)){
				return room;
				
			}
			
		}
		return null;


	}
	public ChatRoom[] getChatRooms(){
		ChatRoom[] result = new ChatRoom[roomList.size()];
		for(int i = 0 ; i < roomList.size() ; i++) {
			result[i] = roomList.get(i);
		}
		
		return result;
		
	}
	public void removeChatRoom(ChatRoom room){
		roomList.remove(room);
	}
	public void clearChatRoom(){
		roomList.clear();
		
	}
	
	//ChatUser操作
	
	public void adduser(ChatClientUser user){
		
	}
	
	public ChatClientUser getUser(String name){
		ChatClientUser clientuser = null;
		for(ChatClientUser user:userList){
			if(user.getname().equalsIgnoreCase(name)){
				clientuser = user;
			}
		}
		
		
		return clientuser;
	}
	public ArrayList<ChatClientUser> getUsers(){
		return userList;
	}
	public void removeUser(ChatClientUser user){
		userList.remove(user);
	}
	
	public void clearUser(){
		userList.clear();
	}
	
	//スタートメゾット
	public void start(){
	
		
	}
	
	
}
