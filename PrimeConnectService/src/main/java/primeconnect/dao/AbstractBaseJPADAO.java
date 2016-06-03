package primeconnect.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Named;
import javax.persistence.*;

@Named
public abstract class AbstractBaseJPADAO
{
	@PersistenceContext(unitName = "hbMysqlPU",type = PersistenceContextType.TRANSACTION)
    protected EntityManager entityManager;
	
	protected <P,E> E getUniqueResult(P primaryKey,Class<E> entityClass)
	{
		return entityManager.find(entityClass, primaryKey);
	}
	
	protected <E> E getUniqueResult(String jpql,Class<E> entityClass,Map<String,Object> paramMap)
	{
		TypedQuery<E> query = entityManager.createQuery(jpql,entityClass);
		setParameters(query,paramMap);
		
		try
		{
			return query.getSingleResult();
		}
		catch(NoResultException nre)
		{
			return null;
		}
	}
	
	protected <E> E getUniqueResult(String jpql,Class<E> entityClass,List<Object> paramList)
	{
		TypedQuery<E> query = entityManager.createQuery(jpql,entityClass);
		setParameters(query,paramList);
		
		try
		{
			return query.getSingleResult();
		}
		catch(NoResultException nre)
		{
			return null;
		}
	}

	protected <E> E getUniqueResult(String jpql,Class<E> entityClass,Object... paramArr)
	{
		TypedQuery<E> query = entityManager.createQuery(jpql,entityClass);
		setParameters(query,paramArr);

		try
		{
			return query.getSingleResult();
		}
		catch(NoResultException nre)
		{
			return null;
		}
	}

	protected List getResults(String jpql,Map<String,Object> paramMap)
	{
		Query query = entityManager.createQuery(jpql);
		setParameters(query,paramMap);

		return query.getResultList();
	}
	
	protected <E> List<E> getResults(String jpql,Class<E> entityClass,Map<String,Object> paramMap)
	{
		TypedQuery<E> query = entityManager.createQuery(jpql,entityClass);
		setParameters(query,paramMap);
		
		return query.getResultList();
	}
	
	protected <E> List<E> getResults(String jpql,Class<E> entityClass,List<Object> paramList)
	{
		TypedQuery<E> query = entityManager.createQuery(jpql,entityClass);
		setParameters(query,paramList);
		
		return query.getResultList();
	}

	protected <E> List<E> getResults(String jpql,Class<E> entityClass,Object... paramArr)
	{
		TypedQuery<E> query = entityManager.createQuery(jpql,entityClass);
		setParameters(query,paramArr);

		return query.getResultList();
	}
	
	protected void persist(Object entity)
	{
		entityManager.persist(entity);
		entityManager.flush();
	}
	
	//private utility methods

	private void setParameters(Query query,Object[] paramArr)
	{
		for( int i=1; i<=paramArr.length; i++ )
		{
			query.setParameter(i,paramArr[i-1]);
		}
	}
	
	private void setParameters(Query query,List<Object> paramList)
	{
		for( int i=1; i<=paramList.size(); i++ )
		{
			query.setParameter(i,paramList.get(i-1));
		}
	}
	
	private void setParameters(Query query,Map<String,Object> paramMap)
	{
		for( Map.Entry<String, Object> e : paramMap.entrySet() )
		{
			query.setParameter(e.getKey(), e.getValue());
		}
	}
}
