package neon.meat.program.parts;

import java.io.Serializable;

public abstract class ExecutableLine implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public byte type;
	
	public abstract void Execute();

}
