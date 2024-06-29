package com.springcore.constructorinjection;

import java.util.List;

public class TnP {
	private String enrollmentNo;
	private String name;
	private Placed placement; 
	private List<String> mobs;
	
	public TnP(String enrollmentNo, String name, Placed placement, List<String> mobs) {
		this.enrollmentNo = enrollmentNo;
		this.name = name;
		this.placement = placement;
		this.mobs = mobs;
	}

	@Override
	public String toString() {
		return "TnP [enrollmentNo=" + enrollmentNo + ", name=" + name + ", placement=" + placement + ", mobs=" + mobs
				+ "]";
	}

	
	
}
