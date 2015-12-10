package com.jdk2010.jqxx.skqjqszsm.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqJqszsm extends Model<SkqJqszsm> {
        	/* id */
    	private Integer id;
        	/* 机器编号 */
    	private String jqbh;
        	/* 税目编码 */
    	private String smbm;
             	 
  		@TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
        	 
  		@TableField
		public String getJqbh() {
			return jqbh;
		}
		public void setJqbh(String jqbh) {
			this.jqbh = jqbh;
		}
        	 
  		@TableField
		public String getSmbm() {
			return smbm;
		}
		public void setSmbm(String smbm) {
			this.smbm = smbm;
		}
    }