package com.word;

import com.alibaba.excel.EasyExcel;
import com.word.config.EasyExcelConfig;
import com.word.service.EnglishWordService;
import com.word.vo.EnglishWordExcelVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;

@SpringBootTest
@Slf4j
class WordSpotCheckApplicationTests {

    @Resource
    private EnglishWordService englishWordService;
    @Test
    void contextLoads() {
        File a = new File("D://Documents/7000词/第一段440.xls");
        EasyExcelConfig easyExcelConfig1 = new EasyExcelConfig(englishWordService);
        EasyExcel.read(a, EnglishWordExcelVo.class,easyExcelConfig1).sheet().doRead();
    }

    @Test
    void ListSize(){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println(arr.size());
    }
}
