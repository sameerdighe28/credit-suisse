package com.cs.assignment.row.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cs.assignment.model.Log;
import org.springframework.jdbc.core.RowMapper;

public class LogRowMapper implements RowMapper<Log> {

	@Override
	public Log mapRow(ResultSet rs, int rowNum) throws SQLException {
		Log log = new Log();

		log.setId(rs.getString("ID"));
		log.setType(rs.getString("TYPE"));
		log.setHost(rs.getString("HOST"));
		log.setDuration(rs.getLong("DURATION"));
		log.setAlert(rs.getBoolean("ALERT"));

		return log;
	}

}
