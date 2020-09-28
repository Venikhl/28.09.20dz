package org.step.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.step.entity.Course;
import org.step.repository.CrudRepository;
import org.step.service.CourseService;
import org.step.service.CrudService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CrudRepository<Course> courseCrudRepository;

    @Autowired
    public CourseServiceImpl(CrudRepository<Course> courseCrudRepository) {
        this.courseCrudRepository = courseCrudRepository;
    }

    @Override
    @Transactional
    public void deleteAll() {
        courseCrudRepository.deleteAll();
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return courseCrudRepository.save(course);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return courseCrudRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        courseCrudRepository.delete(id);
    }
}
