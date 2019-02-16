package spring.restapp.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Response<T> implements Serializable {

	private static final long serialVersionUID = 6985698781231538558L;

	private T data;
	private List<String> errors;

	public Response() {
	}

	public Response(T data) {
		this.data = data;
	}

	public Response(T data, List<String> errors, List<String> warnings) {
		this.data = data;
		this.errors = errors;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<>();
		}
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
