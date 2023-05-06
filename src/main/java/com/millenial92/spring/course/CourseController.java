package com.millenial92.spring.course;

import com.millenial92.spring.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

@Autowired
    private CourseService courseService;
    @GetMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId) {
        return courseService.getAllCourses(topicId);
}

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Optional<Course>> getCourse(@PathVariable String topicId){

        return Optional.ofNullable(courseService.getCourse(topicId));
}

    @PostMapping("/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course , @PathVariable String topicId)
    {
        course.setTopic(new Topic(topicId , "" ,""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course , @PathVariable String topicId , @PathVariable String id)
    {
        course.setTopic(new Topic(topicId , "" ,""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id)
    {
        courseService.deleteCourse(id);
    }

}
