package org.step.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.step.configuration.DatabaseConfiguration;
import org.step.entity.Course;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfiguration.class})
@ActiveProfiles("dev")
public class CourseServiceImplTest {

    @Autowired
    private CourseService courseCrudService;

    private Course course;

    @Before
    public void setup() {
        course = Course
                .builder()
                .topic("topic")
                .courseDescription("courseDescription")
                .build();

        courseCrudService.save(course);
    }

    @After
    public void clean() {
        courseCrudService.deleteAll();
    }

    @Test
    public void shouldSaveNewCourse() {
        final Course course = Course.builder()
                .build();

        Course save = courseCrudService.save(course);

        Assert.assertEquals(course.getId(), save.getId());
    }

    @Test
    public void shouldDeleteCourse() {
        courseCrudService.delete(course.getId());
    }

    @Test
    public void findAllCourses() {
        List<Course> all = courseCrudService.findAll();

        Assert.assertFalse(all.isEmpty());
    }
}
