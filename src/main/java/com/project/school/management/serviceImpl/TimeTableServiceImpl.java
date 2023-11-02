package com.project.school.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.management.constant.Message;
import com.project.school.management.entity.TimeTable;
import com.project.school.management.exception.NotExist;
import com.project.school.management.repository.TimeTableRepository;
import com.project.school.management.service.TimeTableService;

@Service
public class TimeTableServiceImpl implements TimeTableService {

	@Autowired
	private TimeTableRepository timeTableRepository;

	@Override
	public TimeTable save(TimeTable timeTable) {
//		if (ObjectUtils.isNotEmpty(this.timeTableRepository.findByNameIgnoreCase(role.getName()))) {
//			throw new AlreadyExistException(Message.ROLE_ALREADY_EXIST);
//		}
		return this.timeTableRepository.save(timeTable);
	}

	@Override
	public List<TimeTable> getList() {
		return this.timeTableRepository.findAll();
	}

	@Override
	public TimeTable getById(Long id) {
		Optional<TimeTable> data = this.timeTableRepository.findById(id);
		if (data.isPresent()) {
			return data.get();
		}
		throw new NotExist(Message.ROLE_NOT_EXIST);
	}

	@Override
	public List<TimeTable> getByClass(Long id) {
		return this.timeTableRepository.findByClassId(id);
	}

	@Override
	public List<TimeTable> getByUserId(Long id) {
		return this.timeTableRepository.findByClassId(id);
	}

}
