package com.feri.byby.admin.serviceimpl;

import com.feri.byby.admin.common.RUtil;
import com.feri.byby.admin.domain.Permission;
import com.feri.byby.admin.mapper.PermissionMapper;
import com.feri.byby.admin.service.PermissionService;
import com.feri.byby.admin.vo.PageVo;
import com.feri.byby.admin.vo.R;
import com.feri.byby.common.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/11/30 10:20
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public R save(Permission permission) {
        return RUtil.setRes(permissionMapper.insert(permission));
    }
    @Override
    public List<String> queryByAid(int aid) {
        return permissionMapper.selectByAid(aid);
    }
    @Override
    public PageVo<Permission> queryByPage(int page, int count) {
        int index=0;
        if(page>0){
            index=(page-1)*count;
        }
        return PageVo.createPage(permissionMapper.selectByPage(index,count),permissionMapper.selectCount());
    }

    @Override
    public List<Permission> queryFirstMenu() {
        return permissionMapper.selectByPid();
    }
}