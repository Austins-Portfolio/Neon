package neon.main;

import neon.meat.Processor;
import neon.meat.program.Executable;
import neon.utils.FileIO;

public class Main {

	public static void main(String[] args) {
		if(args.length>-1) {
			String filePath = args[0];
			if(filePath.contains(".nsf")) {
				Processor processor = new Processor(FileIO.readFileSource(args[0]));
				Executable exe = processor.process();
				FileIO.writeFileExecutable(filePath, exe);
			}else if(filePath.contains(".neon")) {
				Executable exe = FileIO.readFileExecutable(filePath);
				exe.preRun();
				Thread program = new Thread(exe);
				program.start();
			}
		}
	}
	
}
