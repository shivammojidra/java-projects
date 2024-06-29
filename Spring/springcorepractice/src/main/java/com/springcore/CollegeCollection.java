package com.springcore;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollegeCollection {
	private List<Integer> collegeIdList;
	private Set<String> collegeNameSet;
	private Map<Integer, String> collegeIdNameMap;
	
	
	public CollegeCollection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CollegeCollection(List<Integer> collegeIdList, Set<String> collegeNameSet,
			Map<Integer, String> collegeIdNameMap) {
		super();
		this.collegeIdList = collegeIdList;
		this.collegeNameSet = collegeNameSet;
		this.collegeIdNameMap = collegeIdNameMap;
	}
	@Override
	public String toString() {
		return "CollegeCollection [collegeIdList=" + collegeIdList + ", collegeNameSet=" + collegeNameSet
				+ ", collegeIdNameMap=" + collegeIdNameMap + "]";
	}
	public List<Integer> getCollegeIdList() {
		return collegeIdList;
	}
	public void setCollegeIdList(List<Integer> collegeIdList) {
		this.collegeIdList = collegeIdList;
	}
	public Set<String> getCollegeNameSet() {
		return collegeNameSet;
	}
	public void setCollegeNameSet(Set<String> collegeNameSet) {
		this.collegeNameSet = collegeNameSet;
	}
	public Map<Integer, String> getCollegeIdNameMap() {
		return collegeIdNameMap;
	}
	public void setCollegeIdNameMap(Map<Integer, String> collegeIdNameMap) {
		this.collegeIdNameMap = collegeIdNameMap;
	}
}
