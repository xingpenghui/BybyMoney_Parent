package com.feri.byby.admin.serviceimpl;

import com.feri.byby.admin.service.UserService;
import com.feri.byby.admin.vo.PageVo;
import com.feri.byby.domain.user.User;
import com.feri.byby.mapper.user.UserMapper;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2018/12/3 14:51
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public PageVo<User> queryByPage(int page, int limit) {
        int index=0;
        if(page>1){
            index=(page-1)*limit;
        }
        return PageVo.createPage(userMapper.selectPage(index,limit),userMapper.selectCount());
    }

}
