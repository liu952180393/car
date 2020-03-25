package com.sys.service.serviceImpl;

import com.sys.dao.CustomerDao;
import com.sys.entity.CustomerPo;
import com.sys.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/25
 **/
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Override
    public int insertCustomer(CustomerPo customerPo) {
        int rows = customerDao.insertCustomer(customerPo);
        return rows;
    }
}
