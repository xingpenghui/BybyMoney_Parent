package com.feri.byby.admin.serviceimpl;

import com.feri.byby.admin.common.RUtil;
import com.feri.byby.admin.domain.Permission;
import com.feri.byby.admin.domain.Role;
import com.feri.byby.admin.domain.RolePer;
import com.feri.byby.admin.mapper.RoleMapper;
import com.feri.byby.admin.mapper.RolePerMapper;
import com.feri.byby.admin.service.RoleService;
import com.feri.byby.admin.vo.PageVo;
import com.feri.byby.admin.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/11/30 10:19
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePerMapper rolePerMapper;
    @Override
    public R save(Role role) {
        return RUtil.setRes(roleMapper.insert(role));
    }
    @Override
    @Transactional
    public R updatePermission(int[] pids, int rid) {
        rolePerMapper.deleteByRid(rid);
        for(int pid:pids){
            RolePer rolePermission=new RolePer();
            rolePermission.setPid(pid);
            rolePermission.setRid(rid);
            rolePerMapper.insert(rolePermission);
        }
        return RUtil.setOK("修改角色权限成功");
    }
    @Override
    public PageVo<Role> queryByPage(int page, int count) {
        int index=0;
        if(page>0){
            index=(page-1)*count;
        }
        return PageVo.createPage(roleMapper.selectByPage(index,count),roleMapper.selectCount());
    }

    @Override
    public List<Role> queryAll() {
        return roleMapper.selectAll();
    }

    @Override
    public List<Integer> selectByAid(int aid) {
        return roleMapper.selectByAid(aid);
    }
}