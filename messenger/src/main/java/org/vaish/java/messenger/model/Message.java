package org.vaish.java.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	private Long id;
	private String content;
	private String author;
	
	public Message(){
		
	}
	
	public Message(Long id, String content, String author) {
		//super();
		this.id = id;
		this.content = content;
		this.author = author;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	

}
