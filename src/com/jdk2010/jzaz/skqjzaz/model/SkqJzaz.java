package com.jdk2010.jzaz.skqjzaz.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqJzaz extends Model<SkqJzaz> {
        	/* ID */
    	private Integer id;
        	/* 上级项目ID */
    	private Integer parentid;
        	/* 项目代码 */
    	private String xmdm;
        	/* 项目名称 */
    	private String xmmc;
        	/* 税务机关编码 */
    	private String zgswjg;
        	/* 甲方微机编码 */
    	private String jfwjbm;
        	/* 甲方名称 */
    	private String jfmc;
        	/* 乙方微机编码 */
    	private String yfwjbm;
        	/* 乙方名称 */
    	private String yfmc;
        	/* 项目类型 */
    	private Integer xmlx;
        	/* 合同性质 */
    	private Integer htxz;
        	/* 工程款 */
    	private Double gck;
        	/* 甲供材 */
    	private Double jgc;
        	/* 创建者 */
    	private String cjz;
        	/* 创建时间 */
    	private Date cjsj;
        	/* 登记已开金额 */
    	private Double ykje;
        	/* 纳税人性质 */
    	private Integer nsrxz;
        	/* 待抵扣金额 */
    	private Double ddkje;
        	/* 项目状态 */
    	private Integer xmzt;
             	 
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
		public String getXmdm() {
			return xmdm;
		}
		public void setXmdm(String xmdm) {
			this.xmdm = xmdm;
		}
        	 
  		@TableField
		public String getXmmc() {
			return xmmc;
		}
		public void setXmmc(String xmmc) {
			this.xmmc = xmmc;
		}
        	 
  		@TableField
		public String getZgswjg() {
			return zgswjg;
		}
		public void setZgswjg(String zgswjg) {
			this.zgswjg = zgswjg;
		}
        	 
  		@TableField
		public String getJfwjbm() {
			return jfwjbm;
		}
		public void setJfwjbm(String jfwjbm) {
			this.jfwjbm = jfwjbm;
		}
        	 
  		@TableField
		public String getJfmc() {
			return jfmc;
		}
		public void setJfmc(String jfmc) {
			this.jfmc = jfmc;
		}
        	 
  		@TableField
		public String getYfwjbm() {
			return yfwjbm;
		}
		public void setYfwjbm(String yfwjbm) {
			this.yfwjbm = yfwjbm;
		}
        	 
  		@TableField
		public String getYfmc() {
			return yfmc;
		}
		public void setYfmc(String yfmc) {
			this.yfmc = yfmc;
		}
        	 
  		@TableField
		public Integer getXmlx() {
			return xmlx;
		}
		public void setXmlx(Integer xmlx) {
			this.xmlx = xmlx;
		}
        	 
  		@TableField
		public Integer getHtxz() {
			return htxz;
		}
		public void setHtxz(Integer htxz) {
			this.htxz = htxz;
		}
        	 
  		@TableField
		public Double getGck() {
			return gck;
		}
		public void setGck(Double gck) {
			this.gck = gck;
		}
        	 
  		@TableField
		public Double getJgc() {
			return jgc;
		}
		public void setJgc(Double jgc) {
			this.jgc = jgc;
		}
        	 
  		@TableField
		public String getCjz() {
			return cjz;
		}
		public void setCjz(String cjz) {
			this.cjz = cjz;
		}
        	 
  		@TableField
		public Date getCjsj() {
			return cjsj;
		}
		public void setCjsj(Date cjsj) {
			this.cjsj = cjsj;
		}
        	 
  		@TableField
		public Double getYkje() {
			return ykje;
		}
		public void setYkje(Double ykje) {
			this.ykje = ykje;
		}
        	 
  		@TableField
		public Integer getNsrxz() {
			return nsrxz;
		}
		public void setNsrxz(Integer nsrxz) {
			this.nsrxz = nsrxz;
		}
        	 
  		@TableField
		public Double getDdkje() {
			return ddkje;
		}
		public void setDdkje(Double ddkje) {
			this.ddkje = ddkje;
		}
        	 
  		@TableField
		public Integer getXmzt() {
			return xmzt;
		}
		public void setXmzt(Integer xmzt) {
			this.xmzt = xmzt;
		}
    }