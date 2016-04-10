package com.test.model;

import java.util.List;

public class DBDataResponse {

	private List<String> handleList;
	private List<String> tagList;
	
	public DBDataResponse(List<String> handleList, List<String> tagList) {
		this.handleList = handleList;
		this.tagList = tagList;
	}

	public List<String> getTagList() {
		return tagList;
	}

	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}
	
	

	public List<String> getHandleList() {
		return handleList;
	}

	public void setHandleList(List<String> handleList) {
		this.handleList = handleList;
	}

	@Override
	public String toString() {
		return "DBDataResponse [handleList=" + handleList + ", tagList="
				+ tagList + "]";
	}
	
	
}
