package com.taskone.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		 BufferedReader strin=new BufferedReader(new InputStreamReader(System.in));  
        
         try {
        	while(true){
            System.out.print("Please input a String. Exit with null and Enter.");  
			String word= strin.readLine();
			if(word.length()==0)
			{
				 System.out.print("Exit£¡");  
				return;
			}
			boolean flag=search.exist(board, word);
			System.out.println(flag);
        	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

}
