package com.example.eventbus.annoationtest;

public class AnnotationTest {
    @TestField(min = 6, max = 10, description = "用户名长度在6-10个字符之间")
    private String name;

    @TestField(min = 6, max = 10, description = "密码长度在6-10个字符之间")
    private String pasdword;

    private int joke;

    @TestMethod(type = 1,name = "这是getName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasdword() {
        return pasdword;
    }

    public void setPasdword(String pasdword) {
        this.pasdword = pasdword;
    }

}
