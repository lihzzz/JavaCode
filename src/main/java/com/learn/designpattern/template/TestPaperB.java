package com.learn.designpattern.template;

public class TestPaperB extends TestPaper{
    @Override
    public String Answer1() {
        return "c";
    }

    @Override
    public String Answer2() {
        return "b";
    }

    @Override
    public String Answer3() {
        return "a";
    }
}
