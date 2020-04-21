package com.sys.controller;

import com.sys.entity.NoticePo;
import com.sys.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 查询所有公告信息
     * @return
     */
    @RequestMapping("findAllNotice")
    public List<NoticePo> insertContent() {
      return   noticeService.findAllNotice();

    }
    /**
     * 删除公告信息
     * @param id
     * @return
     */
    @RequestMapping("deleltContent")
    public int deleltContent(Integer id) {
        return noticeService.deleltContent(id);
    }
    /**
     * 查询所有公告信息(用于展示)
     * @return
     */
    @RequestMapping("findAllContentShow")
    public String findAllContentShow() {
        return noticeService.findAllContentShow();
    }
    /**
     * 修改公告信息
     * @param noticePo
     * @return
     */
    @RequestMapping("updateContent")
    public int updateContent(NoticePo noticePo) {
        return noticeService.updateContent(noticePo);
    }

}
