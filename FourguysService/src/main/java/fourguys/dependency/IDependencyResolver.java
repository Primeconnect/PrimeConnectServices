package fourguys.dependency;

public interface IDependencyResolver 
{
	public <T> T getDependentObject(String name, Class<T> interfaceClass);
	public <T> T getDependentObject(Class<T> interfaceClass);
	public Object getDependentObject(String name);
}

