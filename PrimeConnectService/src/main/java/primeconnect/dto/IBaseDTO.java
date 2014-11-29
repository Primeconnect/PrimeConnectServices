package primeconnect.dto;

public interface IBaseDTO<T> 
{
	public T getResult();
	public void setResult(T result);
	
	public boolean isSucessful();
	
	public ResultError getResultError();
	public void setResultError(ResultError error);
}
