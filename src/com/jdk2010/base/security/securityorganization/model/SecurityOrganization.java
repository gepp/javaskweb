package com.jdk2010.base.security.securityorganization.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SecurityOrganization extends Model<SecurityOrganization> {
        	/* pk */
    	private Integer id;
        	/* 编码 */
    	private String code;
        	/* 机构名称 */
    	private String name;
        	/* 描述 */
    	private String description;
        	/* 上级机构编码 */
    	private String parentId;
        	/* 状态 */
    	private String status;
    	
    	private Integer orderlist;
             	 
    	@TableField
  		public Integer getOrderlist() {
            return orderlist;
        }
        public void setOrderlist(Integer orderlist) {
            this.orderlist = orderlist;
        }
        @TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
        	 
  		@TableField
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
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
  		public String getParentId() {
            return parentId;
        }
        public void setParentId(String parentId) {
            this.parentId = parentId;
        }
        @TableField
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
    }