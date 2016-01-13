package com.wordsky.webapp.pojo;

public class Chinese{
	

private int id;
private String content;
private String origin;
private String type;

public Chinese(){
	
}
@Override
public String toString() {
	return "Chinese [content=" + content + ", origin=" + origin
			+ ", type=" + type + "]";
}
public Chinese(String content,String origin,String type){
	this.content=content;
	this.origin=origin;
	this.type=type;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getOrigin() {
	return origin;
}
public void setOrigin(String origin) {
	this.origin = origin;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}


}