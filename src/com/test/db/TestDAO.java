package com.test.db;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.test.model.GetTagList;

public class TestDAO{
	
	private static final Log LOG = LogFactory.getLog(TestDAO.class);
	
	@Autowired
	private MongoClient mongoClient;
	
	public GetTagList getTagList() {
		List<String> tagList = new ArrayList<String>();
		DB tagdb = mongoClient.getDB("tagdb");
		DBCursor cursor = tagdb.getCollection("tagList").find();
		while(cursor.hasNext()){
			BasicDBObject document = (BasicDBObject)cursor.next();
			tagList.add(document.getString("tagId"));
		}
		return new GetTagList(tagList);
	}

	public static void main(String... args) {
		
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB tagdb = mongo.getDB("tagdb");
	
		DBCollection tagTable = tagdb.getCollection("tagList");
		
		BasicDBObject document = new BasicDBObject();
		document.put("tagId", "1");
		document.put("htmlTag", "<b>");
		tagTable.insert(document);
		
		DB userdb = mongo.getDB("userdb");
		DBCollection userTable = userdb.getCollection("userList");
		
		BasicDBObject user = new BasicDBObject();
		document.put("username", "rupkumar");
		document.put("handle", "@Rupkumar");
		userTable.insert(document);
	}
}
