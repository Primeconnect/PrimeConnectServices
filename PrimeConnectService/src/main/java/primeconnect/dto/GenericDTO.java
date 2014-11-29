package primeconnect.dto;

public class GenericDTO<T> implements IBaseDTO<T> 
{
	private T result;
	private ResultError error;

	@Override
	public T getResult() {
		return result;
	}
	
	@Override
	public void setResult(T result) {
		this.result = result;
	}

	@Override
	public boolean isSucessful() {
		if( error != null )
			return false;
		else
			return true;
	}

	@Override
	public ResultError getResultError() {
		return error;
	}

	@Override
	public void setResultError(ResultError error) {
		this.error = error;
	}

}
