package com.sys.service.serviceImpl;

import com.sys.dao.NoticeDao;
import com.sys.entity.NoticePo;
import com.sys.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/25
 **/
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;
    /**
     * 添加公告信息
     * @param noticePo
     * @return
     */
    @Override
    public int insertContent(NoticePo noticePo) {
        int rows = noticeDao.insertContent(noticePo);
        return rows;
    }
    /**
     * 查询所有公告信息
     * @return
     */
    @Override
    public List<NoticePo> findAllNotice() {
        return noticeDao.findAllNotice();
    }
    /**
     * 删除公告信息
     * @param id
     * @return
     */
    @Override
    public int deleltContent(Integer id) {
        return noticeDao.deleltContent(id);
    }
    /**
     * 查询所有公告信息(用于展示)
     * @return
     */
    @Override
    public String findAllContentShow() {
        List<String> allContentShow = noticeDao.findAllContentShow();
        String allContent="";
        for (String str : allContentShow) {
            allContent+=str;
        }
        return allContent;
    }
    /**
     * 修改公告信息
     * @param noticePo
     * @return
     */
    @Override
    public int updateContent(NoticePo noticePo) {
        return noticeDao.updateContent(noticePo);
    }
}
