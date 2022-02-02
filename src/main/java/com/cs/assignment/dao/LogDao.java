package com.cs.assignment.dao;

import java.util.List;

import com.cs.assignment.model.Log;
import com.cs.assignment.row.mapper.LogRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LogDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SQL_NEW_LOG = "INSERT INTO LOG(ID, DURATION, TYPE, HOST, ALERT) VALUES(?,?,?,?,?)";
	private static final String SQL_FIND_ALL_LOG = "SELECT * FROM LOG";

	public List<Log> findAllLogs() {
		List<Log> logs = jdbcTemplate.query(SQL_FIND_ALL_LOG, new LogRowMapper());
		return logs;
	}

	public void saveLog(Log log) {
		jdbcTemplate.update(SQL_NEW_LOG, new Object[] { log.getId(), log.getDuration(),
				log.getType(), log.getHost(), log.isAlert() });
	}



}
