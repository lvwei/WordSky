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
import com.wordsky.webapp.jdbcdao.mapper.ChineseMapper;
import com.wordsky.webapp.jdbcdao.mapper.EnglishMapper;
import com.wordsky.webapp.pojo.Chinese;
import com.wordsky.webapp.pojo.English;

@Named
public class EnglishJdbcDAO implements EnglishDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;


	@Override
	public List<English> getEnglish(String table) {
		List<English> en = null;
		final String SQL_QUERY = "SELECT * FROM " + table;
		try {
			en = this.jdbcTemplate.query(SQL_QUERY, new Object[] {},
					new EnglishMapper());
		} catch (Exception sqlEx) {

		}
		return en;
	}

	@Override
	public List<English> getSampleForWord(String content) {
		List<English> en = null;
		content = '%' + content + '%';
		final String SQL_QUERY = "select * from sample where sample.content LIKE ?";
		try {
			en = this.jdbcTemplate.query(SQL_QUERY, new Object[] { content },
					new EnglishMapper());
		} catch (Exception sqlEx) {

		}
		return en;
	}

	@Override
	public List<English> getWordForSample(String content) {
		List<English> en = null;
		final String SQL_QUERY = "select * from word where ? LIKE CONCAT('%', content, '%')";
		try {
			en = this.jdbcTemplate.query(SQL_QUERY, new Object[] { content },
					new EnglishMapper());
		} catch (Exception sqlEx) {

		}
		return en;
	}

	@Override
	public boolean addEnglish(String table, English en_) {
		final String INSERT_SQL = "insert into " + table
				+ " (content,description) values(?,?)";
		final English en = en_;
		try {
			this.jdbcTemplate.update(INSERT_SQL, new Object[] {en.getContent(),en.getDescription()});
		} catch (Exception sqlEx) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateEnglish(String table, English en) {
		final String SQL_QUERY = "update " + table
				+ " set content = ? , description = ? where id = ?";
		try {
			this.jdbcTemplate.update(SQL_QUERY, en.getContent(),en.getDescription(), en.getId());
		} catch (Exception sqlEx) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteEnglish(String table, int englishId) {
		final String DELETE_SQL = "delete from " + table + " where id = ? ";
		try {
			this.jdbcTemplate.update(DELETE_SQL, englishId);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}



}