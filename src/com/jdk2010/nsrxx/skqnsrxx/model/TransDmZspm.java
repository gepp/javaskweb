package com.jdk2010.nsrxx.skqnsrxx.model;

import com.jdk2010.framework.dal.parse.annotation.TableField;

public class TransDmZspm {
	private Integer id;
	private String zsxmDmOld;
	private String zsxmMcOld;
	private String zspmDmOld;
	private String zspmMcOld;
	private String zsxmDmNew;
	private String zspmDmNew;
	private String zspmMcNew;
	private String bz;

	@TableField
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@TableField
	public String getZsxmDmOld() {
		return zsxmDmOld;
	}

	public void setZsxmDmOld(String zsxmDmOld) {
		this.zsxmDmOld = zsxmDmOld;
	}

	@TableField
	public String getZsxmMcOld() {
		return zsxmMcOld;
	}

	public void setZsxmMcOld(String zsxmMcOld) {
		this.zsxmMcOld = zsxmMcOld;
	}

	@TableField
	public String getZspmDmOld() {
		return zspmDmOld;
	}

	public void setZspmDmOld(String zspmDmOld) {
		this.zspmDmOld = zspmDmOld;
	}

	@TableField
	public String getZspmMcOld() {
		return zspmMcOld;
	}

	public void setZspmMcOld(String zspmMcOld) {
		this.zspmMcOld = zspmMcOld;
	}

	@TableField
	public String getZsxmDmNew() {
		return zsxmDmNew;
	}

	public void setZsxmDmNew(String zsxmDmNew) {
		this.zsxmDmNew = zsxmDmNew;
	}

	@TableField
	public String getZspmDmNew() {
		return zspmDmNew;
	}

	public void setZspmDmNew(String zspmDmNew) {
		this.zspmDmNew = zspmDmNew;
	}

	@TableField
	public String getZspmMcNew() {
		return zspmMcNew;
	}

	public void setZspmMcNew(String zspmMcNew) {
		this.zspmMcNew = zspmMcNew;
	}

	@TableField
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
