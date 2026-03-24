package com.loganalyzer.loganalyzer.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.loganalyzer.loganalyzer.Entity.LogEntry;
import com.loganalyzer.loganalyzer.Repository.LogiRepository;

@Service
@EnableAsync
public class LogService {

    @Autowired
    private LogiRepository repo;

    @Async
    public void processAsync(List<String> logs) {

        List<LogEntry> list = new ArrayList<>();

        for (String line : logs) {

            if (line.contains("ERROR") || line.contains("Exception")) {

                LogEntry l = new LogEntry();
                l.setMessage(line);
                l.setLevel("ERROR");
                l.setTimestamp(LocalDateTime.now());

                list.add(l);
            }
        }

        repo.saveAll(list);
    }
}
    

