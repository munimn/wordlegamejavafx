/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.lawrence.tilegame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Dictionary {
    private static Set<String> dictionary;
    
    
    public Dictionary(){
        this.dictionary = dictionary;
    }
    public Set<String> getSet(){
        return dictionary;
    }
    
    public static void Init() {
        dictionary = new TreeSet<String>();
        try {
            Scanner input = new Scanner(new File("words.txt"));
            while(input.hasNext()) {
                String str = input.next();
                dictionary.add(str);
            }
        } catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public String randomWord(){
        Object[] words = dictionary.toArray();
        int rand = (int) (Math.random()*words.length-1) + 0;
         String guessword = String.valueOf(words[rand]); 
        return guessword;
    }
    
   
    
}
