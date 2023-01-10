package me.coding.test.leetcode.easy;

import me.coding.test.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P100 {
    // https://leetcode.com/problems/same-tree/

    public static void main(String[] args) {
        var problem = new P100();

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> plist = new ArrayList<>();
        preOrder(p, plist);

        List<Integer> qlist = new ArrayList<>();
        preOrder(q, qlist);

        if(plist.size() == qlist.size()) {
            boolean isSame = true;

            for(int i=0; i<plist.size(); i++) {
                if(plist.get(i)==null && qlist.get(i)==null) {
                    continue;
                } else if(plist.get(i)==null || qlist.get(i)==null) {
                    isSame = false;
                    break;
                } else if(plist.get(i).intValue()!=qlist.get(i).intValue()) {
                    isSame = false;
                    break;
                }
            }
            return isSame;
        } else {
            return false;
        }
    }

    public void preOrder(TreeNode node, List<Integer> list) {
        if(node==null) {
            list.add(null);
            return;
        } else {
            list.add(node.val);
            preOrder(node.left, list);
            preOrder(node.right, list);
        }
    }
}
