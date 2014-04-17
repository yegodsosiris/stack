package com.stack.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Repository;

import com.stack.domain.BaseMongoEntity;

@Repository
public abstract class BaseMongoRepositoryImpl 
{
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	protected MongoTemplate mongoTemplate;
	
	//@LogExecTime
	public <T> T getByKeyValue(Class<T> t, final String key, final Object value)
	{
		return  mongoTemplate.findOne(query(where(key).is(value)), t);
	}
	
	/**
	 * 
	 * Obtains a single object using a Json query i.e. { key1 : 'key1Value', key2 : 'key2Value' }
	 * 
	 * @param query
	 * @return
	 */
	protected <T> T getByJsonQuery(Class<T> clazz,String query) {
		BasicQuery query1 = new BasicQuery(query);
		return mongoTemplate.findOne(query1, clazz);
	}
	
	/**
	 * 
	 * Obtains a single object using a Json query i.e. { key1 : 'key1Value', key2 : 'key2Value' }
	 * 
	 * @param query
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T> T listByJsonQuery(Class<T> clazz,String query) {
		BasicQuery query1 = new BasicQuery(query);
		List<T> find = mongoTemplate.find(query1, clazz);
		return (T) find;
	}
	
	@SuppressWarnings("unchecked")	
	//@LogExecTime
	public <T> T listByKeyValue(Class<T> t, final String key, final Object value)
	{
		return (T) mongoTemplate.find(query(where(key).is(value)), t);
	}


	private void save(BaseMongoEntity domainObject)
	{
		domainObject.setCreated(DateTime.now().toDate());
		mongoTemplate.insert(domainObject);
	}


	public void delete(BaseMongoEntity domainObject)
	{
		mongoTemplate.remove(domainObject);
	}


	public void findAndDelete(Class<?> clazz, String id)
	{
		Object findById = mongoTemplate.findById(id, clazz);
		mongoTemplate.remove(findById);
	}
	
	public <T> List<T> list(Class<T> clazz)  {
		List<T> findAll = mongoTemplate.findAll(clazz);
		return findAll;
	}

	public void saveOrUpdate(BaseMongoEntity domainObject)
	{
		if ("".equals(domainObject.getId())) {
			domainObject.setId(null);
		}
		if (domainObject.getId()==null) {
			domainObject.setCreated(DateTime.now().toDate());
			save(domainObject);
		}
		else {
			domainObject.setUpdated(DateTime.now().toDate());
			update(domainObject);
		}
	}


	public <T> T load(Class<T> clazz, String id)
	{
		return mongoTemplate.findById(id, clazz);
	}
	
	//@LogExecTime
	public BaseMongoEntity getByEmbeddedDocumentId(Class<? extends BaseMongoEntity> clazz, String documentQuery, String id)
	{
		return getByKeyValue(clazz, documentQuery+".$id", new ObjectId(id));
	}
	
	//@LogExecTime
	public BaseMongoEntity listByEmbeddedDocumentId(Class<? extends BaseMongoEntity> clazz, String documentQuery, String id)
	{
		return listByKeyValue(clazz, documentQuery+".$id", new ObjectId(id));
	}
		
	//@LogExecTime
	public BaseMongoEntity get(Class<? extends BaseMongoEntity> clazz, String id)
	{
		return mongoTemplate.findById(id, clazz);
	}
	
	public void update(BaseMongoEntity domainObject)
	{
		mongoTemplate.save(domainObject);
	}

	protected <T> T getSingle(Class<T> clazz) {
		List<T> list = list(clazz);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}
