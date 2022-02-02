package com.cs.assignment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import com.cs.assignment.dto.LogDto;
import com.cs.assignment.model.Log;
import com.cs.assignment.service.LogService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

@SpringBootApplication
public class LogProcessor implements CommandLineRunner {

	private final String PATH = "logfile.json";


	@Autowired
	private LogService logService;


	public static void main(String[] args) {
		SpringApplication.run(LogProcessor.class, args);
	}

	@Override
	public void run(String... args) throws IOException {
		logService.process(readLogsFromFile(PATH));

		printLogs();
	}

	private List<LogDto> readLogsFromFile(String path) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		File file = ResourceUtils.getFile("classpath:" + path);
		return mapper.readValue(new String(Files.readAllBytes((file).toPath())), new TypeReference<List<LogDto>>(){});
	}

	private void printLogs() {
		List<Log> logs = logService.findAllLogs();
		logs.forEach(System.out::println);
	}


}
