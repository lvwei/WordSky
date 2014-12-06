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
	String[] s={"һ������","һ�ֶ���","һ�����ݴ�/����","��������","���ֶ���","�������ݴ�/����","���ִ���","���ִ���"};
	List<String> types=Arrays.asList(s);    
	return types;
	}
	else if(table.equals("sentence")){
		String[] s={"����","����"};
		List<String> types=Arrays.asList(s);    
		return types;	
	}
	else 
    return null;
}


}