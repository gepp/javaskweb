package com.jdk2010.base.security.securityorganization.service; 
import java.util.List;
import java.util.Map;

import com.jdk2010.base.service.IBaseService;
public interface ISecurityOrganizationService  extends IBaseService{
    public List<Map<String, Object>> getOrganizationByParentId(String pid) throws Exception;

    public List<Map<String, Object>> getOrganizationListByParentId(String pid) throws Exception;
}
