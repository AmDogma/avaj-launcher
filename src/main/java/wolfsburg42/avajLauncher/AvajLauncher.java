package main.java.wolfsburg42.avajLauncher;

import main.java.wolfsburg42.avajLauncher.basic.Program;
import main.java.wolfsburg42.avajLauncher.exceptions.ScenarioFileException;

public class AvajLauncher {
    public static void main(String[] args) throws ScenarioFileException {
        if (args.length != 1)
            throw new ScenarioFileException("There must be only 1 argument specifying the path to scenario file!");
        Program program = new Program(args[0]);
        program.run();
    }
}
