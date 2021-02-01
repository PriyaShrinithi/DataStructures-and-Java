package com.company;

public class WildcardMatchingDP{
    public boolean isMatch(String s, String p) {
        return wildCard(s, p);
    }
    private boolean wildCard(String s, String p){
        boolean [][] dpMatrix = new boolean[p.length()+1][s.length()+1];

        dpMatrix[0][0] = true;//first is considered empty

        for(int i=1;i<s.length()+1;i++){
            dpMatrix[0][i] = false;
        }

        for(int i=1;i<p.length()+1;i++){
            if(p.charAt(i-1)=='*')
                dpMatrix[i][0] = dpMatrix[i-1][0];
            else
                dpMatrix[i][0] = false;

            for(int j = 1;j<s.length()+1;j++){
                if(s.charAt(j-1)==p.charAt(i-1)||p.charAt(i-1)=='?')
                    dpMatrix[i][j] = dpMatrix[i-1][j-1];
                else if(p.charAt(i-1)=='*')
                    dpMatrix[i][j] = dpMatrix[i][j-1] || dpMatrix[i-1][j];
                else
                    dpMatrix[i][j] = false;
            }
        }

        return dpMatrix[p.length()][s.length()];
    }
}