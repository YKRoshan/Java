package com.practice.day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BottomView {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer,Integer> map=new HashMap<>();

        bottomViewUtil(root,map,0,0);

        return res;
    }

    private void bottomViewUtil(Node root, Map<Integer,Integer> map, int hd, int vd) {

    }
}
