/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.corruptedark.ambitiousai;


import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 *
 * @author Noah
 */
public class ReadFile {
    
    private String path;
    
    public ReadFile(String file_path){
        path = file_path;
    } 
    
    public String[] openFile() throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);
        
        int numberOfLines = readLines();
        String[] textData = new String[numberOfLines];
        
        for (int i=0; i < numberOfLines; i++) {
            textData[i] = textReader.readLine();
        }
        
        textReader.close();
        return textData;
    }
    
    int readLines() throws IOException {
       
       FileReader file_to_read = new FileReader(path);
       BufferedReader bf = new BufferedReader(file_to_read);
       
       
       int numberOfLines = 0;
       
       while (bf.readLine() != null) {
               numberOfLines++; 
       }
       bf.close();
       
       return numberOfLines;
    }
    
     public String readLastLine() throws IOException{
         FileReader file_to_read = new FileReader(path);
         BufferedReader textReader = new BufferedReader(file_to_read);
         
         int numberOfLines = readLines();
         String[] textData = new String[numberOfLines];
         
         for (int i=0; i < numberOfLines; i++) {
            textData[i] = textReader.readLine();
         }
         
         String lastLine = textData[numberOfLines - 1];
         
         textReader.close();
         return lastLine;
     }
}
