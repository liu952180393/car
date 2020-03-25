package com.sys.service.serviceImpl;

import com.sys.dao.NoticeDao;
import com.sys.entity.NoticePo;
import com.sys.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public int insertContent(NoticePo noticePo) {
        int rows = noticeDao.insertContent(noticePo);
        return rows;
    }
}
