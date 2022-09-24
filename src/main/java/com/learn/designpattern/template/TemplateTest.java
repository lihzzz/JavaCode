package com.learn.designpattern.template;

public class TemplateTest {
    public static void main(String[] args) {
        TestPaper paperA = new TestPaperA();
        paperA.question1();
        paperA.question2();
        paperA.question3();

        TestPaper paperB = new TestPaperB();
        paperB.question1();
        paperB.question2();
        paperB.question3();
    }
}
