package com.example.kafkaconsumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaconsumer.model.User;


@SpringBootApplication
@RestController
public class KafkaConsumerApplication {
	
	List<String> messages=new ArrayList<String>();
	
	User userFromTopic=null;
	
	@GetMapping("/consumeStringMessage")
	public List<String> consumeMsg(){
		return messages;
	}
	
	@KafkaListener(groupId = "string-group", topics = "demodemo", containerFactory = "concurrentKafkaListenerContainerFactory")
	public List<String> getMsgFromTopic(String data) {
		messages.add(data);
		return messages;
		
	}
	
	@GetMapping("/consumeJson")
	public User consumeJson(){
		return userFromTopic;
	}

	@KafkaListener(groupId = "user-group", topics = "demo2 ", containerFactory = "userConcurrentKafkaListenerContainerFactory")
	public User getUserFromTopic(User user) {
		userFromTopic = user;
		return userFromTopic;
		
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

}
