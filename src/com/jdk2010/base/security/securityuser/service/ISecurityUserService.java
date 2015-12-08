package com.jdk2010.base.security.securityuser.service;

import java.util.Map;

import com.jdk2010.base.security.securityuser.model.SecurityUser;
import com.jdk2010.base.service.IBaseService;

public interface ISecurityUserService extends IBaseService {

    public SecurityUser login(String username, String password) throws Exception;

    public boolean isExistUsername(String code);

    public Map<Object, Object> getUserMenuByUserId(Integer userId);

    public Map<Object, Object> getAllMenu();
    
    public Map<Object, Object>  getUserMenu(SecurityUser user);
}
