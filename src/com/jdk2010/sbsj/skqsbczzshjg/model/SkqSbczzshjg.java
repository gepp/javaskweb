package com.jdk2010.sbsj.skqsbczzshjg.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqSbczzshjg extends Model<SkqSbczzshjg> {
        	/* id */
    	private Integer id;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
        	/* 年份 */
    	private Integer year;
        	/* 月份 */
    	private Integer month;
        	/* 开票税款 */
    	private Double kpsk;
        	/* 申报税款 */
    	private Double sbsk;
        	/* 创建时间 */
    	private Integer clbz;
        	/* 处理标示 */
    	private Date cjsj;
        	/* 处理时间 */
    	private Date clsj;
        	/* 处理者 */
    	private String clz;
             	 
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
		public Double getKpsk() {
			return kpsk;
		}
		public void setKpsk(Double kpsk) {
			this.kpsk = kpsk;
		}
        	 
  		@TableField
		public Double getSbsk() {
			return sbsk;
		}
		public void setSbsk(Double sbsk) {
			this.sbsk = sbsk;
		}
        	 
  		@TableField
		public Integer getClbz() {
			return clbz;
		}
		public void setClbz(Integer clbz) {
			this.clbz = clbz;
		}
        	 
  		@TableField
		public Date getCjsj() {
			return cjsj;
		}
		public void setCjsj(Date cjsj) {
			this.cjsj = cjsj;
		}
        	 
  		@TableField
		public Date getClsj() {
			return clsj;
		}
		public void setClsj(Date clsj) {
			this.clsj = clsj;
		}
        	 
  		@TableField
		public String getClz() {
			return clz;
		}
		public void setClz(String clz) {
			this.clz = clz;
		}
    }