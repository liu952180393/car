package com.sys.dao;

import com.sys.entity.NoticePo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/25
 **/
@Repository
public interface NoticeDao {
    /**
     * 添加公告信息
     * @param noticePo
     * @return
     */
    int insertContent(NoticePo noticePo);

    /**
     * 修改公告信息
     * @param noticePo
     * @return
     */
    int updateContent(NoticePo noticePo);

    /**
     * 查询所有公告信息(用于展示)
     * @return
     */
    List<String> findAllContentShow();

    /**
     * 删除公告信息
     * @param id
     * @return
     */
    int deleltContent(Integer id);

    /**
     * 查询所有公告信息
     * @return
     */
    List<NoticePo> findAllNotice();
}
