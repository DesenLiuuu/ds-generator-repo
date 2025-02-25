package com.ds;

import com.ds.cli.command.CommandExecutor;
import com.ds.generator.StaticGenerator;

import java.io.File;

public class Main {
    public static void main(String[] args) {
//        args = new String[]{"--help"};
        args = new String[]{"generate", "-l", "-a", "-o"};
//        args = new String[]{"config"};
//        args = new String[]{"list"};

        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}