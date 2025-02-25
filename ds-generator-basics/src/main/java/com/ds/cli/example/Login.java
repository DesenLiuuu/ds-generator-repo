package com.ds.cli.example;

import picocli.CommandLine;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

public class Login implements Callable<Integer> {
    @Option(names = {"-u", "--user"}, description = "User name")
    String user;


    // 可选交互式
    @Option(names = {"-p", "--password"}, arity = "0..1", description = "Passphrase", interactive = true, echo = false, prompt = "请输入密码")
    String password;

    @Option(names = {"-cp", "--checkPassword"}, description = "checkPassword", interactive = true, prompt = "请输入确认密码")
    String checkPassword;

    @Option(names = {"--interactive"}, interactive = true)
    String value;


    public Integer call() throws Exception {
        System.out.println("password = " + password);
        if (password.equals(checkPassword)) {
            System.out.println("两次密码输入一致");
        } else {
            System.out.println("两次密码输入不一致");
        }

        return 0;
    }

    public static void main(String[] args) {
//        new CommandLine(new Login()).execute("-u", "user123", "-p", "123", "-cp");

        // 强制交互式 （不在命令中输入-p,属性的值将为null）
        new CommandLine(new Login()).execute("-u", "user123");
    }
}
