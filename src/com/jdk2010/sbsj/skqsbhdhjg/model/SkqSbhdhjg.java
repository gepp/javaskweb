package com.jdk2010.sbsj.skqsbhdhjg.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqSbhdhjg extends Model<SkqSbhdhjg> {
        	/* id */
    	private Integer id;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
        	/* 年份 */
    	private Integer year;
        	/* 月份 */
    	private Integer month;
        	/* 创建时间 */
    	private Date cjsj;
        	/* 处理标示 */
    	private Integer clbz;
        	/* 处理时间 */
    	private String clz;
        	/* 处理者 */
    	private Date clsj;
             	 
  		@TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
        	 
  		@TableField
		public String getNsrwjbm() {
			return nsrwjbm;
		}
		public void setNsrwjbm(String nsrwjbm) {
			this.nsrwjbm = nsrwjbm;
		}
        	 
  		@TableField
		public Integer getYear() {
			return year;
		}
		public void setYear(Integer year) {
			this.year = year;
		}
        	 
  		@TableField
		public Integer getMonth() {
			return month;
		}
		public void setMonth(Integer month) {
			this.month = month;
		}
        	 
  		@TableField
		public Date getCjsj() {
			return cjsj;
		}
		public void setCjsj(Date cjsj) {
			this.cjsj = cjsj;
		}
        	 
  		@TableField
		public Integer getClbz() {
			return clbz;
		}
		public void setClbz(Integer clbz) {
			this.clbz = clbz;
		}
        	 
  		@TableField
		public String getClz() {
			return clz;
		}
		public void setClz(String clz) {
			this.clz = clz;
		}
        	 
  		@TableField
		public Date getClsj() {
			return clsj;
		}
		public void setClsj(Date clsj) {
			this.clsj = clsj;
		}
    }