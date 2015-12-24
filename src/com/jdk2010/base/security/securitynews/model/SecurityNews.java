package com.jdk2010.base.security.securitynews.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SecurityNews extends Model<SecurityNews> {
        	/* id */
    	private Integer id;
        	/* 通告标题 */
    	private String title;
        	/* 通告内容 */
    	private String content;
        	/* 用户id */
    	private Integer userid;
        	/* 是否启用 */
    	private Integer status;
        	/* 创建时间 */
    	private Date ctime;
             	 
  		@TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
        	 
  		@TableField
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
        	 
  		@TableField
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
        	 
  		@TableField
		public Integer getUserid() {
			return userid;
		}
		public void setUserid(Integer userid) {
			this.userid = userid;
		}
        	 
  		@TableField
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
        	 
  		@TableField
		public Date getCtime() {
			return ctime;
		}
		public void setCtime(Date ctime) {
			this.ctime = ctime;
		}
		
		private String realname;

        public String getRealname() {
            return realname;
        }
        public void setRealname(String realname) {
            this.realname = realname;
        }

        
		
    }