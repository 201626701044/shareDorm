package com.zoe.shareDorm.po;

import java.util.Date;

/**
 * 房源类别实体类
 * 
 * @author
 *
 */
public class HouseCategory {

	// 主键ID
	private Long houseCategoryId;
	// 类别名
	private String houseCategoryName;
	// 类别描述
	private String houseCategoryDesc;
	// 类别图片地址(针对一级类别)
	private String houseCategoryImg;
	// 权重，越大越排前显示
	private Integer priority;
	// 创建时间
	private Date createTime;
	// 最近的更新时间
	private Date lastEditTime;
	// 父类别
	private HouseCategory parent;

	public Long getHouseCategoryId() {
		return houseCategoryId;
	}

	public void setHouseCategoryId(Long houseCategoryId) {
		this.houseCategoryId = houseCategoryId;
	}

	public String getHouseCategoryName() {
		return houseCategoryName;
	}

	public void setHouseCategoryName(String houseCategoryName) {
		this.houseCategoryName = houseCategoryName;
	}

	public String getHouseCategoryDesc() {
		return houseCategoryDesc;
	}

	public void setHouseCategoryDesc(String houseCategoryDesc) {
		this.houseCategoryDesc = houseCategoryDesc;
	}

	public String getHouseCategoryImg() {
		return houseCategoryImg;
	}

	public void setHouseCategoryImg(String houseCategoryImg) {
		this.houseCategoryImg = houseCategoryImg;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public HouseCategory getParent() {
		return parent;
	}

	public void setParent(HouseCategory parent) {
		this.parent = parent;
	}
}
