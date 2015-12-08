package com.jdk2010.system.skqpmsz.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqPmsz extends Model<SkqPmsz> {
        	/* id */
    	private Integer id;
        	/* 税种编码 */
    	private String szbm;
        	/* 税目编码 */
    	private String smbm;
        	/* 税目名称 */
    	private String smmc;
        	/* 税目简称 */
    	private String smjc;
        	/* 税率 */
    	private Double sl;
        	/* 税目索引 */
    	private Integer smsy;
        	/* 票种编码 */
    	private String fpbm;
        	/* 核定户开票限额比例 */
    	private Integer hdkpbl;
        	/* 查账征收户开票限额 */
    	private Double czkpxe;
        	/* 是否差额征收 */
    	private Integer cezs;
        	/* 状态 */
    	private Integer status;
             	 
  		@TableField
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
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
		public String getSmmc() {
			return smmc;
		}
		public void setSmmc(String smmc) {
			this.smmc = smmc;
		}
        	 
  		@TableField
		public String getSmjc() {
			return smjc;
		}
		public void setSmjc(String smjc) {
			this.smjc = smjc;
		}
        	 
  		@TableField
		public Double getSl() {
			return sl;
		}
		public void setSl(Double sl) {
			this.sl = sl;
		}
        	 
  		@TableField
		public Integer getSmsy() {
			return smsy;
		}
		public void setSmsy(Integer smsy) {
			this.smsy = smsy;
		}
        	 
  		@TableField
		public String getFpbm() {
			return fpbm;
		}
		public void setFpbm(String fpbm) {
			this.fpbm = fpbm;
		}
        	 
  		@TableField
		public Integer getHdkpbl() {
			return hdkpbl;
		}
		public void setHdkpbl(Integer hdkpbl) {
			this.hdkpbl = hdkpbl;
		}
        	 
  		@TableField
		public Double getCzkpxe() {
			return czkpxe;
		}
		public void setCzkpxe(Double czkpxe) {
			this.czkpxe = czkpxe;
		}
        	 
  		@TableField
		public Integer getCezs() {
			return cezs;
		}
		public void setCezs(Integer cezs) {
			this.cezs = cezs;
		}
        	 
  		@TableField
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
    }