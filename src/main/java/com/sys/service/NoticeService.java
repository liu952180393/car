package com.sys.service;

import com.sys.entity.NoticePo;

import java.util.List;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/25
 **/
public interface NoticeService {
    /**
     * 添加公告信息
     * @param noticePo
     * @return
     */
    int insertContent(NoticePo noticePo);
    /**
     * 查询所有公告信息
     * @return
     */
    List<NoticePo> findAllNotice();
    /**
     * 删除公告信息
     * @param id
     * @return
     */
    int deleltContent(Integer id);
    /**
     * 查询所有公告信息(用于展示)
     * @return
     */
    String findAllContentShow();
    /**
     * 修改公告信息
     * @param noticePo
     * @return
     */
    int updateContent(NoticePo noticePo);
}
