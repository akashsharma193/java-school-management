package com.project.school.management.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.management.entity.TimeTable;
import com.project.school.management.response.Response;
import com.project.school.management.service.TimeTableService;

@CrossOrigin
@RestController
@RequestMapping("timeTable")
public class TimeTableController {

	@Autowired
	private TimeTableService timeTableService;

	@PostMapping("save")
	public ResponseEntity<Response> save(@RequestBody TimeTable timeTable) {
		Response response = new Response();
		response.succeed();
		response.setData(timeTableService.save(timeTable));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getList")
	public ResponseEntity<Object> getList() throws IOException {
		Response response = new Response();
		response.succeed();
		response.setData(timeTableService.getList());
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("getById/{id}")
	public ResponseEntity<Object> getById(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(timeTableService.getById(id));
		return ResponseEntity.ok().body(response);

	}

	@GetMapping("getByClass/{id}")
	public ResponseEntity<Object> getByClass(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(timeTableService.getByClass(id));
		return ResponseEntity.ok().body(response);

	}

	@GetMapping("getByUserId/{id}")
	public ResponseEntity<Object> getByUserId(@PathVariable Long id) {
		Response response = new Response();
		response.succeed();
		response.setData(timeTableService.getByUserId(id));
		return ResponseEntity.ok().body(response);

	}
}
