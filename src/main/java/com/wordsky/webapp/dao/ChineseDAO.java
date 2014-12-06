package com.wordsky.webapp.dao;

import java.util.List;

import org.primefaces.model.DualListModel;

import com.wordsky.webapp.pojo.Chinese;



public interface ChineseDAO {
	public Chinese getChineseByContent(String table,String content);
	public List<Chinese> getChinese(String talbe);
	public List<Chinese> getChinese(String table,String type);
	public List<String> getOrigin(String table);
	public boolean addChinese(String table,Chinese ch_);
	public boolean updateChinese(String table,Chinese ch);
	public boolean deleteChinese(String table,int chineseId);
	public List<Chinese>selectItemForSentence(String content);
	public List<Chinese>selectSentenceForItem(String content);
	
	
}