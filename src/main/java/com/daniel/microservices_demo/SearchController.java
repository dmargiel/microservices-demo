package com.daniel.microservices_demo;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.daniel.microservices_demo.kafka.KafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class SearchController {

    @Autowired
    private KafkaProducer kafkaProducer;

    private final QueryRepository queryRepository;

    public SearchController(QueryRepository queryRepository) {
        this.queryRepository = queryRepository;
        
    }

    @GetMapping("/queries")
    public List<QueryEntity> all() {
        return queryRepository.findAll();
    }

    @PostMapping("/query")
    public QueryEntity query(@RequestBody QueryEntity entity) {
        return queryRepository.save(entity);
    }

    @GetMapping("/dump")
    public String dump() {
        DumpSaver dumpSaver = new DumpSaver();
        String message = dumpSaver.saveQueries(queryRepository.findAll());
        kafkaProducer.sendMessage(message);
        return message;
    }

    @GetMapping("/kafka")
    public String kafkaSendMessage() {
        kafkaProducer.sendMessage("moja testowa wiadomość");
        return "wiadomość wysłana";
    }

}
