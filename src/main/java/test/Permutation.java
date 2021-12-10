package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Permutation {
public static void main(String[] args){
    Solution solution=new Solution();
    int[] n={1,2,3,4};
    solution.permute(n);
}
}
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list =new ArrayList<>();
        return permuteUtil(nums,0,nums.length-1,list);
    }
    public List<List<Integer>> permuteUtil(int[] nums,int l,int r,List<List<Integer>> list){
        if(r==l){
            List<Integer> l1=new ArrayList<>();
            for(int i:nums){
                l1.add(i);
            }
            list.add(l1);
            System.out.println(l1);
            return list;
        }
        else
            for(int i=l;i<=r;i++){
                swap(nums,l,i);
                permuteUtil(nums,l+1,r,list);
                swap(nums,l,i);
            }
        return list;
    }
    public void swap(int[] nums, int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}