package com.learn.designpattern.template;

/**
 * 模板方法将不变的行为放入父类中，去除子类中的重复代码
 */
public abstract class TestPaper {

    public void question1(){
        System.out.println("aaaaaaaaaaaaaaaaaaa");
        System.out.println("答案: " + Answer1());
    }

    public void question2(){
        System.out.println("bbbbbbbbbbbbbbbbbb");
        System.out.println("答案: " + Answer2());
    }

    public void question3(){
        System.out.println("ccccccccccccccccc");
        System.out.println("答案: " + Answer3());
    }

    public abstract String Answer1();
    public abstract String Answer2();
    public abstract String Answer3();
}
