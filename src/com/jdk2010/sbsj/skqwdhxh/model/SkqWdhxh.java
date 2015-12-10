package com.jdk2010.sbsj.skqwdhxh.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqWdhxh extends Model<SkqWdhxh> {
        	/* id */
    	private Integer id;
        	/* 文档号序号 */
    	private Integer wdhxh;
        	/* LSXH */
    	private Integer lsxh;
        	/* WJBMXH */
    	private Integer wjbmxh;
             	 
  		@TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
        	 
  		@TableField
		public Integer getWdhxh() {
			return wdhxh;
		}
		public void setWdhxh(Integer wdhxh) {
			this.wdhxh = wdhxh;
		}
        	 
  		@TableField
		public Integer getLsxh() {
			return lsxh;
		}
		public void setLsxh(Integer lsxh) {
			this.lsxh = lsxh;
		}
        	 
  		@TableField
		public Integer getWjbmxh() {
			return wjbmxh;
		}
		public void setWjbmxh(Integer wjbmxh) {
			this.wjbmxh = wjbmxh;
		}
    }