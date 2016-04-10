package com.test.model;

import java.util.List;

public class GetTagList {

	private List<String> tagList;
	
	public GetTagList(List<String> tagList) {
		this.tagList = tagList;
	}

	public List<String> getTagList() {
		return tagList;
	}

	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}

	@Override
	public String toString() {
		return "GetTagList [tagList=" + tagList + "]";
	}
	
	
}
