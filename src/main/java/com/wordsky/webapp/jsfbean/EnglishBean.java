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
import com.wordsky.webapp.dao.EnglishDAO;
import com.wordsky.webapp.helperclass.ChineseHelper;
import com.wordsky.webapp.pojo.Chinese;
import com.wordsky.webapp.pojo.English;

@Named("EnglishBean")
@Scope("session")
public class EnglishBean {
	@Inject
	EnglishDAO englishDAO;
	
	private List<English> filteredItemList;
	private List<English> itemList;
	private List<English> searchedList;
	private String title;
	private String currentType;
	private English newEnglish;
	private English selectedEnglish;
	private boolean keepFiltered = false;
	private boolean isActionBack=false;

	

	
	public List<English> getFilteredItemList() {
		return filteredItemList;
	}
	public void setFilteredItemList(List<English> filteredItemList) {
		this.filteredItemList = filteredItemList;
	}
	public List<English> getItemList() {
		return itemList;
	}
	public void setItemList(List<English> itemList) {
		this.itemList = itemList;
	}
	public List<English> getSearchedList() {
		return searchedList;
	}
	public void setSearchedList(List<English> searchedList) {
		this.searchedList = searchedList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCurrentType() {
		return currentType;
	}
	public void setCurrentType(String currentType) {
		this.currentType = currentType;
	}
	public English getNewEnglish() {
		return newEnglish;
	}
	public void setNewEnglish(English newEnglish) {
		this.newEnglish = newEnglish;
	}
	public English getSelectedEnglish() {
		return selectedEnglish;
	}
	public void setSelectedEnglish(English selectedEnglish) {
		this.selectedEnglish = selectedEnglish;
	}
	public String getEnglish(String table){
		this.currentType =table;		
		this.itemList = englishDAO.getEnglish(this.currentType);
		checkForFilter();
		this.keepFiltered=false;
		return "DetailEnglish.xhtml";
	}
	

	public void checkForFilter() {
		if (!this.keepFiltered) {
			this.filteredItemList = this.itemList;
		}

	}	
	public String addEnglish(){
		this.newEnglish =new English();
		this.title = "Add new ";
		if (this.currentType.equals("word")) {
			this.title += "word";
		} else
			this.title += "sample";
		return "AddEnglish.xhtml";
	}
	
	public String addEnglishComplete() {
		if (englishDAO.addEnglish(this.currentType, this.newEnglish)) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							this.newEnglish.toString(), " has been created."));
		} else {
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									this.newEnglish.toString(),
									" already created."));
		}
		return getEnglish(this.currentType);
	}
    
	
	public String actionComplete(){
		this.keepFiltered=true;
		return getEnglish(this.currentType);
	}
	public String englishActionCancel() {
		return actionComplete();
	}
	
	public String editEnglish() {
		this.title = "Edit";
		if (this.currentType.equals("word")) {
			this.title += "word";
		} else
			this.title += "sample";
		return "EditEnglish.xhtml";
	}

	public String editEnglishComplete() {
		englishDAO.updateEnglish(this.currentType, this.selectedEnglish);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						this.selectedEnglish.toString(), " has been edited."));
		return getEnglish(this.currentType);
	}
	
	public String deleteEnglish() {
		englishDAO.deleteEnglish(this.currentType, this.selectedEnglish.getId());
		this.title = "Delete ";
		if (this.currentType.equals("word")) {
			this.title += "word";
		} else
			this.title += "sample";
		return "DeleteEnglish.xhtml";
	}

	public String deleteEnglishComplete() {
		englishDAO.deleteEnglish(this.currentType, this.selectedEnglish.getId());
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						this.selectedEnglish.toString(), " has been deleted."));
		return getEnglish(this.currentType);		
	}
	
	
	public String englishSearch() {
		if (this.currentType.equals("word")) {
			this.searchedList = englishDAO
					.getSampleForWord(this.selectedEnglish.getContent());
		} else if (this.currentType.equals("sample")) {
			this.searchedList = englishDAO
					.getWordForSample(this.selectedEnglish.getContent());
		}
		this.title = "Search results for: "+this.selectedEnglish.getContent();
		return "EnglishSearch.xhtml";
	}
	
	public void selectEnglishListener(ActionEvent event) {
		this.selectedEnglish = (English) event.getComponent().getAttributes()
				.get("item");
	}

}