package com.thematic.retail.rengine.model;

import java.util.List;

public class Force {
	
	private int forceId;
	
	private String forceName;
	
	private List<ForceFactor> forceFactorList;

	public Force(int forceId, String forceName, List<ForceFactor> forceFactorList) {
		super();
		this.forceId = forceId;
		this.forceName = forceName;
		this.forceFactorList = forceFactorList;
	}
	
	public Force() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getForceId() {
		return forceId;
	}

	public void setForceId(int forceId) {
		this.forceId = forceId;
	}

	public String getForceName() {
		return forceName;
	}

	public void setForceName(String forceName) {
		this.forceName = forceName;
	}

	public List<ForceFactor> getForceFactorList() {
		return forceFactorList;
	}

	public void setForceFactorList(List<ForceFactor> forceFactorList) {
		this.forceFactorList = forceFactorList;
	}

	@Override
	public String toString() {
		return "\nForce [forceId=" + forceId + ", forceName=" + forceName + ", forceFactorList=" + forceFactorList + "]";
	}
	
	

}
