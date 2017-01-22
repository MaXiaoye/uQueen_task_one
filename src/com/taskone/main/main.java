package com.taskone.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) {
		// Define the Matrix of chars 
		char[][] charMatrix={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}; //Initialize given Matrix.
		BufferedReader strin=new BufferedReader(new InputStreamReader(System.in));  
		
        try {
        	while(true){
            System.out.print("Please input a String. Exit with null and Enter:\r\n");
			String inputString= strin.readLine(); //Get input from user.
			
			//If input is null then exit.
			if(inputString.length()==0)
			{
				System.out.print("Exit£¡");
				return;
			}
			boolean flag=search.initialSearch(charMatrix, inputString); 
			System.out.println(flag);
        	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

}
