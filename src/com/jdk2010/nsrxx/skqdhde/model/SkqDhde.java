package com.jdk2010.nsrxx.skqdhde.model;
import java.util.Date;
import com.jdk2010.framework.dal.model.Model;
import com.jdk2010.framework.dal.parse.annotation.TableField;

public class SkqDhde extends Model<SkqDhde> {
        	/* ID */
    	private Integer id;
        	/* 纳税人微机编码 */
    	private String nsrwjbm;
        	/* 机器编号 */
    	private String jqbh;
        	/* 机器编号 */
    	private Double dzkpxe;
        	/* 月累计开票限额 */
    	private Double yljkpxe;
        	/* 月累计开票限额 */
    	private Double yljtpxe;
        	/* 启用标示 */
    	private Integer qybz;
             	 
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
		public Double getDzkpxe() {
			return dzkpxe;
		}
		public void setDzkpxe(Double dzkpxe) {
			this.dzkpxe = dzkpxe;
		}
        	 
  		@TableField
		public Double getYljkpxe() {
			return yljkpxe;
		}
		public void setYljkpxe(Double yljkpxe) {
			this.yljkpxe = yljkpxe;
		}
        	 
  		@TableField
		public Double getYljtpxe() {
			return yljtpxe;
		}
		public void setYljtpxe(Double yljtpxe) {
			this.yljtpxe = yljtpxe;
		}
        	 
  		@TableField
		public Integer getQybz() {
			return qybz;
		}
		public void setQybz(Integer qybz) {
			this.qybz = qybz;
		}
    }