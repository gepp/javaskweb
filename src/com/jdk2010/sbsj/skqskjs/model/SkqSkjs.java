package com.jdk2010.sbsj.skqskjs.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqSkjs extends Model<SkqSkjs> {
        	/* ID */
    	private Integer id;
        	/* 申报汇总ID */
    	private Integer parentid;
        	/* 税种编码 */
    	private String szbm;
        	/* 税目编码 */
    	private String smbm;
        	/* 计税金额 */
    	private Double jsje;
        	/* 税率 */
    	private Double sl;
        	/* 应计税额 */
    	private Double yjse;
        	/* 处理方式 */
    	private Integer clfs;
        	/* 处理标示 */
    	private Integer clbs;
        	/* 申报时间 */
    	private Date sbsj;
        	/* 申报文档号 */
    	private String sbwdh;
        	/* 票表比对 */
    	private Integer pbbd;
             	 
  		@TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
        	 
  		@TableField
		public Integer getParentid() {
			return parentid;
		}
		public void setParentid(Integer parentid) {
			this.parentid = parentid;
		}
        	 
  		@TableField
		public String getSzbm() {
			return szbm;
		}
		public void setSzbm(String szbm) {
			this.szbm = szbm;
		}
        	 
  		@TableField
		public String getSmbm() {
			return smbm;
		}
		public void setSmbm(String smbm) {
			this.smbm = smbm;
		}
        	 
  		@TableField
		public Double getJsje() {
			return jsje;
		}
		public void setJsje(Double jsje) {
			this.jsje = jsje;
		}
        	 
  		@TableField
		public Double getSl() {
			return sl;
		}
		public void setSl(Double sl) {
			this.sl = sl;
		}
        	 
  		@TableField
		public Double getYjse() {
			return yjse;
		}
		public void setYjse(Double yjse) {
			this.yjse = yjse;
		}
        	 
  		@TableField
		public Integer getClfs() {
			return clfs;
		}
		public void setClfs(Integer clfs) {
			this.clfs = clfs;
		}
        	 
  		@TableField
		public Integer getClbs() {
			return clbs;
		}
		public void setClbs(Integer clbs) {
			this.clbs = clbs;
		}
        	 
  		@TableField
		public Date getSbsj() {
			return sbsj;
		}
		public void setSbsj(Date sbsj) {
			this.sbsj = sbsj;
		}
        	 
  		@TableField
		public String getSbwdh() {
			return sbwdh;
		}
		public void setSbwdh(String sbwdh) {
			this.sbwdh = sbwdh;
		}
        	 
  		@TableField
		public Integer getPbbd() {
			return pbbd;
		}
		public void setPbbd(Integer pbbd) {
			this.pbbd = pbbd;
		}
    }