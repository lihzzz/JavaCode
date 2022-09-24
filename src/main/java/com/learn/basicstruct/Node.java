package com.learn.basicstruct;

import java.util.LinkedList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> node;

    public Node(int val) {
        this.val = val;
        node = new LinkedList<>();
    }

    public List<Node> getNodes() {
        return this.node;
    }

    public void putNodes(Node node) {
        this.node.add(node);
    }

    /**
     * 获取
     *
     * @return val
     */
    public int getVal() {
        return this.val;
    }

    /**
     * 设置
     *
     * @param val
     */
    public void setVal(int val) {
        this.val = val;
    }

    /**
     * 获取
     *
     * @return node
     */
    public List<Node> getNode() {
        return this.node;
    }

    /**
     * 设置
     *
     * @param node
     */
    public void setNode(List<Node> node) {
        this.node = node;
    }
}
