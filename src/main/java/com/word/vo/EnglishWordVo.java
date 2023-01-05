package com.word.vo;

import lombok.Data;

@Data
public class EnglishWordVo {
    Integer id;
    String word;
    Integer page;
    Integer errorCount;
    Integer trueCount;
}
