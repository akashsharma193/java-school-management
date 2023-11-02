package com.project.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.management.entity.TimeTable;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {

	List<TimeTable> findByClassId(Long classId);

	List<TimeTable> findByUserId(Long userId);

}
