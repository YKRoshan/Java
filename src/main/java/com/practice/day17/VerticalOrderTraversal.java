package com.practice.day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    static class Tuple implements Comparable<Tuple> {
        int data;
        int hd;
        int vd;

        public Tuple(int data, int hd, int vd) {
            this.data = data;
            this.hd = hd;
            this.vd = vd;
        }

        @Override
        public int compareTo(Tuple tuple) {
            if (hd == tuple.hd && vd == tuple.vd) {
                return data - tuple.data;
            } else if (hd == tuple.hd && vd != tuple.vd) {
                return vd - tuple.vd;
            }
            return hd - tuple.hd;
        }
    }

    public List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        Map<Integer, List<Tuple>> map = new TreeMap<>();
        verticalTraversalUtil(root, map, 0, 0);

        map.forEach((k, v) -> {
            List<Integer> list = new ArrayList<>();
            Collections.sort(v);
            v.forEach(tuple -> list.add(tuple.data));
            res.add(list);
        });
        return res;
    }

    private void verticalTraversalUtil(Node root, Map<Integer, List<Tuple>> map, int hd, int vd) {
        if (map.containsKey(hd)) {
            List<Tuple> list = map.get(hd);
            list.add(new Tuple(root.data, hd, vd));
        } else {
            List<Tuple> list = new ArrayList<>();
            list.add(new Tuple(root.data, hd, vd));
            map.put(hd, list);
        }
        if (root.left != null)
            verticalTraversalUtil(root.left, map, hd - 1, vd + 1);
        if (root.right != null)
            verticalTraversalUtil(root.right, map, hd + 1, vd + 1);
    }

    public static void main(String[] args) {
        List<Tuple> list = new ArrayList<>();
        list.add(new Tuple(1, 0, 0));
        list.add(new Tuple(3, 1, 0));
        list.add(new Tuple(2, 1, 0));
        list.add(new Tuple(0, 0, 0));
        Collections.sort(list);
        list.forEach(tuple -> System.out.println(tuple.data));
    }
}
