package com.word.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.word.entity.EnglishWord;

import java.util.List;

/**
* @author 27211
* @description 针对表【englishword(英语单词表)】的数据库操作Service
* @createDate 2023-01-03 16:42:16
*/
public interface EnglishWordService extends IService<EnglishWord> {
    /**
     * 添加单个单词
     */
    void insertWord(String englishWord);

    /**
     * 所有单词查询
     * @return 单词 list
     */
    List<EnglishWord> selectAllEnglishWord();

    /**
     * 根据单词id修改单词为正确
     * @return 修改行数
     */
    Integer modifyWordTrueById(Integer id);

    /**
     * 根据单词id修改单词为错误
     * @return 修改行数
     */
    Integer modifyWordErrorById(Integer id);

    /**
     * 根据单词id查询单词数据
     * @return 单词对象
     */
    EnglishWord selectWordById(Integer id);

    /**
     * 重置单词数据
     * @return 修改行数
     */
    Integer Reset();

    /**
     * 批量修改单词为正确
     * @return 修改行数
     */
    Integer modifyWordTrueByIds(List<Integer> wordIds);

    /**
     * 根据提供的id数组查找数据返回其中是否有已错误单词
     * @return 已错误单词的对象数组
     */
    List<EnglishWord> selectErrorWordByIds(List<Integer> wordIds);

    /**
     * 批量修改单词为错误
     * @return 修改行数
     */
    Integer modifyWordErrorByIds(List<Integer> wordIds);

    /**
     * 查询未被抽查的单词id
     * @return id集合
     */
    List<Integer> WordNotCheckedId(Integer NoOne,Integer NoTwo);

    /**
     * 根据id数组查询单词数据
     * @return 返回单词数据数组
     */
    List<EnglishWord> wordNotChecked(Integer NoOne,Integer NoTwo);
}
