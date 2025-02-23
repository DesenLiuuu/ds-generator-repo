package com.ds.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class StaticGenerator {
    public static void main(String[] args) {
        /*
         * 1. 复制文件
         * Files.copy(src.toPath(), desc.toPath(), optionList.toArray(new CopyOption[0]));
         * 2. 创建多级目录 （即使中间有目录不存在）
         * File dest; dest.mkdirs()
         * 3. 判断是否为目录
         * File dest; dest.isDirectory()
         * 4. 判断文件/文件夹是否存在
         * File dest; dest.exists()
         * */

        // 获取整个项目的根目录
        String projectPath = System.getProperty("user.dir");
        // 获取目录的父目录
        File parentFile = new File(projectPath).getParentFile();
        // 获取输入路径
        String inputPath = new File(parentFile, "ds-generator-repo/ds-generator-demo-projects/acm-template").getAbsolutePath();
        // 输出路径
        String outputPath = projectPath;
//        copyFilesByHutool(inputPath, outputPath);
        copyFilesByRecursive(inputPath, outputPath);
    }

    public static void copyFilesByHutool(String inputPath, String outputPath) {
        /*
         * inputPath 和 outputPath 均为目录, 为拷贝
         * inputPath 和 outputPath 均为文件的话 直接复制，名字为 outputPath
         * inputPath 为文件，outputPath 为目录， 将前者拷贝到后者目录下
         * isOverride 是否覆盖目标文件
         * */
        FileUtil.copy(inputPath, outputPath, false);
    }


    @SuppressWarnings({"all"})
    public static void copyFilesByRecursive(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        try {
            copyFileByRecursive(inputFile, outputFile);
        } catch (Exception e) {
            System.out.println("文件复制失败");
            e.printStackTrace();
        }
    }


    /*
     * 递归： 先创建目录，然后遍历目录内的文件，依次复制
     * */
    private static void copyFileByRecursive(File inputFile, File outputFile) throws IOException {
        // 区分是文件还是目录
        if (inputFile.isDirectory()) {
            File destOutputFile = new File(outputFile, inputFile.getName());
            // 当outputFile为目录的时候，destOutputFile返回路径为outputFile，名字为inputFile的全路径
            if (!destOutputFile.exists()) {
                destOutputFile.mkdirs();
            }

            // 获取目录下的所有文件和子目录
            File[] files = inputFile.listFiles();
            // 无子文件， 结束
            if (ArrayUtil.isEmpty(files)) {
                return;
            }

            for (File file : files) {
                copyFileByRecursive(file, destOutputFile);
            }
        } else {
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
