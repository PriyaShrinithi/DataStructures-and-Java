package com.company;

import java.util.HashMap;
import java.util.Stack;

public class IntegerToEnglish
{
    private HashMap <Integer, String> places;
    private HashMap<Integer, String> batches;
    private HashMap<Integer, String> ones;
    private HashMap <Integer, String> twoDigits;

    public String numberToWords(int num) {

        if(num==0)
            return "Zero";
        Stack <Integer> number = new Stack<>();
        //maybe use a stack
        int digits = count(num);
        int start = (digits -1)/3+1;
        digits = Math.abs(digits - 3*(start-1));
        places = places();
        batches = batches();
        ones = ones();
        twoDigits = twoDigits();

        makeStack(number, num);
        return intToEng(number, "", digits, start, -1);
    }
    private String intToEng(Stack <Integer> number, String english, int place, int batch, int prev){
        if(number.empty())
            return english.substring(0, english.length()-1);
        int p = 0;
        int n = 0;
        int r = 0;
        n = number.pop();
        if(places.get(place)=="One" && !ones.containsKey(n)){
            int i = english.lastIndexOf(" ", english.length()-2);
            String e = "";
            if(i!=-1)
                e = english.substring(i).trim();
            if(batches.get(batch)!="One" && !batches.containsValue(e)){ //and previous number is not 0;
                english+=batches.get(batch)+" ";
            }
        }
        else if(places.get(place)=="Ten" && n>1){
            n*=10;
            english+=twoDigits.get(n)+" ";
        }
        else if(places.get(place)=="Ten" && n==1){
            place--;
            n *= 10;
            n += number.pop();
            r = n%10;
            n/=10;
            n*=10;
            n+=r;
            english+=twoDigits.get(n)+" ";
            if(batches.get(batch)!="One")
                english+=batches.get(batch)+" ";
        }
        else if(places.get(place)=="One"){
            english+=ones.get(n)+" ";
            if(batches.get(batch)!="One")
                english+=batches.get(batch)+" ";
        }
        else{
            if(ones.containsKey(n))
                english +=ones.get(n)+" "+places.get(place)+" ";
        }
        if(place==1){
            place=4;
            batch-=1;
        }
        return intToEng(number, english, place-1, batch, n);
    }

    private int count(int n){
        return (int) Math.log10(n)+1;
    }
    private HashMap <Integer, String> batches(){
        return new HashMap <Integer, String> () {{
            put(1, "One");
            put(2, "Thousand");
            put(3, "Million");
            put(4, "Billion");
        }};
    }

    private HashMap <Integer, String> places(){
        return new HashMap <Integer, String> () {{
            put(1, "One");
            put(2, "Ten");
            put(3, "Hundred");
        }};
    }
    private HashMap <Integer, String> ones(){
        return new HashMap <Integer, String> () {{
            put(1, "One");
            put(2, "Two");
            put(3, "Three");
            put(4, "Four");
            put(5, "Five");
            put(6, "Six");
            put(7, "Seven");
            put(8, "Eight");
            put(9, "Nine");
        }};
    }
    private HashMap<Integer, String> twoDigits(){
        return new HashMap<Integer, String>() {{
            put(10, "Ten");
            put(11, "Eleven");
            put(12, "Twelve");
            put(13, "Thirteen");
            put(14, "Fourteen");
            put(15, "Fifteen");
            put(16, "Sixteen");
            put(17, "Seventeen");
            put(18, "Eighteen");
            put(19, "Nineteen");
            put(20, "Twenty");
            put(30, "Thirty");
            put(40, "Forty");
            put(50, "Fifty");
            put(60, "Sixty");
            put(70, "Seventy");
            put(80, "Eighty");
            put(90, "Ninety");
        }};
    }
    private void makeStack(Stack<Integer> s, int n){
        int r = 0;
        while(n!=0){
            r = n%10;
            s.push(r);
            n/=10;
        }
    }
}
