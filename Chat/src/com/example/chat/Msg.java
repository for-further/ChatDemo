package com.example.chat;

public class Msg {
	
	public static final int TYPE_RECEIVED = 0;//��ʾ����һ�����յ�����Ϣ
	public static final int TYPE_SEND = 1;//��ʾ����һ�����͵���Ϣ
	
	private String content;
	private int type;
	public Msg(String content, int type) {
		this.content = content;
		this.type = type;
	}
	public String getContent(){
		return content;
	}
	public int getType(){
		return type;
	}

}
