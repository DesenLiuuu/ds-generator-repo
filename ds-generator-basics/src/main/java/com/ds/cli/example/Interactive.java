package com.ds.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.lang.reflect.Field;

@Command
public class Interactive implements Runnable {
    // 如果用户使用强制交互式，必须输入某个选项，而不能使用默认的控制， 可以通过System.console().readLine等方式提示用户输入
    @Option(names = "--interactive", interactive = true)
    String value;

    public static void main(String[] args) {

        new CommandLine(new Interactive()).execute("--interactive");
    }

    public void run() {
        if (System.console() == null) {
            // 主动提示用户输入
            value = System.console().readLine("Enter value for --interactive: ");
        }
        System.out.println("You provided value '" + value + "'");
    }


}
