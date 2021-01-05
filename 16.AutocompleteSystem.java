package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Trie{
    int times;
    Trie[] children = new Trie[27];
    boolean wordEnd;
}
class Node{
    String sentence;
    int time;
    Node(String sentence, int time){
        this.sentence = sentence;
        this.time = time;
    }
    Integer getTime(){
        return time;
    }
    String getSentence() {
        return sentence;
    }
}
public class AutocompleteSystem {
        private List<Node> suggestions = new ArrayList<>();
        private Trie root = new Trie();
        private String prefix = new String();
        int a = 0;
        public AutocompleteSystem(String[] sentences, int[] times) {
            for(int i = 0;i<times.length;i++) {
                insert(sentences[i], times[i]);
            }
        }

        public List<String> input(char c) {
            suggestions.clear();
            int count = 0;
            prefix+=c;
            prefix = preservePrefix(prefix);
            System.out.println("prefix"+" "+prefix);
            List <String> historicHot = new ArrayList<>();
            if (c == '#'){
                incrementTime(prefix);
                prefix = "";
            }
            else {
                Trie trie = root;
                for (int i = 0; i < prefix.length(); i++) {
                    int index;
                    if (prefix.charAt(i) == ' ')
                        index = 0;
                    else
                        index = prefix.charAt(i) - 'a' + 1;
                    if (trie.children[index] != null)
                        trie = trie.children[index];
                }
                search(trie, prefix);
                Comparator<Node> compareTimes = Comparator.comparing(Node::getTime).reversed().thenComparing(Node::getSentence);
                suggestions.sort(compareTimes);
                if(suggestions.size()==0)
                    return historicHot;
                for(Node n: suggestions){
                    System.out.println(n.sentence+" "+n.time);
                }
                System.out.println();
                while (count < 3) {
                    historicHot.add(suggestions.get(count).sentence);
                    if (count == suggestions.size() - 1)
                        break;
                    count++;
                }
            }
            return historicHot;
        }

        private void insert(String sentence, int time)
        {
            Trie trie = root;
            int index;
            for(int i = 0;i<sentence.length();i++)
            {
                if(sentence.charAt(i)==' ')
                    index = 0;
                else
                    index = sentence.charAt(i)-'a'+1;

                if(trie.children[index]==null)
                    trie.children[index] = new Trie();

                trie = trie.children[index];
            }
            trie.wordEnd = true;
            trie.times = time;
        }

        private boolean isPrefix(String prefix)
        {
            prefix = preservePrefix(prefix);
            Trie trie = root;
            int index;
            for(int i = 0;i<prefix.length();i++)
            {
                if(prefix.charAt(i)==' ')
                    index = 0;
                else
                    index = prefix.charAt(i)-'a'+1;
                if(trie.children[index]==null)
                    return false;
                trie = trie.children[index];
            }
            return true;
        }
        private void search(Trie trie, String prefix)
        {
            if(!isPrefix(prefix))
                return;
            prefix = preservePrefix(prefix);
            char c;
            int in;
            for(int i = 0;i<trie.children.length;i++)
            {
                if(trie.children[i]!=null)
                {
                    if(i==0)
                        c = ' ';
                    else{
                        in = 'a'+i-1;
                        c = (char)in;
                    }
                    search(trie.children[i], prefix+c);
                }
            }
            if(trie.times>0)
                suggestions.add(new Node(prefix, trie.times));
        }

        private String preservePrefix(String prefix)
        {
            return prefix.charAt(prefix.length()-1)=='#'?prefix.substring(0, prefix.length()-1):prefix;
        }
        private void incrementTime(String sentence)
        {
            if(!isPrefix(sentence))
                insert(sentence, 1);
            else {
                Trie trie = root;
                int index;
                for (int i = 0; i < sentence.length(); i++) {
                    if (sentence.charAt(i) == ' ')
                        index = 0;
                    else
                        index = sentence.charAt(i) - 'a' + 1;
                    if (trie.children[index] != null)
                        trie = trie.children[index];
                }

                trie.times+=1;
            }
        }
}
