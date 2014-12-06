package com.wordsky.webapp.pojo;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

public class English{
	

private int id;
private String content;
private String origin;
private String type;

public English(){
	
}
@Override
public String toString() {
	return "English [id=" + id + ", content=" + content + ", origin=" + origin
			+ ", type=" + type + "]";
}
public English(String content,String origin,String type){
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