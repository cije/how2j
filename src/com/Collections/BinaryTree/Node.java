package com.Collections.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author c__e
 * @date 2020/4/10 16:23
 */
public class Node {
    public Node leftNode;
    public Node rightNode;
    public Object value;

    /**
     * 插入数据
     *
     * @param v 待插入的数据
     */
    public void add(Object v) {
        // 如果当前节点没有值，就把数据放在当前节点上
        if (null == value) {
            value = v;
        } else {
            // 如果当前节点有值，就进行判断，新增值与当前值的大小关系
            if ((Integer) v - (Integer) value <= 0) {
                // 小于放左子树
                if (null == leftNode) {
                    leftNode = new Node();
                }
                leftNode.add(v);
            } else {
                // 大于放右子树
                if (null == rightNode) {
                    rightNode = new Node();
                }
                rightNode.add(v);
            }
        }
    }

    /**
     * 中序遍历
     */
    public List<Object> values() {
        List<Object> list = new ArrayList<>();
        if (null != leftNode) {
            list.addAll(leftNode.values());
        }
        list.add(value);
        if (null != rightNode) {
            list.addAll(rightNode.values());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] randoms = {67, 7, 30, 73, 10, 0, 78, 81, 10, 74};
        Node node = new Node();
        for (int random : randoms) {
            node.add(random);
        }
        System.out.println(node.values());
    }
}
