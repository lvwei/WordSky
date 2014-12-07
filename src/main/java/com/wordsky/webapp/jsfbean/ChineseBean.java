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
import com.wordsky.webapp.helperclass.ChineseHelper;
import com.wordsky.webapp.pojo.Chinese;

@Named("ChineseBean")
@Scope("session")
public class ChineseBean {

	@Inject
	ChineseDAO chineseDAO;

	private List<Chinese> filteredItemList;
	private List<Chinese> itemList;
	private List<Chinese> searchedList;
	private String title;
	private String currentType;
	private String currentField;
	private boolean isSingleType = true;
	private Chinese newChinese = new Chinese("µ„¥À±‡º≠", "µ„¥À±‡º≠", "µ„¥À±‡º≠");
	private Chinese selectedChinese;
	private List<String> origins;
	private List<String> types;

	public ChineseBean() {
		this.currentType = "µ„¥À±‡º≠";
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
		this.currentType = type;
		this.currentField = table;
		this.isSingleType = true;
		this.itemList = chineseDAO.getChinese(table, type);
		if (table.equals("item")) {
			return "DetailChinese.xhtml";
		} else
			return "DetailChinese.xhtml";
	}

	public String toAllChinese(String table) {
		this.itemList = chineseDAO.getChinese(table);
		this.currentField = table;
		this.title = "À˘”–";
		this.isSingleType = false;
		this.currentType="µ„¥À±‡º≠";
		if (table.equals("item")) {
			this.title += "¥ ”Ô";
		} else
			this.title += "”Ôæ‰";
		return "AllChinese.xhtml";
	}

	public String editChinese() {
		this.origins = chineseDAO.getOrigin(this.currentField);
		this.types = ChineseHelper.getType(this.currentField);
		this.title = "±‡º≠";
		if (this.currentField.equals("item")) {
			this.title += "¥ ”Ô";
		} else
			this.title += "”Ôæ‰";
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
		chineseDAO.deleteChinese("item", this.selectedChinese.getId());
		this.title = "…æ≥˝";
		if (this.currentField.equals("item")) {
			this.title += "¥ ”Ô";
		} else
			this.title += "”Ôæ‰";
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
		this.newChinese = new Chinese("µ„¥À±‡º≠", this.newChinese.getOrigin(),
				this.currentType);
		this.origins = chineseDAO.getOrigin(this.currentField);
		this.types = ChineseHelper.getType(this.currentField);
		this.title = "ÃÌº”–¬";
		if (this.currentField.equals("item")) {
			this.title += "¥ ”Ô";
		} else
			this.title += "”Ôæ‰";
		return "AddChinese.xhtml";
	}

	public String addChineseComplete() {
		if (chineseDAO.addChinese(this.currentField, this.newChinese)) {
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
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_WARN,
									this.newChinese.toString(),
									" already created and just updated with additional type."));
				}
			}
		}
		return actionComplete();

	}

	public String chineseActionCancel() {
		return "DetailChinese.xhtml";
	}

	public String actionComplete() {
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
		this.title = this.selectedChinese.getContent() + " ≤È—ØΩ·π˚:";
		return "ChineseSearch.xhtml";
	}

	public List<String> potentialOrigin(String languagePrefix) {
		List<String> matches = new ArrayList<String>();
		this.origins = chineseDAO.getOrigin("item");
		for (String possibleLanguage : this.origins) {
			if (possibleLanguage.startsWith(languagePrefix)) {
				matches.add(possibleLanguage);
			}
		}

		if (matches.isEmpty()) {
			return this.origins;
		} else {
			return (matches);
		}
	}

	public void selectChineseListener(ActionEvent event) {
		this.selectedChinese = (Chinese) event.getComponent().getAttributes()
				.get("item");
	}

}