package neon.meat.program.parts;

import neon.meat.program.Executable;

public abstract class Logic extends ExecutableLine{

	private Executable executable;
	
	public Logic() {
		type = 1;
	}

	public Executable getExecutable() {
		return executable;
	}

	public void setExecutable(Executable executable) {
		this.executable = executable;
	}
	
}
