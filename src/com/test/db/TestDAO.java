package com.test.db;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.test.model.DBDataResponse;

public class TestDAO{
	
	private static final Log LOG = LogFactory.getLog(TestDAO.class);
	
	@Autowired
	private MongoClient mongoClient;
	
	public DBDataResponse getDBData() {
		List<String> tagList = new ArrayList<String>();
		List<String> handleList = new ArrayList<String>();
		
		DB tagdb = mongoClient.getDB("tagdb");
		DBCursor cursor = tagdb.getCollection("tagList").find();
		while(cursor.hasNext()){
			BasicDBObject document = (BasicDBObject)cursor.next();
			tagList.add(document.getString("tag"));
		}
		LOG.info("taglist =" + tagList);
		
		DB handledb = mongoClient.getDB("handledb");
		cursor = handledb.getCollection("handleList").find();
		while(cursor.hasNext()){
			BasicDBObject document = (BasicDBObject)cursor.next();
			handleList.add(document.getString("handle"));
		}
		LOG.info("handlelist =" + handleList);

		return new DBDataResponse(handleList, tagList);
	}

	public static void main(String... args) {
		
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB tagdb = mongo.getDB("tagdb");
	
		DBCollection tagTable = tagdb.getCollection("tagList");
		
		BasicDBObject document1 = new BasicDBObject();
		document1.put("tag", "<b>[xxx]</b>");
		tagTable.insert(document1);
		
		BasicDBObject document2 = new BasicDBObject();
		document2.put("tag", "<b><u>[xxx]</b></u>");
		tagTable.insert(document2);

		BasicDBObject document3 = new BasicDBObject();
		document3.put("tag", "<b><i>[xxx]</b></i>");
		tagTable.insert(document3);

		
		DB handledb = mongo.getDB("handledb");
		DBCollection handleTable = handledb.getCollection("handleList");
		
		BasicDBObject handle1 = new BasicDBObject();
		handle1.put("handle", "@Rupkumar");
		handleTable.insert(handle1);
		
		BasicDBObject handle2 = new BasicDBObject();
		handle2.put("handle", "@Harry");
		handleTable.insert(handle2);
		
		BasicDBObject handle3 = new BasicDBObject();
		handle3.put("handle", "@Peter");
		handleTable.insert(handle3);
		
		
		DBCursor cursor = tagdb.getCollection("tagList").find();
		while(cursor.hasNext()){
			BasicDBObject tag = (BasicDBObject)cursor.next();
			System.out.println(tag.getString("tag"));
		}
		
		cursor = handledb.getCollection("handleList").find();
		while(cursor.hasNext()){
			BasicDBObject handle = (BasicDBObject)cursor.next();
			System.out.println(handle.getString("handle"));
		}

	}
}
