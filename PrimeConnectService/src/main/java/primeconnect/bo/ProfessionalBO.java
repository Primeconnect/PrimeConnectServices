package primeconnect.bo;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import primeconnect.dao.IProfessionalDAO;
import primeconnect.jb.Professional;

@Named
public class ProfessionalBO implements IProfessionalBO 
{
	@Inject
	@NotNull
	private IProfessionalDAO profDAO;
	
	public List<Professional> getProfessional(String email) 
	{
		return profDAO.getProfessionalData(email);
	}
	
	public void save()
	{
		
	}
}
