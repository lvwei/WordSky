package com.wordsky.webapp.helperclass;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Named;

import com.wordsky.webapp.dao.ChineseDAO;
import com.wordsky.webapp.pojo.Chinese;

@Named
public class ChineseHelper {

public static List<String> getType(String table){
	if(table.equals("item")){
	String[] s={"一字名词","一字动词","一字形容词/副词","二字名词","二字动词","两字形容词/副词","三字词语","四字词语"};
	List<String> types=Arrays.asList(s);    
	return types;
	}
	else if(table.equals("sentence")){
		String[] s={"短语","长句"};
		List<String> types=Arrays.asList(s);    
		return types;	
	}
	else 
    return null;
}


}