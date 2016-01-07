package com.jdk2010.nsrxx.skqnsrxx.model;

import com.jdk2010.framework.dal.parse.annotation.TableField;

public class TransDmSwjg {
	private Integer id;
	private String swjgDmOld;
	private String swjgDmNew;
	private String swjgMcNew;
	private String xybz;
	private String yxbz;
	private String bz;

	@TableField
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@TableField
	public String getSwjgDmOld() {
		return swjgDmOld;
	}

	public void setSwjgDmOld(String swjgDmOld) {
		this.swjgDmOld = swjgDmOld;
	}

	@TableField
	public String getSwjgDmNew() {
		return swjgDmNew;
	}

	public void setSwjgDmNew(String swjgDmNew) {
		this.swjgDmNew = swjgDmNew;
	}

	@TableField
	public String getSwjgMcNew() {
		return swjgMcNew;
	}

	public void setSwjgMcNew(String swjgMcNew) {
		this.swjgMcNew = swjgMcNew;
	}

	@TableField
	public String getXybz() {
		return xybz;
	}

	public void setXybz(String xybz) {
		this.xybz = xybz;
	}

	@TableField
	public String getYxbz() {
		return yxbz;
	}

	public void setYxbz(String yxbz) {
		this.yxbz = yxbz;
	}

	@TableField
	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
