package com.daniel.microservices_demo;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.List;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DumpSaver {

    public String saveQueries(List<QueryEntity> entities) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("dump_" + new Date());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(entities);
            return "Queries saved";
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
            return "Exception during queries save: " + e.getLocalizedMessage();
        }
    }

}
