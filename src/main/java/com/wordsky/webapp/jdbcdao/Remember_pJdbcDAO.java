package com.wordsky.webapp.jdbcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.wordsky.webapp.dao.ChineseDAO;
import com.wordsky.webapp.dao.EnglishDAO;
import com.wordsky.webapp.dao.Remember_pDAO;
import com.wordsky.webapp.jdbcdao.mapper.ChineseMapper;
import com.wordsky.webapp.jdbcdao.mapper.EnglishMapper;
import com.wordsky.webapp.jdbcdao.mapper.Remember_pMapper;
import com.wordsky.webapp.pojo.Chinese;
import com.wordsky.webapp.pojo.English;
import com.wordsky.webapp.pojo.Remember_p;

@Named
public class Remember_pJdbcDAO implements Remember_pDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Remember_p> getRemember() {
		List<Remember_p> rp = null;
		final String SQL_QUERY = "SELECT * FROM remember_p";
		try {
			rp = this.jdbcTemplate.query(SQL_QUERY, new Object[] {},
					new Remember_pMapper());
		} catch (Exception sqlEx) {

		}
		return rp;
	}



}