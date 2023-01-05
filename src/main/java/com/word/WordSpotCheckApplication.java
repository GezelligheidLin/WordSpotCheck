package com.word;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class WordSpotCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordSpotCheckApplication.class, args);
        log.info("单词项目启动成功");
    }
}
