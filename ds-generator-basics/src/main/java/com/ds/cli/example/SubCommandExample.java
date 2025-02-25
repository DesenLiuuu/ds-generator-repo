package com.ds.cli.example;


import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "main", mixinStandardHelpOptions = true)
public class SubCommandExample implements Runnable {

    @Override
    public void run() {
        System.out.println("执行主命令");

    }

    @Command(name = "add", mixinStandardHelpOptions = true)
    static class AddCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("执行添加命令");
        }
    }

    @Command(name = "delete", mixinStandardHelpOptions = true)
    static class DeleteCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("执行删除命令");
        }
    }

    @Command(name = "query", mixinStandardHelpOptions = true)
    static class QueryCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("执行查询命令");
        }
    }

    public static void main(String[] args) {
        // 执行主命令
//        String[] myArgs = new String[]{};

        // 执行主命令的帮助
//        String[] myArgs = new String[]{"--help"};

        // 执行添加命令
//        String[] myArgs = new String[] {"add"};

        // 执行查询命令
        String[] myArgs = new String[]{"query"};

        CommandLine commandLine = new CommandLine(new SubCommandExample());
        int execute = commandLine.addSubcommand(new AddCommand()).addSubcommand(new DeleteCommand()).addSubcommand(new QueryCommand()).execute(myArgs);
        System.exit(execute);

        /*
        * 参数分组
        * 错误出来
        * 颜色高亮
        * */
    }
}
