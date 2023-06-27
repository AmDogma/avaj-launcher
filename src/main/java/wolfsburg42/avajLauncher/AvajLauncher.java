package main.java.wolfsburg42.avajLauncher;

import main.java.wolfsburg42.avajLauncher.basic.Program;

public class AvajLauncher {
    public static void main(String[] args) throws Exception {
        if (args.length != 1)
            throw new Exception("Exception caught: There must be only 1 argument specifying the path to scenario txt file!");
        // try {
            Program program = new Program();
            program.run(args[0]);
        // } catch (Exception e) {
        //     System.out.println("Exception caught: " + e.getMessage());
        // }
        System.out.println("\u001B[31mFINISH!\u001B[0m");
    }
}
