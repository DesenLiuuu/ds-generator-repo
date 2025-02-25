package com.ds.cli.command;

import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "ds", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }


    @Override
    public void run() {
        // 不输入子命令时，给提示
        System.out.println("请输入具体命令，或者输入--help查看");
    }

    // 执行命令
    public Integer doExecute(String args[]) {
        return commandLine.execute(args);
    }
}
