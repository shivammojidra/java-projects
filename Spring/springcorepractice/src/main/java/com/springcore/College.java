package com.springcore;

public class College {
	private int collegeId;
	private String collegeName;
	private String collegeType;
	
	
	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", collegeType=" + collegeType
				+ "]";
	}
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	public College(int collegeId, String collegeName, String collegeType) {
		super();  
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.collegeType = collegeType;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getCollegeType() {
		return collegeType;
	}
	public void setCollegeType(String collegeType) {
		this.collegeType = collegeType;
	}
}
