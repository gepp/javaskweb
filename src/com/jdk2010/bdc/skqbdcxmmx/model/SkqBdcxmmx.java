package com.jdk2010.bdc.skqbdcxmmx.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqBdcxmmx extends Model<SkqBdcxmmx> {
        	/* id */
    	private Integer id;
        	/* 子项目ID */
    	private Integer parentid;
        	/* 项目名称 */
    	private String xmmc;
        	/* 项目编码 */
    	private String xmbm;
        	/* 保障性普通住宅套数 */
    	private Integer bzxptzzts;
        	/* 非保障性普通住宅套数 */
    	private Integer fbzxptzzts;
        	/* 非普通住宅套数 */
    	private Integer fptzzts;
        	/* 别墅套数 */
    	private Integer bsts;
        	/* 商铺套数 */
    	private Integer spts;
        	/* 写字楼套数 */
    	private Integer xzlts;
        	/* 其他套数 */
    	private Integer qtts;
        	/* 保障性普通住宅面积 */
    	private Double bzxptzzmj;
        	/* 非保障性普通住宅面积 */
    	private Double fbzxptzzmj;
        	/* 非普通住宅面积 */
    	private Double fptzzmj;
        	/* 别墅面积 */
    	private Double bsmj;
        	/* 商铺面积 */
    	private Double spmj;
        	/* 写字楼面积 */
    	private Double xzlmj;
        	/* 其他面积 */
    	private Double qtmj;
        	/* 创建者 */
    	private String cjz;
        	/* 创建时间 */
    	private Date cjsj;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
        	/* 主项目名称 */
    	private String zxmmc;
             	 
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
		public String getXmmc() {
			return xmmc;
		}
		public void setXmmc(String xmmc) {
			this.xmmc = xmmc;
		}
        	 
  		@TableField
		public String getXmbm() {
			return xmbm;
		}
		public void setXmbm(String xmbm) {
			this.xmbm = xmbm;
		}
        	 
  		@TableField
		public Integer getBzxptzzts() {
			return bzxptzzts;
		}
		public void setBzxptzzts(Integer bzxptzzts) {
			this.bzxptzzts = bzxptzzts;
		}
        	 
  		@TableField
		public Integer getFbzxptzzts() {
			return fbzxptzzts;
		}
		public void setFbzxptzzts(Integer fbzxptzzts) {
			this.fbzxptzzts = fbzxptzzts;
		}
        	 
  		@TableField
		public Integer getFptzzts() {
			return fptzzts;
		}
		public void setFptzzts(Integer fptzzts) {
			this.fptzzts = fptzzts;
		}
        	 
  		@TableField
		public Integer getBsts() {
			return bsts;
		}
		public void setBsts(Integer bsts) {
			this.bsts = bsts;
		}
        	 
  		@TableField
		public Integer getSpts() {
			return spts;
		}
		public void setSpts(Integer spts) {
			this.spts = spts;
		}
        	 
  		@TableField
		public Integer getXzlts() {
			return xzlts;
		}
		public void setXzlts(Integer xzlts) {
			this.xzlts = xzlts;
		}
        	 
  		@TableField
		public Integer getQtts() {
			return qtts;
		}
		public void setQtts(Integer qtts) {
			this.qtts = qtts;
		}
        	 
  		@TableField
		public Double getBzxptzzmj() {
			return bzxptzzmj;
		}
		public void setBzxptzzmj(Double bzxptzzmj) {
			this.bzxptzzmj = bzxptzzmj;
		}
        	 
  		@TableField
		public Double getFbzxptzzmj() {
			return fbzxptzzmj;
		}
		public void setFbzxptzzmj(Double fbzxptzzmj) {
			this.fbzxptzzmj = fbzxptzzmj;
		}
        	 
  		@TableField
		public Double getFptzzmj() {
			return fptzzmj;
		}
		public void setFptzzmj(Double fptzzmj) {
			this.fptzzmj = fptzzmj;
		}
        	 
  		@TableField
		public Double getBsmj() {
			return bsmj;
		}
		public void setBsmj(Double bsmj) {
			this.bsmj = bsmj;
		}
        	 
  		@TableField
		public Double getSpmj() {
			return spmj;
		}
		public void setSpmj(Double spmj) {
			this.spmj = spmj;
		}
        	 
  		@TableField
		public Double getXzlmj() {
			return xzlmj;
		}
		public void setXzlmj(Double xzlmj) {
			this.xzlmj = xzlmj;
		}
        	 
  		@TableField
		public Double getQtmj() {
			return qtmj;
		}
		public void setQtmj(Double qtmj) {
			this.qtmj = qtmj;
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
		public String getNsrwjbm() {
			return nsrwjbm;
		}
		public void setNsrwjbm(String nsrwjbm) {
			this.nsrwjbm = nsrwjbm;
		}
        	 
  		@TableField
		public String getZxmmc() {
			return zxmmc;
		}
		public void setZxmmc(String zxmmc) {
			this.zxmmc = zxmmc;
		}
    }