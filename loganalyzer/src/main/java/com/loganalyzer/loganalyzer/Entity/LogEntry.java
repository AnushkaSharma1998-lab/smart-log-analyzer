package com.loganalyzer.loganalyzer.Entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
@Data


public class LogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private String level;
    private LocalDateTime timestamp;    
}
