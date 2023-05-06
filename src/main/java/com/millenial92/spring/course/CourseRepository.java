package com.millenial92.spring.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository <Course, String> {

    public List<Course> findByTopicId(String topicId);

}
