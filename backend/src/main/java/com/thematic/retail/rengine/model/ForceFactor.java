package com.thematic.retail.rengine.model;

public class ForceFactor {
	
	private int forceFactorId;
	
	private String forceFactorName;
	
	private int forceFactorWeight;

	public ForceFactor(int forceFactorId, String forceFactorName, int forceFactorWeight) {
		super();
		this.forceFactorId = forceFactorId;
		this.forceFactorName = forceFactorName;
		this.forceFactorWeight = forceFactorWeight;
	}
	
	public ForceFactor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getForceFactorId() {
		return forceFactorId;
	}

	public void setForceFactorId(int forceFactorId) {
		this.forceFactorId = forceFactorId;
	}

	public String getForceFactorName() {
		return forceFactorName;
	}

	public void setForceFactorName(String forceFactorName) {
		this.forceFactorName = forceFactorName;
	}

	public int getForceFactorWeight() {
		return forceFactorWeight;
	}

	public void setForceFactorWeight(int forceFactorWeight) {
		this.forceFactorWeight = forceFactorWeight;
	}

	@Override
	public String toString() {
		return "\nForceFactor [forceFactorId=" + forceFactorId + ", forceFactorName=" + forceFactorName
				+ ", forceFactorWeight=" + forceFactorWeight + "]";
	}

}
