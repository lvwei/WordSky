package com.wordsky.webapp.pojo;


public class Remember_p{
	

private int id;
private String content;
private String target;
private String type;


@Override
public String toString() {
	return "Remember_p [id=" + id + ", content=" + content + ", target="
			+ target + ", type=" + type + "]";
}
public String getTarget() {
	return target;
}
public void setTarget(String target) {
	this.target = target;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
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


}