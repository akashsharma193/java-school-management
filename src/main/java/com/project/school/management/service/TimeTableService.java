package com.project.school.management.service;

import java.util.List;

import com.project.school.management.entity.TimeTable;

public interface TimeTableService {

	TimeTable save(TimeTable address);

	List<TimeTable> getList();

	TimeTable getById(Long id);

	List<TimeTable> getByClass(Long id);

	List<TimeTable> getByUserId(Long id);
}
