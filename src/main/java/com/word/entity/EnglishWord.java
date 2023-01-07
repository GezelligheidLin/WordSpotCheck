package com.word.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 英语单词表
 * @TableName englishword
 */
@TableName(value ="englishword")
@Data
public class EnglishWord implements Serializable {
    /**
     * 单词索引
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 单词
     */
    @TableField(value = "word")
    private String word;

    /**
     * 是否被抽查
     */
    @TableField(value = "isSpotChecked")
    private Integer isSpotChecked;

    /**
     * 是否正确
     */
    @TableField(value = "isTrue")
    private Integer isTrue;

    /**
     * 错误次数
     */
    @TableField(value = "errorCount")
    private Integer errorCount;

    /**
     * 正确次数
     */
    @TableField(value = "trueCount")
    private Integer trueCount;

    /**
     * 单词所在页数
     */
    @TableField(value = "page")
    private Integer page;

    /**
     * 重要程度0-5
     */
    @TableField(value = "importance")
    private Integer importance;

    /**
     * 是否完全记得此单词
     */
    @TableField(value = "isAllRight")
    private Integer isAllRight;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}