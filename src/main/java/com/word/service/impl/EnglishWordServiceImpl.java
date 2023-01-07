package com.word.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.word.entity.EnglishWord;
import com.word.mapper.EnglishWordMapper;
import com.word.service.EnglishWordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 27211
* @description 针对表【englishword(英语单词表)】的数据库操作Service实现
* @createDate 2023-01-03 16:42:16
*/
@Service
public class EnglishWordServiceImpl extends ServiceImpl<EnglishWordMapper, EnglishWord>
    implements EnglishWordService {

    @Resource
    private EnglishWordMapper englishWordMapper;

    /**
     * 添加单个单词
     */
    @Override
    public void insertWord(String englishWord) {
        EnglishWord englishWordEntity = new EnglishWord();
        englishWordEntity.setWord(englishWord);
        englishWordMapper.insert(englishWordEntity);
    }

    /**
     * 所有单词查询
     * @return 单词 list
     */
    @Override
    public List<EnglishWord> selectAllEnglishWord() {
        return englishWordMapper.selectList(null);
    }

    /**
     * 根据单词id修改单词为正确
     * @return 修改行数
     */
    @Override
    public Integer modifyWordTrueById(Integer id) {
        return englishWordMapper.modifyWordTrue(id);
    }

    /**
     * 根据单词id修改单词为错误
     * @return 修改行数
     */
    @Override
    public Integer modifyWordErrorById(Integer id) {
        return englishWordMapper.modifyWordError(id);
    }

    /**
     * 根据单词id查询单词数据
     * @return 单词对象
     */
    @Override
    public EnglishWord selectWordById(Integer id) {
        return englishWordMapper.selectById(id);
    }

    /**
     * 重置单词数据
     * @return 修改行数
     */
    @Override
    public Integer Reset() {
        return englishWordMapper.Reset();
    }

    /**
     * 批量修改单词为正确
     * @return 修改行数
     */
    @Override
    public Integer modifyWordTrueByIds(List<Integer> wordIds) {
        return englishWordMapper.modifyWordTrueByIds(wordIds);
    }

    /**
     * 根据提供的id数组查找数据返回其中是否有已错误单词
     * @return 已错误单词的对象数组
     */
    @Override
    public List<EnglishWord> selectErrorWordByIds(List<Integer> wordIds) {
        return englishWordMapper.selectErrorWordByIds(wordIds);
    }

    /**
     * 批量修改单词为错误
     * @return 修改行数
     */
    @Override
    public Integer modifyWordErrorByIds(List<Integer> wordIds) {
        return englishWordMapper.modifyWordErrorByIds(wordIds);
    }

    /**
     * 查询未被抽查的单词id
     * @return id集合
     */
    @Override
    public List<Integer> WordNotCheckedId(Integer NoOne,Integer NoTwo) {
        return englishWordMapper.WordNotCheckedId(NoOne,NoTwo);
    }

    /**
     * 根据id数组查询单词数据
     * @return 返回单词数据数组
     */
    @Override
    public List<EnglishWord> wordNotChecked(Integer NoOne,Integer NoTwo) {
        return englishWordMapper.wordNotChecked(NoOne,NoTwo);
    }


}




