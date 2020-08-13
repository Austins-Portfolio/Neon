package neon.meat;

import java.util.ArrayList;

import neon.meat.program.Executable;
import neon.meat.program.parts.Anchor;
import neon.meat.program.parts.ExecutableLine;
import neon.meat.program.parts.Logic;
import neon.meat.program.parts.Variable;

public class Processor {

	private String source;
	private String[] commands;
	
	public Processor(String source) {
		this.source = source;
	}
	
	public Executable process() {
		splitSource();
		return buildExecutable();
	}
	
	private void splitSource() {
		commands = source.split(";");
	}
	
	private Executable buildExecutable() {
		
		ArrayList<ExecutableLine> ExecutableLines = new ArrayList<ExecutableLine>();
		ArrayList<Variable> Variables = new ArrayList<Variable>();
		ArrayList<Anchor> Anchors = new ArrayList<Anchor>();
		
		for(int i = 0; i < commands.length; i++) {
			//System.out.println(commands[i]+";");
			
			if(commands[i].startsWith("dec")) {
				String parts[] = commands[i].split(" ",2);
				String parts2[] = parts[1].split(",");
				parts2[1] = parts2[1].replace("\"", "");
				parts2[1] = parts2[1].trim();
				Variables.add(new Variable(parts2[0], parts2[1]));
				Logic logic = new Logic() {

					@Override
					public void Execute() {
						// TODO Auto-generated method stub
						
					}
					
				};
				ExecutableLines.add(logic);
			}
			
			if(commands[i].startsWith("anc")) {
				String parts[] = commands[i].split(" ");
				Anchor a = new Anchor(parts[1],i);
				Anchors.add(a);
				ExecutableLines.add(a);
			}
			
			if(commands[i].startsWith("jmp")) {
				String parts[] = commands[i].split(" ");
				Logic logic = new Logic() {
					@Override
					public void Execute() {
						// TODO Auto-generated method stub
						Anchor[] anchors = this.getExecutable().getAnchors();
						for(int x = 0; x < anchors.length; x++) {
							if(anchors[x].getAnchorName().contentEquals(parts[1])) {
								this.getExecutable().setPosition(anchors[x].getPosition());
							}
						}
					}
					
				};
				ExecutableLines.add(logic);
			}
			
			if(commands[i].startsWith("prt")) {
				String parts[] = commands[i].split(" ");
				Logic logic = new Logic() {
					@Override
					public void Execute() {
						Variable[] variables = this.getExecutable().getVariables();
						for(int x = 0; x < variables.length; x++) {
							if(variables[x].getName().contentEquals(parts[1])) {
								System.out.println(variables[x].getValue());
							}
						}
					}
					
				};
				ExecutableLines.add(logic);
			}
			
			if(commands[i].startsWith("dst")) {
				String parts[] = commands[i].split(" ");
				Logic logic = new Logic() {
					@Override
					public void Execute() {
						Variable[] variables = this.getExecutable().getVariables();
						for(int x = 0; x < variables.length; x++) {
							if(variables[x].getName().contentEquals(parts[1])) {
								this.getExecutable().setSelectedVariable(x);
							}
						}
					}
					
				};
				ExecutableLines.add(logic);
			}
			
		}
		
		ExecutableLine[] el = new ExecutableLine[ExecutableLines.size()];
		Variable[] vs = new Variable[Variables.size()];
		Anchor[] as = new Anchor[Anchors.size()];
		
		for(int i = 0; i < el.length; i++) {
			el[i] = ExecutableLines.get(i);
		}
		for(int i = 0; i < vs.length; i++) {
			vs[i] = Variables.get(i);
		}
		for(int i = 0; i < as.length; i++) {
			as[i] = Anchors.get(i);
		}
		
		Executable exe = new Executable(el, vs, as);
		
		return exe;
	}
	
}
