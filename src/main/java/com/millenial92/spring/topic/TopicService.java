package com.millenial92.spring.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
       private static List<Topic> topics = new ArrayList<>(Arrays.asList(
                new Topic( "Spring" , "Spring Framework" , "Spring Framework Description"),
                new Topic( "Java" , "Java Framework" , "Java Framework Description"),
                new Topic( "Javascript" , "Javascript Framework" , "Javascript Framework Description")
        ));

    public List<Topic> getAllTopics() {

        List<Topic> topics = new ArrayList<>();
          topicRepository.findAll().forEach(topics :: add );
          return topics;
       }
       public Optional<Topic> getTopic(String id) {
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {

        topicRepository.deleteById(id);
    }

}
