package neon.meat.program;

import neon.meat.program.parts.Anchor;
import neon.meat.program.parts.ExecutableLine;
import neon.meat.program.parts.Logic;
import neon.meat.program.parts.Variable;

public class Executable {

	private ExecutableLine[] ExecutableLines;
	private Variable[] Variables;
	private Anchor[] Anchors;
	private int position = 0;
	private int selectedVariable = 0;
	
	public Executable(ExecutableLine[] ExecutableLines, Variable[] Variables, Anchor[] Anchors) {
		this.ExecutableLines = ExecutableLines;
		this.Variables = Variables;
		this.Anchors = Anchors;
	}
	
	public void preRun() {
		for(int i = 0; i < ExecutableLines.length; i++) {
			if(ExecutableLines[i].type == 1) {
				Logic l = (Logic) ExecutableLines[i];
				l.setExecutable(this);
			}
		}
	}
	
	public void run() {
		while(position < ExecutableLines.length) {
			ExecutableLines[position].Execute();
			position++;
		}
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int newPosition) {
		position = newPosition;
	}
	
	public int getSelectedVariable() {
		return selectedVariable;
	}

	public void setSelectedVariable(int selectedVariable) {
		this.selectedVariable = selectedVariable;
	}

	public ExecutableLine[] getExecutableLines() {
		return ExecutableLines;
	}

	public Variable[] getVariables() {
		return Variables;
	}

	public Anchor[] getAnchors() {
		return Anchors;
	}
	
}
