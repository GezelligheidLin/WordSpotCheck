package com.word.config;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.word.entity.EnglishWord;
import com.word.service.EnglishWordService;
import com.word.vo.EnglishWordExcelVo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class EasyExcelConfig extends AnalysisEventListener<EnglishWordExcelVo> {
    ArrayList<EnglishWordExcelVo> arr = new ArrayList<>();

    private EnglishWordService englishWordService;

    public EasyExcelConfig(EnglishWordService englishWordService) {
        this.englishWordService = englishWordService;
    }

    @Override
    public void invoke(EnglishWordExcelVo englishWordExcelVo, AnalysisContext analysisContext) {

        arr.add(englishWordExcelVo);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        List<EnglishWordExcelVo> data = getData();
        List<EnglishWord> englishWords = BeanUtil.copyToList(data, EnglishWord.class);
        englishWordService.saveBatch(englishWords);
    }

    public List<EnglishWordExcelVo> getData() {
        return arr;
    }


}
