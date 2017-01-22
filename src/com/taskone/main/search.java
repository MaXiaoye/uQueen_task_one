package com.taskone.main;

//Search if the word exists in provided Matrix

public class search {

static boolean searchInMatrix(char[][] charMatrix, int i,int j,String inputString,boolean[][] shadowFlag){  
        if (inputString.length()==0){return true;} // The last char in input is found. Return true.  
        else{  
        	
        	//If the left char in Matrix equals to the target. 
            if ((i>0)&&(charMatrix[i-1][j]==inputString.charAt(0))&&(shadowFlag[i-1][j]==false)){
            	
            	//The char in Matrix is searched. Can't be searched again.
            	shadowFlag[i-1][j]=true;
            	
            	//Do recursive search if the left char meets the target.
                if (searchInMatrix(charMatrix,i-1,j,inputString.substring(1),shadowFlag)){  
                    return true;  
                }  
                
                //Clear the flag of left char if the whole word cannot be found in recursive search started from left char. 
                shadowFlag[i-1][j]=false;  
            }
            
            //If the right char in Matrix equals to the target. 
            if ((i<charMatrix.length-1)&&(charMatrix[i+1][j]==inputString.charAt(0))&&(shadowFlag[i+1][j]==false)){  
            	shadowFlag[i+1][j]=true;  
                if (searchInMatrix(charMatrix,i+1,j,inputString.substring(1),shadowFlag)){  
                    return true;  
                }  
                shadowFlag[i+1][j]=false;  
            }  
            
            //If the upper char in Matrix equals to the target. 
            if ((j>0)&&(charMatrix[i][j-1]==inputString.charAt(0))&&(shadowFlag[i][j-1]==false)){  
            	shadowFlag[i][j-1]=true;  
                if (searchInMatrix(charMatrix,i,j-1,inputString.substring(1),shadowFlag)){  
                    return true;  
                }  
                shadowFlag[i][j-1]=false;  
            }  
            
            //If the lower char in Matrix equals to the target.
            if ((j<charMatrix[0].length-1)&&(charMatrix[i][j+1]==inputString.charAt(0))&&(shadowFlag[i][j+1]==false)){  
            	shadowFlag[i][j+1]=true;  
                if (searchInMatrix(charMatrix,i,j+1,inputString.substring(1),shadowFlag)){  
                    return true;  
                }  
                shadowFlag[i][j+1]=false;  
            }  
        }
        
        //All chars around do not meet target. Return false
        return false;  
    }  
   
static  boolean initialSearch(char[][] charMatrix, String inputString) {  
        
        if (inputString.length()==0) {return false;} //Can be removed. We can judge if input in null in main()  
        
        //Initialize shadownFlag Matrix. 
        //Search the first char in Matrix.
        for (int i=0;i<charMatrix.length;i++){  
            for (int j=0;j<charMatrix[0].length;j++){  
                if (inputString.charAt(0)==charMatrix[i][j]){  
                    if (inputString.length()==1) {return true;}  //Can be removed. If input contains only one char and can be found in grid. Then return true directly. 
                    else{  
                       boolean[][] shadowFlag=new boolean[charMatrix.length][charMatrix[0].length];
                       for (int x=shadowFlag.length-1;x>=0;x--)
                       {
                    	   for(int y=shadowFlag[0].length-1;y>=0;y--)
                    	   {
                    		   shadowFlag[x][y]=new Boolean(false); //Initialize all flags as false.
                    	   }
                       }
                       shadowFlag[i][j]=true;  //Change the flag boolean where the first letter was found.
                        if (searchInMatrix(charMatrix,i,j,inputString.substring(1),shadowFlag)){  //Continue search other letters in Matrix.
                            return true;  
                        }  
                    }  
                }  
            }  
        }  
        return false;  
    }  
}
