package com.jdk2010.base.security.menu.model;

import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SecurityMenu extends Model<SecurityMenu> {
    /* id */
    private String id;
    /* name */
    private String name;
    
    
    /* description */
    private String description;
    /* order_list */
    private Integer orderlist;
    /* img */
    private String img;
    /* url */
    private String url;
    /* parent_id */
    private String parentId;
    /* type */
    private String type;
    /* status */
    private String status;

    @TableField
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @TableField
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @TableField
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @TableField
    public Integer getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(Integer orderlist) {
        this.orderlist = orderlist;
    }

    @TableField
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @TableField
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @TableField
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @TableField
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @TableField
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}