package com.word.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.word.entity.EnglishWord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author LinTongXue
* @description 针对表【englishword(英语单词表)】的数据库操作Mapper
* @createDate 2023-01-03 16:42:16
* @Entity generator.entity.Englishword
*/
@Mapper
public interface EnglishWordMapper extends BaseMapper<EnglishWord> {
    //修改单词为正确
    Integer modifyWordTrue(Integer id);

    //修改单词为错误
    Integer modifyWordError(Integer id);

    //重置单词数据
    Integer Reset();

    //批量修改单词为正确
    Integer modifyWordTrueByIds(List<Integer> wordIds);

    //根据提供的id数组查找数据返回其中是否有已错误单词
    List<EnglishWord> selectErrorWordByIds(List<Integer> wordIds);

    //批量修改单词为错误
    Integer modifyWordErrorByIds(List<Integer> wordIds);

    //查询未被抽查的单词id
    List<Integer> WordNotCheckedId(@Param("NoOne") Integer NoOne,@Param("NoTwo") Integer NoTwo);

    //查询未被抽查的单词数据
    List<EnglishWord> wordNotChecked(@Param("NoOne") Integer NoOne,@Param("NoTwo") Integer NoTwo);
}




