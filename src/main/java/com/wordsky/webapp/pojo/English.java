package com.wordsky.webapp.pojo;


public class English{
	

private int id;
private String content;
private String description;


public English(){
	this.content="click to edit";
	this.description="none";
}

@Override
public String toString() {
	return "English [id=" + id + ", content=" + content + ", description="
			+ description + "]";
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
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