package com.wordsky.webapp.jdbcdao;


import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.jdbc.core.JdbcTemplate;
import com.wordsky.webapp.dao.ChineseDAO;
import com.wordsky.webapp.jdbcdao.mapper.ChineseMapper;
import com.wordsky.webapp.pojo.Chinese;

@Named
public class ChineseJdbcDAO implements ChineseDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Chinese> getChinese(String table, String type) {
		List<Chinese> ch = null;
		type='%'+type+'%';
		final String SQL_QUERY = "SELECT * FROM " + table
				+ " where type LIKE ?";
		try {
			ch = this.jdbcTemplate.query(SQL_QUERY, new Object[] { type },
					new ChineseMapper());
		} catch (Exception sqlEx) {

		}
		return ch;
	}

	@Override
	public List<Chinese> getChinese(String table) {
		List<Chinese> ch = null;
		final String SQL_QUERY = "SELECT * FROM " + table + " order by type";
		try {
			ch = this.jdbcTemplate.query(SQL_QUERY, new Object[] {},
					new ChineseMapper());
		} catch (Exception sqlEx) {

		}
		return ch;
	}

	@Override
	public boolean addChinese(String table, Chinese ch_) {
		final String INSERT_SQL = "insert into " + table
				+ " (content,origin,type) values(?,?,?)";
		final Chinese ch = ch_;

		try {
			this.jdbcTemplate.update(INSERT_SQL, new Object[] {ch.getContent(),ch.getOrigin(), ch.getType()});
		} catch (Exception sqlEx) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateChinese(String table, Chinese ch) {
		final String SQL_QUERY = "update " + table
				+ " set content = ? , origin = ?, type = ? where id = ?";
		try {
			this.jdbcTemplate.update(SQL_QUERY, ch.getContent(),
					ch.getOrigin(), ch.getType(), ch.getId());
		} catch (Exception sqlEx) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteChinese(String table, int chineseId) {
		final String DELETE_SQL = "delete from " + table + " where id = ? ";
		try {
			this.jdbcTemplate.update(DELETE_SQL, chineseId);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<String> getOrigin(String table) {
		List<String> s = null;
		final String SQL_QUERY = "SELECT distinct origin FROM " + table
				+ " order by origin";
		try {
			s = this.jdbcTemplate.queryForList(SQL_QUERY, new Object[] {},
					String.class);
		} catch (Exception sqlEx) {

		}
		return s;
	}

	@Override
	public List<Chinese> selectItemForSentence(String content) {
		List<Chinese> ch = null;
		final String SQL_QUERY = "select * from item where ? LIKE CONCAT('%', content, '%')";
		System.out.println(SQL_QUERY);
		try {
			ch = this.jdbcTemplate.query(SQL_QUERY, new Object[] { content },
					new ChineseMapper());
		} catch (Exception sqlEx) {

		}
		return ch;
	}

	@Override
	public List<Chinese> selectSentenceForItem(String content) {
		List<Chinese> ch = null;
		content = '%' + content + '%';
		final String SQL_QUERY = "select * from sentence where sentence.content LIKE ?";
		try {
			ch = this.jdbcTemplate.query(SQL_QUERY, new Object[] { content },
					new ChineseMapper());
		} catch (Exception sqlEx) {

		}
		return ch;
	}

	@Override
	public Chinese getChineseByContent(String table, String content) {
		Chinese ch = null;
		final String SQL_QUERY = "SELECT * FROM " + table
				+ " where content = ?";
		try {
			ch = this.jdbcTemplate.queryForObject(SQL_QUERY,
					new Object[] { content }, new ChineseMapper());
		} catch (Exception sqlEx) {

		}
		return ch;
	}

}