package com.word.controller;

import com.word.dto.Result;
import com.word.entity.EnglishWord;
import com.word.service.EnglishWordService;
import com.word.vo.EnglishWordVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @author LinTongXue
 * @description 针对单词数据进行数据的处理
 * @createDate 2023-01-03 16:42:16
 */

@RestController
@RequestMapping("/word")
@CrossOrigin
@Slf4j
public class EnglishWordController {
    @Resource
    private EnglishWordService englishWordService;

    /**
     * 添加一个单词
     * @param englishWord 单词
     */
    @GetMapping("/insertWord/{englishWord}")
    public void insertWord(@PathVariable String englishWord){
        englishWordService.insertWord(englishWord);
    }

    /**
     * 查询所有单词
     * @return 通用返回结果
     */
    @GetMapping("/showWord")
    public Result<List<EnglishWord>> selectAllEnglishWord(){
        List<EnglishWord> englishWords = englishWordService.selectAllEnglishWord();
        if(englishWords!=null){
            log.info("查找单词成功");
            return Result.success(englishWords);
        }else{
            log.error("服务器异常");
            return Result.fail("服务器异常");
        }
    }

    /**
     * 根据单词id修改单词为正确
     * @RequestBody EnglishWordVo
     * @return 通用返回结果
     */
    @PostMapping("/modifyWordTrue")
    public Result<String> modifyWordTrue(@RequestBody EnglishWordVo englishWordVo){
        EnglishWord englishWord = englishWordService.selectWordById(englishWordVo.getId());
        if(englishWord.getIsTrue() == 1){
            log.info("{} 单词已经答对过啦",englishWord.getWord());
            return Result.fail(englishWord.getWord()+" 单词已经答对过啦");
        }else if (englishWord.getIsTrue() == -1){
            log.info("{} 单词暂时是答错状态喔，请先去错误单词模块攻克它吧！",englishWord.getWord());
            return Result.fail(englishWord.getWord()+" 单词暂时是答错状态喔，请先去错误单词模块攻克它吧！");
        }
        int modifyWordTrue = englishWordService.modifyWordTrueById(englishWordVo.getId());
        if(modifyWordTrue != 0){
            log.info("修改单词为正确成功");
            return Result.success("修改成功");
        }else{
            log.info("修改单词为正确失败");
            return Result.fail("修改失败");
        }
    }

    /**
     * 根据单词id修改单词为错误
     * @RequestBody EnglishWordVo
     * @return 通用返回结果
     */
    @PostMapping("/modifyWordError")
    public Result<String> modifyWordError(@RequestBody EnglishWordVo englishWordVo){
        EnglishWord englishWord = englishWordService.selectWordById(englishWordVo.getId());
        if (englishWord.getIsTrue() == -1){
            log.info("{} 单词已经是答错状态啦！",englishWord.getWord());
            return Result.fail(englishWord.getWord()+" 单词已经是答错状态啦！");
        }
        Integer modifyWordError = englishWordService.modifyWordErrorById(englishWordVo.getId());
        if(modifyWordError != 0){
            log.info("修改单词为错误成功");
            return Result.success("修改成功");
        }else {
            log.info("修改单词为错误失败");
            return Result.fail("修改失败");
        }
    }

    /**
     * 充值单词数据
     * @return 修改行数
     */
    @PutMapping("/Reset")
    public Result<String> Reset(){
        Integer reset = englishWordService.Reset();
        if(reset != 0){
            log.info("重置成功");
            return Result.success("重置成功");
        }else{
            log.error("重置失败");
            return Result.fail("重置失败");
        }
    }

    /**
     * 根据id集合批量修改单词为正确
     * @RequestBody List<Integer>
     * @return 通用返回结果
     */
    @PostMapping("/modifyWordTrueByIds")
    public Result<String> modifyWordTrueByIds(@RequestBody List<Integer> wordIds){
        if(wordIds.isEmpty()) {
            log.info("还没有选中单词");
            return Result.fail("还没有选中单词");
        }
        List<EnglishWord> englishWords = englishWordService.selectErrorWordByIds(wordIds);
        if(englishWords.isEmpty()) {
            Integer modifyWordTrueByIds = englishWordService.modifyWordTrueByIds(wordIds);
            if (modifyWordTrueByIds != 0) {
                log.info("批量修改成功");
                return Result.success("批量修改成功");
            } else {
                log.error("批量修改失败");
                return Result.fail("批量修改失败");
            }
        }else {
            log.info("选中的单词有以错误单词存在，无法批量修改为正确");
            return Result.fail("选中的单词有以错误单词存在，无法批量修改为正确");
        }
    }

    /**
     * 根据id集合批量修改单词为错误
     * @RequestBody List<Integer>
     * @return 通用返回结果
     */
    @PostMapping("/modifyWordErrorByIds")
    public Result<String> modifyWordErrorByIds(@RequestBody List<Integer> wordIds){
        if(wordIds.isEmpty()) {
            log.info("还没有选中单词");
            return Result.fail("还没有选中单词");
        }
        Integer modifyWordErrorByIds = englishWordService.modifyWordErrorByIds(wordIds);
        if (modifyWordErrorByIds != 0) {
            log.info("批量修改成功");
            return Result.success("批量修改成功");
        } else {
            log.error("批量修改失败");
            return Result.fail("批量修改失败");
        }
    }

    /**
     * 随机抽查NoOne-NoTwo范围内未抽查的单词
     * @RequestBody NoOne,NoTwo
     * @return EnglishWord对象
     */
    @GetMapping("/spotCheckWord/{NoOne},{NoTwo}")
    public Result<EnglishWord> spotCheckWord(@PathVariable Integer NoOne,@PathVariable Integer NoTwo){
        List<Integer> wordNotCheckedIds = englishWordService.WordNotCheckedId(NoOne,NoTwo);
        if(wordNotCheckedIds.isEmpty()){
            log.info("没有未抽查过的单词");
            return Result.fail("没有未抽查过的单词");
        }else{
            Random a = new Random();
            int i = a.nextInt(wordNotCheckedIds.size());
            log.info("size: {}",wordNotCheckedIds.size());
            int wordNotCheckedId = wordNotCheckedIds.get(i);
            EnglishWord englishWord = englishWordService.selectWordById(wordNotCheckedId);
            log.info("成功抽查到了 {} 单词",englishWord.getWord());
            return Result.success(englishWord);
        }
    }

    /**
     * 查询NoOne-NoTwo范围内未抽查的单词
     * @RequestBody NoOne,NoTwo
     * @return EnglishWord对象集合
     */
    @GetMapping("/wordNotChecked/{NoOne},{NoTwo}")
    public Result<List<EnglishWord>> wordNotChecked(@PathVariable Integer NoOne,@PathVariable Integer NoTwo){
        List<EnglishWord> englishWords = englishWordService.wordNotChecked(NoOne,NoTwo);
        if(englishWords.isEmpty()){
            log.info("此范围内没有未抽查的单词");
            return Result.fail("此范围内没有未抽查的单词");
        }else {
            return Result.success(englishWords);
        }
    }
}
