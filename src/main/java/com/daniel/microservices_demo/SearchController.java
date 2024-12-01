package com.daniel.microservices_demo;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class SearchController {

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
        return dumpSaver.saveQueries(queryRepository.findAll());
    }
    

}
