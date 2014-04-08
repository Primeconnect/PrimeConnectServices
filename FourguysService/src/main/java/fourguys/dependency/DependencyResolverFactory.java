package fourguys.dependency;


public class DependencyResolverFactory 
{
	private DependencyResolverFactory()	{}
	
	public static IDependencyResolver getDepedencyResolver()
	{
		return SpringDependencyResolver.getInstance();
	}
}
