package com.ds.model;

/*
 *  动态模板配置
 * */

import lombok.Data;

@Data
public class MainTemplateConfig {
    /*
     * 是否生成循环
     * */
    private boolean loop;

    /*
     * 作者注释
     * */
    private String author;

    /*
     * 输出信息
     * */
    private String outputText = "sum =";

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOutputText() {
        return outputText;
    }

    public void setOutputText(String outputText) {
        this.outputText = outputText;
    }
}
