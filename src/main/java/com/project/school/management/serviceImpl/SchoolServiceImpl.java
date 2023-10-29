package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.constant.Message;
import com.project.school.management.entity.School;
import com.project.school.management.exception.AlreadyExistException;
import com.project.school.management.exception.NotExist;
import com.project.school.management.repository.SchoolRepository;
import com.project.school.management.service.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;

	@Override
	public School save(School school) {
		if (ObjectUtils.isNotEmpty(school.getId())) {
			return this.schoolRepository.save(school);
		}
		if (ObjectUtils.isNotEmpty(this.schoolRepository.findByNameIgnoreCase(school.getName()))) {
			throw new AlreadyExistException(Message.SCHOOL_ALREADY_EXIST);
		}
		return this.schoolRepository.save(school);
	}

	@Override
	public List<School> getList() {
		return this.schoolRepository.findAll();
	}

	@Override
	public School getAddress(Long id) {
		Optional<School> data = this.schoolRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		}
		throw new NotExist(Message.SCHOOL_NOT_EXIST);
	}

}
