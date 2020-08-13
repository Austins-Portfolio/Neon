package neon.main;

import neon.meat.Processor;
import neon.meat.program.Executable;
import neon.utils.FileIO;

public class Main {

	public static void main(String[] args) {
		Processor processor = new Processor(FileIO.readFile("C:\\Users\\austi\\Desktop\\Neon_Hello_World.txt"));
		Executable exe = processor.process();
		exe.preRun();
		exe.run();
	}
	
}
