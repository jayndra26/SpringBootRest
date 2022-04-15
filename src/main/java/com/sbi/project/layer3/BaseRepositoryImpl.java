package com.sbi.project.layer3;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
//LocalContainerEntityManagerFactoryBean DriverManagerDataSource - 4
@Repository
public class BaseRepositoryImpl implements BaseRepository {
	@PersistenceContext
	EntityManager entityManager;
	
	public BaseRepositoryImpl() {		System.out.println("BaseDAOImpl().....");	}
	public void persist(Object obj) { entityManager.persist(obj);	}
	public void merge(Object obj) {	entityManager.merge(obj);	}
	public void remove(Object obj) { entityManager.remove(obj); }
	public <AnyType> AnyType find(Class<AnyType> className, Serializable primaryKey ) { //user defined function
				AnyType e = entityManager.find(className,primaryKey);
				return e;
	} 
	public <AnyType> List<AnyType> findAll(String entityName) { //user defined function
			Query query = entityManager.createQuery("from "+entityName);
			return query.getResultList();
	}
}
