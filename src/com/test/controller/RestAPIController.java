package com.test.controller;

import java.util.concurrent.Callable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.db.TestDAO;
import com.test.model.GetTagList;


@RestController
public class RestAPIController {
	
	@Autowired
	private TestDAO testDAO;

	private static final Log LOG = LogFactory.getLog(RestAPIController.class);

	@RequestMapping("/api/getTagList")
	public Callable<GetTagList> getUserVideoList(@PathVariable String user) {
		return new Callable<GetTagList>() {
			@Override
			public GetTagList call() throws Exception {
				GetTagList response = testDAO.getTagList();
				LOG.info("Recieved tagList from Services: " + response);
				return response;
			}
		};
	}
}
