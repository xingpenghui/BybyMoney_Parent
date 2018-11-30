package com.feri.byby.admin.shiro;

import com.feri.byby.admin.domain.Admin;
import com.feri.byby.admin.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/11/30 10:31
 */
public class AdminRelam extends AuthorizingRealm {

    private PermissionService permissionService;

    public AdminRelam(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    //授权  获取当前用户的所有权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        //获取当前登录用户的所有权限
        Admin admin=(Admin)SecurityUtils.getSubject().getSession().getAttribute("admin");
        List<String> pers=permissionService.queryByAid(admin.getId());
        authorizationInfo.addStringPermissions(pers);

        return authorizationInfo;
    }

    //认证  标记登录是否成功
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        if(token.getUsername()!=null){
            SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(token.getUsername(),token.getPassword(),getName());
            return authenticationInfo;
        }else{
            return null;
        }
    }
}