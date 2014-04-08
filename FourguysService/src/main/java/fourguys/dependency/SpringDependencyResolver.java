package fourguys.dependency;

import org.springframework.context.support.ClassPathXmlApplicationContext;

class SpringDependencyResolver implements IDependencyResolver 
{
	private static final String SPRING_CONFIG_XML_FILENAME = "spring-module.xml";
	private ClassPathXmlApplicationContext ctx;
	
	private SpringDependencyResolver()
	{
		ctx = new ClassPathXmlApplicationContext(SPRING_CONFIG_XML_FILENAME);
	}
	
	private static class SpringDependencyResolverInstanceHolder {
		public static final SpringDependencyResolver INSTANCE = new SpringDependencyResolver();
	}
	
	static SpringDependencyResolver getInstance()
	{
		return SpringDependencyResolverInstanceHolder.INSTANCE;
	}
	
	//methods
	public <T> T getDependentObject(String name, Class<T> interfaceClass)
	{
		return ctx.getBean(name, interfaceClass);
	}
	
	public <T> T getDependentObject(Class<T> interfaceClass)
	{
		return ctx.getBean(interfaceClass);
	}
	
	public Object getDependentObject(String name)
	{
		return ctx.getBean(name);
	}

}
