package com.wordsky.webapp.jsfbean;


import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

@Named("EnglishBean")
@Scope("request")
public class EnglishBean {
	
	public String getPhrase(){
		return "DetailItem.xhtml";
	}
	public String getSample(){
		return "DetailItem.xhtml";
	}
	public String getWord(){
		return "DetailItem.xhtml";
	}

}