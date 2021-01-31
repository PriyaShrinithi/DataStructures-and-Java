package com.company;

import java.util.ArrayList;
import java.util.List;

class TotalQueens {
    int count = 0;
    public int totalNQueens(int n) {
        List<List<Integer>> colSet = new ArrayList<>();
        columnSet(colSet, n);
        return count;
    }
    private void totalQueens(List<Integer> col, int n, int row){
        if(row == n){
            if(col.size()==n)
                count++;
            return;
        }
        else{
            for(int i = 0;i<n;i++){
                col.add(i);
                if(isValid(col))
                    totalQueens(col, n, row+1);
                col.remove(col.size()-1);
            }
        }
    }
    private void columnSet(List<List<Integer>> colSet, int n){
        for(int i = 0;i<n;i++){
            List <Integer> col = new ArrayList<>();
            col.add(i);
            colSet.add(col);
            totalQueens(col, n, 1);
        }
    }
    private boolean isValid(List<Integer> col){
        int r = col.size()-1;
        int c = col.get(r);

        for(int i = 0;i<r;i++){
            int d = Math.abs(col.get(i)-c);
            if(d==0||d==Math.abs(i-r))
                return false;
        }
        return true;
    }
}