package com.ds.generator;

import com.ds.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
//        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
//        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
//        configuration.setDefaultEncoding("utf-8");
//        Template template = configuration.getTemplate("MainTemplate.java.ftl");
//
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();

        /*
         *  如果不设置值的话，会报错
         * 1. 在MainTemplateConfig.outputText设置默认值
         * 2. 使用FreeMarket的默认操作符号
         * */
        mainTemplateConfig.setAuthor("Desen Liu");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("求和结果");

        // 生成
//        FileWriter fileWriter = new FileWriter("MainTemplate.java");
//        template.process(mainTemplateConfig, fileWriter);
//        fileWriter.close();

        // 使用封装方法doGenerate
        String projectPath = System.getProperty("user.dir");

        /*
        * System.out.println("文件路径分隔符: " + File.separator);
            System.out.println("文件路径分隔符 (char): " + File.separatorChar);
            System.out.println("多个路径分隔符: " + File.pathSeparator);
            System.out.println("多个路径分隔符 (char): " + File.pathSeparatorChar);
        * */

        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = "MainTemplate.java";

        doGenerate(inputPath, outputPath, mainTemplateConfig);

    }


    /*
     * 生成文件
     *
     * @params inputPath 模板文件输入路径
     * @params outputPath 输出路径
     * @params model 数据模型
     * */

    public static void doGenerate(String inputPath, String outputPath, Object model) {
        try {
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

            // 模板文件所在路径
            File templateDir = new File(inputPath).getParentFile();
            configuration.setDirectoryForTemplateLoading(templateDir);
            configuration.setDefaultEncoding("utf-8");

            // 创建模板对象，加载模板
            String templateName = new File(inputPath).getName();
            Template template = configuration.getTemplate(templateName);

            MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
            mainTemplateConfig.setAuthor("hello");
            mainTemplateConfig.setLoop(false);
            mainTemplateConfig.setOutputText("求和结果：");

            // 输出名称
            FileWriter out = new FileWriter(outputPath);

            template.process(model, out);
            out.close();

        } catch (IOException io) {
            System.out.println("IOException=" + io);
        } catch (TemplateException tepIo) {
            System.out.println("TemplateException=" + tepIo);
        }

    }
}
