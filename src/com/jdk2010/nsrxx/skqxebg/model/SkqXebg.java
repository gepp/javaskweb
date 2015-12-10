package com.jdk2010.nsrxx.skqxebg.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqXebg extends Model<SkqXebg> {
        	/* ID */
    	private Integer id;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
        	/* 机器编号 */
    	private String jqbh;
        	/* 剩余累计开票限额 */
    	private Double syljkpxe;
        	/* 剩余累计退票限额 */
    	private Double syljtpxe;
        	/* 申请累计开票限额 */
    	private Double sqljkpxe;
        	/* 申请累计退票限额 */
    	private Double sqljtpxe;
        	/* 申请累计退票限额 */
    	private Double pzljkpxe;
        	/* 批准累计退票限额 */
    	private Double pzljtpxe;
        	/* 变更说明 */
    	private String bgsm;
        	/* 申请时间 */
    	private Date sqsj;
        	/* 处理标示 */
    	private Integer clbz;
        	/* 处理者 */
    	private String clz;
        	/* 处理意见 */
    	private String clyj;
        	/* 处理时间 */
    	private Date clsj;
        	/* 下载标示 */
    	private Integer xzbs;
             	 
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
		public String getJqbh() {
			return jqbh;
		}
		public void setJqbh(String jqbh) {
			this.jqbh = jqbh;
		}
        	 
  		@TableField
		public Double getSyljkpxe() {
			return syljkpxe;
		}
		public void setSyljkpxe(Double syljkpxe) {
			this.syljkpxe = syljkpxe;
		}
        	 
  		@TableField
		public Double getSyljtpxe() {
			return syljtpxe;
		}
		public void setSyljtpxe(Double syljtpxe) {
			this.syljtpxe = syljtpxe;
		}
        	 
  		@TableField
		public Double getSqljkpxe() {
			return sqljkpxe;
		}
		public void setSqljkpxe(Double sqljkpxe) {
			this.sqljkpxe = sqljkpxe;
		}
        	 
  		@TableField
		public Double getSqljtpxe() {
			return sqljtpxe;
		}
		public void setSqljtpxe(Double sqljtpxe) {
			this.sqljtpxe = sqljtpxe;
		}
        	 
  		@TableField
		public Double getPzljkpxe() {
			return pzljkpxe;
		}
		public void setPzljkpxe(Double pzljkpxe) {
			this.pzljkpxe = pzljkpxe;
		}
        	 
  		@TableField
		public Double getPzljtpxe() {
			return pzljtpxe;
		}
		public void setPzljtpxe(Double pzljtpxe) {
			this.pzljtpxe = pzljtpxe;
		}
        	 
  		@TableField
		public String getBgsm() {
			return bgsm;
		}
		public void setBgsm(String bgsm) {
			this.bgsm = bgsm;
		}
        	 
  		@TableField
		public Date getSqsj() {
			return sqsj;
		}
		public void setSqsj(Date sqsj) {
			this.sqsj = sqsj;
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
		public String getClyj() {
			return clyj;
		}
		public void setClyj(String clyj) {
			this.clyj = clyj;
		}
        	 
  		@TableField
		public Date getClsj() {
			return clsj;
		}
		public void setClsj(Date clsj) {
			this.clsj = clsj;
		}
        	 
  		@TableField
		public Integer getXzbs() {
			return xzbs;
		}
		public void setXzbs(Integer xzbs) {
			this.xzbs = xzbs;
		}
    }