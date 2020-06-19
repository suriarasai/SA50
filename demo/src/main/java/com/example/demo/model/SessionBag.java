package com.example.demo.model;

public class SessionBag {
	
	private String displayName;

	public SessionBag() {
		super();
		// TODO Auto-generated constructor stub
		this.displayName="default";
	}

	public SessionBag(String displayName) {
		super();
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return "SessionBag [displayName=" + displayName + "]";
	}
	

}
