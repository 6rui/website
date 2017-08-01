package com.scdkay.website.common;

import com.scdkay.website.entity.PermissionEntity;
import com.scdkay.website.entity.RoleEntity;
import com.scdkay.website.entity.UserEntity;
import com.scdkay.website.service.UserService;
import com.scdkay.website.utils.CollectionUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * shiro的自定义域 负责处理权限相关的处理
 * Created by liurui on 2017/7/14.
 */
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;


    /**
     * 获取用户权限的相关信息
     *
     * @param principalCollection 收集信息的集合
     * @return 返回认证信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = principalCollection.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roleNames = new LinkedHashSet<>();
        Set<String> permissionNames = new LinkedHashSet<>();
        UserEntity userEntity = userService.findUserByUserName(userName);
        List<RoleEntity> roles = userEntity.getRoles();
        if (CollectionUtil.isNotEmpty(roles)) {
            for (RoleEntity roleEntity : roles) {
                roleNames.add(roleEntity.getName());
                List<PermissionEntity> permissionEntities = roleEntity.getPermissionEntities();
                if (CollectionUtil.isNotEmpty(permissionEntities)) {
                    for (PermissionEntity permissionEntity : permissionEntities) {
                        permissionNames.add(permissionEntity.getName());
                    }
                }
            }
        }
        simpleAuthorizationInfo.setRoles(roleNames);
        simpleAuthorizationInfo.setStringPermissions(permissionNames);
        return simpleAuthorizationInfo;
    }

    /**
     * 登录验证的方法
     *
     * @param authenticationToken 用户登录后的信息存放
     * @return 返回认证信息
     * @throws AuthenticationException 认证的异常信息异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = authenticationToken.getPrincipal().toString();
        UserEntity userEntity = userService.findUserByUserName(userName);
        AuthenticationInfo authenticationInfo;
        if (userEntity != null) {
            authenticationInfo = new SimpleAuthenticationInfo(userEntity.getUserName(), userEntity.getPassword(),"authRealm");
            return authenticationInfo;
        } else {
            return null;
        }
    }
}
