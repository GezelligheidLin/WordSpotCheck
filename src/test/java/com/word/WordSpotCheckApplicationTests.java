package com.word;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.word.config.EasyExcelConfig;
import com.word.entity.EnglishWord;
import com.word.mapper.EnglishWordMapper;
import com.word.service.EnglishWordService;
import com.word.vo.EnglishWordExcelVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class WordSpotCheckApplicationTests {

    @Resource
    private EnglishWordService englishWordService;
    @Resource
    private EnglishWordMapper englishWordMapper;

    /**
     * 从excel批量导入数据
     * 此处File地址改成项目地址+/src/main/resources/第一段440.xls
     */
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

    @Test
    void getBaseMapperIsWhat(){
//        BaseMapper<EnglishWord> baseMapper = englishWordService.getMap();
//        System.out.println(baseMapper);
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        List<EnglishWord> englishWords = englishWordMapper.selectBatchIds(arr);
        System.out.println(englishWords);
    }
}
