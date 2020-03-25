package com.sys.dao;

import com.sys.entity.NoticePo;
import org.springframework.stereotype.Repository;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/25
 **/
@Repository
public interface NoticeDao {
    int insertContent(NoticePo noticePo);
}
