create database word;
create table englishword
(
    id            int auto_increment comment '单词索引'
        primary key,
    word          varchar(20)          null comment '单词',
    isSpotChecked tinyint(1) default 0 null comment '是否被抽查',
    isTrue        tinyint(1) default 0 null comment '是否正确',
    errorCount    int        default 0 null comment '错误次数',
    page          int                  null comment '单词所在页数',
    importance    int        default 0 null comment '重要程度0-5',
    isAllRight    tinyint(1) default 0 null comment '是否完全记得此单词'
)
    comment '英语单词表';