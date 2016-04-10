package com.test.controller;

import java.util.concurrent.Callable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.db.TestDAO;
import com.test.model.DBDataResponse;


@RestController
public class RestAPIController {
	
	@Autowired
	private TestDAO testDAO;

	private static final Log LOG = LogFactory.getLog(RestAPIController.class);

	@RequestMapping("/api/getTagList")
	public Callable<DBDataResponse> getUserVideoList() {
		return new Callable<DBDataResponse>() {
			@Override
			public DBDataResponse call() throws Exception {
				DBDataResponse response = testDAO.getDBData();
				LOG.info("Recieved data from Services: " + response);
				return response;
			}
		};
	}
}
