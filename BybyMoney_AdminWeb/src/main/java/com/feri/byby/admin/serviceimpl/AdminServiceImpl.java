package com.feri.byby.admin.serviceimpl;

import com.alibaba.druid.sql.PagerUtils;
import com.feri.byby.admin.common.RUtil;
import com.feri.byby.admin.domain.Admin;
import com.feri.byby.admin.domain.AdminRole;
import com.feri.byby.admin.domain.Permission;
import com.feri.byby.admin.mapper.AdminMapper;
import com.feri.byby.admin.mapper.AdminRoleMapper;
import com.feri.byby.admin.mapper.PermissionMapper;
import com.feri.byby.admin.service.AdminService;
import com.feri.byby.admin.vo.MenuVo;
import com.feri.byby.admin.vo.PageVo;
import com.feri.byby.admin.vo.R;
import com.feri.byby.common.util.EncrypUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 *@Author feri
 *@Date Created in 2018/11/30 10:19
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public R save(Admin user) {
        user.setPassword(EncrypUtil.md5Pass(user.getPassword()));
        return RUtil.setRes(adminMapper.insert(user));
    }
    @Override
    public R checkName(String name) {
        Admin user=adminMapper.selectByName(name);
        if(user==null){
            //可用
            return RUtil.setOK("用户名可用");
        }else{
            return RUtil.setERROR("用户名不可用");
        }
    }
    @Override
    public Admin login(String name, String password) {
        Admin admin=adminMapper.selectByName(name);
        if(admin!=null){
            //校验密码
            if(Objects.equals(admin.getPassword(),EncrypUtil.md5Pass(password))){
                return admin;
            }
        }
        return null;
    }
    @Override
    @Transactional
    public R updateRole(int[] rids, int aid) {
        adminRoleMapper.deleteByAid(aid);
        for(int rid:rids){
            AdminRole arole=new AdminRole();
            arole.setRid(rid);
            arole.setAid(aid);
            adminRoleMapper.insert(arole);
        }
        return RUtil.setOK("修改用户角色成功");
    }

    @Override
    public List<MenuVo> queryMenu(int aid) {
        System.out.println("菜单："+aid);
        List<Permission> total=permissionMapper.selectByMenuAid(aid);
        System.out.println("对应菜单："+total);
        List<MenuVo> menuVos=new ArrayList<>();
        for(Permission p:total){
            if(p.getParentid()==-1){
                MenuVo menuVo=new MenuVo();
                menuVo.setParent(p);
                menuVo.setChildrens(new ArrayList<>());
                menuVos.add(menuVo);
            }else{
                //二级菜单
                int index=indexParent(menuVos,p);
                if(index>-1){
                    //找到上级菜单  将当前资源对象添加到对应的孩子中
                    menuVos.get(index).getChildrens().add(p);
                }
            }
        }
        return menuVos;
    }
    @Override
    public PageVo<Admin> queryByPage(int page, int limit) {
        int index=0;
        if(page>0){
            index=(page-1)*limit;
        }
        return PageVo.createPage(adminMapper.selectByPage(index,limit,1),adminMapper.selectCount(1));
    }
    private int indexParent(List<MenuVo> menuVos,Permission permission){
        for(int i=0;i<menuVos.size();i++){
            if(menuVos.get(i).getParent().getId().intValue()==permission.getParentid().intValue()){
                return i;
            }
        }
        return -1;
    }
}