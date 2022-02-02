package com.cs.assignment.service;

import java.util.*;

import com.cs.assignment.dto.LogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.assignment.dao.LogDao;
import com.cs.assignment.model.Log;

@Service
public class LogService {

	public static final String STARTED = "STARTED";
	public static final String FINISHED = "FINISHED";
	@Autowired
	private LogDao logDao;

	public List<Log> findAllLogs() {
		return logDao.findAllLogs();
	}

	public void process(List<LogDto> logs) {
		Map<String, List<LogDto>> logsMap = createLogMap(logs);

		logsMap.forEach((id, log) -> {
			LogDto logStarted = log.stream().filter(l -> l.getState().equals(STARTED)).findFirst().orElse(null);
			LogDto logFinished = log.stream().filter(l -> l.getState().equals(FINISHED)).findFirst().orElse(null);
			if(logStarted != null && logFinished != null) {
				logDao.saveLog(build(logStarted, logFinished));
			}
		});

	}

	private boolean checkDifferenceAndSave(LogDto logStarted, LogDto logFinished) {
		if((logStarted.getTimestamp().getTime() > logFinished.getTimestamp().getTime()) && timeDiff(logStarted, logFinished) > 4L)
			return true;
		else
			return (logFinished.getTimestamp().getTime() > logStarted.getTimestamp().getTime()) && timeDiff(logFinished, logStarted) > 4L;
	}

	private Long timeDiff(LogDto log1, LogDto log2) {
		return (log1.getTimestamp().getTime() - log2.getTimestamp().getTime());
	}

	public Log build(LogDto logStarted, LogDto logFinished) {
		Log log = new Log();
		log.setAlert(checkDifferenceAndSave(logFinished, logStarted));
		log.setId(logStarted.getId());
		log.setHost(logStarted.getHost());
		log.setType(logStarted.getType());
		log.setDuration(timeDiff(logStarted, logFinished));
		return log;
	}

	private Map<String, List<LogDto>> createLogMap(List<LogDto> logs) {
		Map<String, List<LogDto>> logsMap = new HashMap<>();

		logs.forEach(logDto -> {
			if(logsMap.containsKey(logDto.getId())) {
				logsMap.get(logDto.getId()).add(logDto);
			} else {
				List<LogDto> logDtos = new ArrayList<>();
				logDtos.add(logDto);
				logsMap.put(logDto.getId(), logDtos);
			}
		});

		return logsMap;
	}
}
