package neon.meat.program.parts;

import java.io.Serializable;

public class Variable implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String value;
	
	public Variable(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
