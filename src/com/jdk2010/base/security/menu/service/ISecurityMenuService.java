package com.jdk2010.base.security.menu.service;

import java.util.List;
import java.util.Map;

import com.jdk2010.base.service.IBaseService;

public interface ISecurityMenuService extends IBaseService {

    public List<Map<String, Object>> getMenuByParentId(String pid) ;

    public List<Map<String, Object>> getMenuListByParentId(String pid) ;
    
    
}
