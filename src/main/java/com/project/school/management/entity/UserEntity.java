package com.project.school.management.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.school.management.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_entity")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "firstName", nullable = true)
	private String firstName;

	@Column(name = "lastName", nullable = true)
	private String lastName;

	@Column(name = "fatherName", nullable = true)
	private String fatherName;

	@Column(name = "motherName", nullable = true)
	private String motherName;

	@Column(name = "gender", nullable = true)
	private Gender gender;

	@Column(name = "dateOfBirth", nullable = true)
	private Date dateOfBirth;

	@Column(name = "houseNumber", nullable = true)
	private String houseNumber;

	@Column(name = "street", nullable = true)
	private String street;

	@Column(name = "city", nullable = true)
	private String city;

	@Column(name = "state", nullable = true)
	private String state;

	@Column(name = "pinCode", nullable = true)
	private String pinCode;

	@Column(name = "country", nullable = true)
	private String country;

	@JoinColumn(name = "class_id", insertable = false, updatable = false)
	@ManyToOne(targetEntity = ClassEntity.class, fetch = FetchType.EAGER)
	private ClassEntity className;

	@Column(name = "class_id")
	@JsonIgnore
	private Long classId;

	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	@ManyToOne(targetEntity = Role.class, fetch = FetchType.EAGER)
	private Role role;

	@Column(name = "role_id")
	@JsonIgnore
	private Long roleId;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "phone", nullable = false)
	private String phone;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "userName", nullable = false)
	private String userName;

	@Column(name = "userId", nullable = false)
	private String userId;

	@Column(name = "is_parent", nullable = true)
	private List<String> isParent;

	@JoinColumn(name = "school_id", insertable = false, updatable = false)
	@ManyToOne(targetEntity = School.class, fetch = FetchType.EAGER)
	private School school;

	@Column(name = "school_id")
	@JsonIgnore
	private Long schoolId;

	@Column(name = "isActive", nullable = true)
	private Boolean isActive;

}
