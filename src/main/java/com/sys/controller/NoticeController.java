package com.sys.controller;

import com.sys.entity.NoticePo;
import com.sys.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/25
 **/
@RestController
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @RequestMapping("/insertContent")
    public int insertContent(NoticePo noticePo){
        int rows = noticeService.insertContent(noticePo);
        return  rows;
    }
}
