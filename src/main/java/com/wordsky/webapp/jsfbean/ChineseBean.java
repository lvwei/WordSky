package com.wordsky.webapp.jsfbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.wordsky.webapp.dao.ChineseDAO;
import com.wordsky.webapp.helperclass.ChineseHelper;
import com.wordsky.webapp.pojo.Chinese;

@SuppressWarnings("serial")
@Named("ChineseBean")
@Scope("session")
public class ChineseBean implements Serializable {

	@Inject
	ChineseDAO chineseDAO;

	private List<Chinese> filteredItemList;
	private List<Chinese> itemList;
	private List<Chinese> searchedList;
	private String title;
	private String currentType;
	private String currentField;
	private boolean isSingleType = true;
	private boolean keepFiltered = false;
	private boolean isActionBack = false;
	private Chinese newChinese = new Chinese("点此编辑", "点此编辑", "点此编辑");
	private Chinese selectedChinese;
	private List<String> origins;
	private List<String> types;

	public boolean isActionBack() {
		return isActionBack;
	}

	public void setActionBack(boolean isActionBack) {
		this.isActionBack = isActionBack;
	}

	public boolean isKeepFiltered() {
		return keepFiltered;
	}

	public void setKeepFiltered(boolean keepFiltered) {
		this.keepFiltered = keepFiltered;
	}

	public ChineseBean() {
		this.currentType = "点此编辑";
	}

	public boolean isSingleType() {
		return isSingleType;
	}

	public void setSingleType(boolean isSingleTyp) {
		this.isSingleType = isSingleTyp;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Chinese> getSearchedList() {
		return searchedList;
	}

	public void setSearchedList(List<Chinese> searchedList) {
		this.searchedList = searchedList;
	}

	public String getCurrentField() {
		return currentField;
	}

	public void setCurrentField(String currentField) {
		this.currentField = currentField;
	}

	public Chinese getNewChinese() {
		return newChinese;
	}

	public void setNewChinese(Chinese newChinese) {
		this.newChinese = newChinese;
	}

	public Chinese getSelectedChinese() {
		return selectedChinese;
	}

	public void setSelectedChinese(Chinese selectedChinese) {
		this.selectedChinese = selectedChinese;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public List<String> getOrigins() {
		return origins;
	}

	public void setOrigins(List<String> origins) {
		this.origins = origins;
	}

	public List<Chinese> getFilteredItemList() {
		return filteredItemList;
	}

	public void setFilteredItemList(List<Chinese> filteredItemList) {
		this.filteredItemList = filteredItemList;
	}

	public List<Chinese> getItemList() {
		return itemList;
	}

	public void setItemList(List<Chinese> itemList) {
		this.itemList = itemList;
	}

	public String getCurrentType() {
		return currentType;
	}

	public void setCurrentType(String currentType) {
		this.currentType = currentType;
	}

	public String getChinese(String table, String type) {
		checkForActionBack();
		this.itemList = chineseDAO.getChinese(table, type);
		checkForFilter();
		initialSet(type,table,true);
		this.title = this.currentType;
		this.isActionBack=false;
		return "DetailChinese.xhtml";
	}

	public String toAllChinese(String table) {
		checkForActionBack();
		this.itemList = chineseDAO.getChinese(table);
		checkForFilter();
		initialSet("点此编辑",table,false);
		this.title = "所有";
		addTitle (table); 
		this.isActionBack=false;
		return "AllChinese.xhtml";
	}
	
	public void initialSet(String type,String field, boolean isSingleType){
		this.currentType = type;
		this.currentField = field;
		this.isSingleType = isSingleType;
	}
	
	public void checkForActionBack() {
		if (this.isActionBack) {
			this.keepFiltered=true;
		}
		else
			this.keepFiltered=false;
	}

	public void checkForFilter() {
		if (!this.keepFiltered) {
			this.filteredItemList = this.itemList;
		}
	}
	
	public void addTitle(String field){
		if (field.equals("item")) {
			this.title += "词语";
		} else
			this.title += "语句";
	}

	public String editChinese() {
		this.origins = chineseDAO.getOrigin(this.currentField);
		this.types = ChineseHelper.getType(this.currentField);
		this.title = "编辑";
		addTitle (this.currentField); 
		return "EditChinese.xhtml";
	}

	public String editChineseComplete() {
		chineseDAO.updateChinese(this.currentField, this.selectedChinese);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						this.selectedChinese.toString(), " has been edited."));
		return actionComplete();
	}

	public String deleteChinese() {
		this.title = "删除";
		addTitle (this.currentField); 
		return "DeleteChinese.xhtml";
	}

	public String deleteChineseComplete() {
		chineseDAO.deleteChinese(this.currentField,
				this.selectedChinese.getId());
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						this.selectedChinese.toString(), " has been deleted."));
		return actionComplete();

	}

	public String addChinese() {
		this.newChinese = new Chinese("点此编辑", this.newChinese.getOrigin(),
				this.currentType);
		this.origins = chineseDAO.getOrigin(this.currentField);
		this.types = ChineseHelper.getType(this.currentField);
		this.title = "添加新";
		addTitle (this.currentField); 
		return "AddChinese.xhtml";
	}

	public String addChineseComplete() {
		if (this.newChinese.getContent().equals("点此编辑")) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Creation Fail!", " Content must be filled!"));
		} 
		else if (this.newChinese.getType().equals("点此编辑")) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Creation Fail!", " Type must be filled!"));
		}else if (chineseDAO.addChinese(this.currentField, this.newChinese)) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							this.newChinese.toString(), " has been created."));
		} else {
			Chinese target = chineseDAO.getChineseByContent(this.currentField,
					this.newChinese.getContent());
			if (target != null) {
				if (target.getType().contains(this.newChinese.getType())) {
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									this.newChinese.toString(),
									" already created."));
				} else {
					target.setType(target.getType() + '+'
							+ this.newChinese.getType());
					chineseDAO.updateChinese(currentField, target);
					FacesContext
							.getCurrentInstance()
							.addMessage(
									null,
									new FacesMessage(
											FacesMessage.SEVERITY_WARN,
											this.newChinese.toString(),
											" already created and just updated with additional type."));
				}
			}
		}
		return actionComplete();

	}

	public String chineseActionCancel() {
		return actionComplete();
	}

	public String actionComplete() {
		this.keepFiltered = true;
		this.isActionBack=true;
		if (this.isSingleType) {
			return getChinese(this.currentField, this.currentType);
		} else {
			return toAllChinese(this.currentField);
		}

	}

	public String chineseSearch() {
		if (this.currentField.equals("item")) {
			this.searchedList = chineseDAO
					.selectSentenceForItem(this.selectedChinese.getContent());
		} else if (this.currentField.equals("sentence")) {
			this.searchedList = chineseDAO
					.selectItemForSentence(this.selectedChinese.getContent());
		}
		this.title = "<"+this.selectedChinese.getContent()+">" + " 查询结果:";
		return "ChineseSearch.xhtml";
	}

	public List<String> potentialOrigin(String languageEntered) {
		List<String> matches = new ArrayList<String>();
		this.origins = chineseDAO.getOrigin(this.currentField);
		for (String possibleLanguage : this.origins) {
			if (possibleLanguage.startsWith(languageEntered)) {
				matches.add(possibleLanguage);
			}
		}
		
		if(matches.size()==1){
			if(!matches.get(0).equals(languageEntered))
				matches.add(languageEntered);
		}
		if(matches.isEmpty())
			matches.add(languageEntered);
		if (languageEntered.equals("m")) {
			return this.origins;
		} else {
			return matches;
		}
	}

	public void selectChineseListener(ActionEvent event) {
		this.selectedChinese = (Chinese) event.getComponent().getAttributes()
				.get("item");
	}

}