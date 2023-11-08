package com.project.school.management.entity;

import java.time.LocalDateTime;
import java.util.Map;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "timetable")
public class TimeTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "class_id", insertable = false, updatable = false)
	@ManyToOne(targetEntity = ClassEntity.class, fetch = FetchType.EAGER)
	private ClassEntity className;

	@Column(name = "class_id")
	private Long classId;

	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	@ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.EAGER)
	private UserEntity user;

	@Column(name = "user_id")
	private Long userId;
	
	@JoinColumn(name = "subject_id", insertable = false, updatable = false)
	@ManyToOne(targetEntity = Subject.class, fetch = FetchType.EAGER)
	private Subject subject;

	@Column(name = "subject_id")
	private Long subjectId;

	@Column(name = "start_time")
	private LocalDateTime startTime;
	
	@Column(name = "end_time")
	private LocalDateTime endTime;

	@CreationTimestamp
	private LocalDateTime created;

	@UpdateTimestamp
	private LocalDateTime updated;

}
