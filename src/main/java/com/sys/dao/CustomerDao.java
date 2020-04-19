package com.sys.dao;

import com.sys.entity.CustomerPo;
import org.springframework.stereotype.Repository;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/25
 **/
@Repository
public interface CustomerDao {
    int insertCustomer(CustomerPo customerPo);

}
