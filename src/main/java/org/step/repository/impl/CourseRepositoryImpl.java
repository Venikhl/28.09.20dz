package org.step.repository.impl;

import org.springframework.stereotype.Repository;
import org.step.entity.Course;
import org.step.entity.Profile;
import org.step.repository.CrudRepository;
import org.step.repository.SessionFactoryCreator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CrudRepository<Course>  {

        @PersistenceContext
        private EntityManager entityManager;

        @Override
        public Course save(Course course) {
            entityManager.persist(course);
            return course;
        }

        @Override
        public List<Course> findAll() {
            return entityManager.createQuery("select c from Course c", Course.class)
                    .getResultList();
        }

        @Override
        public void delete(Long id) {
            entityManager.createQuery("delete from Course c where c.id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
        }

        @Override
        public void deleteAll() {
            entityManager.createNativeQuery("DELETE FROM COURSES")
                    .executeUpdate();
        }
}
