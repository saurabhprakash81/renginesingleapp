package com.thematic.retail.rengine.model;

import java.util.List;

public class ForceFactors {

	private List<Force> forceList;

	public ForceFactors(List<Force> forceList) {
		super();
		this.forceList = forceList;
	}

	public ForceFactors() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<Force> getForceList() {
		return forceList;
	}

	public void setForceList(List<Force> forceList) {
		this.forceList = forceList;
	}

	@Override
	public String toString() {
		return "ForceFactors [forceList=" + forceList + "]";
	}

}
