package com.wordsky.webapp.jsfbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.wordsky.webapp.dao.ChineseDAO;
import com.wordsky.webapp.dao.Remember_pDAO;
import com.wordsky.webapp.helperclass.ChineseHelper;
import com.wordsky.webapp.pojo.Chinese;
import com.wordsky.webapp.pojo.Remember_p;

@Named("Remember_pBean")
@Scope("request")
public class Remember_pBean {

	private List<Remember_p> filteredItemList;
	private List<Remember_p> itemList;
	private List<Remember_p> selectedList;
	@Inject
	Remember_pDAO remember_pDAO;

	public List<Remember_p> getFilteredItemList() {
		return filteredItemList;
	}

	public void setFilteredItemList(List<Remember_p> filteredItemList) {
		this.filteredItemList = filteredItemList;
	}

	public List<Remember_p> getItemList() {
		return itemList;
	}

	public void setItemList(List<Remember_p> itemList) {
		this.itemList = itemList;
	}

	public List<Remember_p> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(List<Remember_p> selectedList) {
		this.selectedList = selectedList;
	}

	public String getRemember(){
		this.itemList=this.remember_pDAO.getRemember();
		return"DetailRemember_p.xhtml";
	}
}
