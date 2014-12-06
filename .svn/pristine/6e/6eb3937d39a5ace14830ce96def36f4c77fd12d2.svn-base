package com.eece496.webapp.jdbcdao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.JdbcTemplate;

import com.eece496.webapp.dao.MarkTableRowDAO;
import com.eece496.webapp.jdbcdao.mapper.MarkTableRowMapper;
import com.eece496.webapp.pojo.MarkTableRow;
import com.eece496.webapp.pojo.User;

@Named
public class MarkTableRowJdbcDAO implements MarkTableRowDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	@Inject
	private MarkTableRowMapper markTableRowMapper;

	@Override
	public List<MarkTableRow> getMarkTableRowOfUser(User user) {
		List<MarkTableRow> markTableRow = new ArrayList<MarkTableRow>();
		int _userId = user.getId();
		if (user.getAuthorization() == User.ADMIN) {
			final String SQL_QUERY = "select m.id, m.student_id, m.mark, c.course_name, h.date, sub.start_time, sub.end_time, m.is_individual_mark "
					+ "from marks m, hold_dates h, subsections sub, sections s, courses c "
					+ "where m.hold_date_id = h.id and h.subsection_id = sub.id and sub.section_id = s.id and s.course_id = c.id "
					+ "and c.id in (select c2.id from courses c2, admin_manages_courses amc where c2.id = amc.course_id and amc.user_id = ?)";
			try {
				markTableRow = this.jdbcTemplate.query(SQL_QUERY,
						new Object[] { _userId }, this.markTableRowMapper);
			} catch (Exception sqlEx) {
				sqlEx.printStackTrace();
			}
		}else if(user.getAuthorization() == User.TA){
			final String SQL_QUERY = "select m.id, m.student_id, m.mark, c.course_name, h.date, sub.start_time, sub.end_time, m.is_individual_mark " +
					"from marks m, hold_dates h, subsections sub, sections s, courses c " +
					"where m.hold_date_id = h.id and h.subsection_id = sub.id and sub.section_id = s.id and s.course_id = c.id and h.ta_id = ?";
			try {
				markTableRow = this.jdbcTemplate.query(SQL_QUERY,
						new Object[] { _userId }, this.markTableRowMapper);
			} catch (Exception sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		return markTableRow;
	}

}
