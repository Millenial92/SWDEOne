package com.millenial92.spring.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

@Autowired
    private TopicService topicService;
//@RequestMapping("/topics")
//@RequestMapping("/topics", method = RequestMethod.GET)
    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
}

    @RequestMapping("/topics/{id}")
    public Optional<Topic> getTopic(@PathVariable String id){
    return topicService.getTopic(id);
}

    @PostMapping("/topics/add")
    public void addTopic(@RequestBody Topic topic) {
       topicService.addTopic(topic);
}

    @RequestMapping(method = RequestMethod.PUT , value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic , @PathVariable String id)
    {
        topicService.updateTopic(id , topic);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id)
    {
        topicService.deleteTopic(id);
    }

}
