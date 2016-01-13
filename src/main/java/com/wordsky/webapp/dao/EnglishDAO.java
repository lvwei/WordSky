package com.wordsky.webapp.dao;

import java.util.List;

import com.wordsky.webapp.pojo.English;



public interface EnglishDAO {


	public List<English> getEnglish(String table);
	public List<English> getSampleForWord(String content);
	public List<English> getWordForSample(String content);
	public boolean addEnglish(String table, English en);
	public boolean updateEnglish(String table, English en);
	public boolean deleteEnglish(String table, int englishId);
	
}