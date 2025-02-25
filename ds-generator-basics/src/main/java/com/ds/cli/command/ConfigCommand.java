package com.ds.cli.command;

/*
 * 输出允许用户传入的动态参数信息
 * */

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ReflectUtil;
import com.ds.model.MainTemplateConfig;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;

@Command(name = "config", description = "查看参数列表", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {
    @Override
    public void run() {
        // 查看参数信息
        System.out.println("查看参数信息");
        // 使用jdk方法
//        Class<?> myClass = MainTemplateConfig.class;
//        Field[] fileds = myClass.getDeclaredFields();


        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段名称" + field.getName());
            System.out.println("字段类型" + field.getType());
            System.out.println("===");
        }
    }
}
