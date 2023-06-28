package main.java.wolfsburg42.avajLauncher;

import main.java.wolfsburg42.avajLauncher.basic.Program;
import main.java.wolfsburg42.avajLauncher.exceptions.ScenarioFileException;

public class AvajLauncher {
    public static void main(String[] args) throws ScenarioFileException {
        if (args.length != 1)
            throw new ScenarioFileException("ScenarioFileException: There must be only 1 argument specifying the path to scenario file!");

        Program program = new Program(args[0]); // create here all initializations
        program.run();

        System.out.println("\u001B[31mFINISH!\u001B[0m");
    }
}
