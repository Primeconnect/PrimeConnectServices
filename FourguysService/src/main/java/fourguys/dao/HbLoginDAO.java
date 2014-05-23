package fourguys.dao;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import fourguys.dto.Profile;

@Named
public class HbLoginDAO implements ILoginDAO
{
	@PersistenceContext(unitName = "hbMysqlPU",type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;
	
	public Profile getProfileData(final String email)
	{
		return entityManager.find(Profile.class, email);
	}
}
