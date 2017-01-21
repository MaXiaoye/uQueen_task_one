package com.taskone.main;

//Search if the word exists in provided grid

public class search {

static boolean searchInGrid(char[][] charGrid, int i,int j,String inputString,boolean[][] shadowFlag){  
        if (inputString.length()==0){return true;} // The last char in input is found. Return true.  
        else{  
        	
        	//If the left char in grid equals to the target. 
            if ((i>0)&&(charGrid[i-1][j]==inputString.charAt(0))&&(shadowFlag[i-1][j]==false)){
            	
            	//The char in grid is searched. Can't be searched again.
            	shadowFlag[i-1][j]=true;
            	
            	//recursion
                if (searchInGrid(charGrid,i-1,j,inputString.substring(1),shadowFlag)){  
                    return true;  
                }  
                shadowFlag[i-1][j]=false;  
            }
            
            //If the right char in grid equals to the target. 
            if ((i<charGrid.length-1)&&(charGrid[i+1][j]==inputString.charAt(0))&&(shadowFlag[i+1][j]==false)){  
            	shadowFlag[i+1][j]=true;  
                if (searchInGrid(charGrid,i+1,j,inputString.substring(1),shadowFlag)){  
                    return true;  
                }  
                shadowFlag[i+1][j]=false;  
            }  
            
            //If the upper char in grid equals to the target. 
            if ((j>0)&&(charGrid[i][j-1]==inputString.charAt(0))&&(shadowFlag[i][j-1]==false)){  
            	shadowFlag[i][j-1]=true;  
                if (searchInGrid(charGrid,i,j-1,inputString.substring(1),shadowFlag)){  
                    return true;  
                }  
                shadowFlag[i][j-1]=false;  
            }  
            
            //If the lower char in grid equals to the target.
            if ((j<charGrid[0].length-1)&&(charGrid[i][j+1]==inputString.charAt(0))&&(shadowFlag[i][j+1]==false)){  
            	shadowFlag[i][j+1]=true;  
                if (searchInGrid(charGrid,i,j+1,inputString.substring(1),shadowFlag)){  
                    return true;  
                }  
                shadowFlag[i][j+1]=false;  
            }  
        }
        
        //All chars around don not meet target. Reture false
        return false;  
    }  
   
static  boolean initialSearch(char[][] charGrid, String inputString) {  
        
        if (inputString.length()==0) {return false;} //Can be removed. We can judge if input in null in main()  
        
        //Initialize shadownFlag grid. 
        //Find the first char in grid.
        for (int i=0;i<charGrid.length;i++){  
            for (int j=0;j<charGrid[0].length;j++){  
                if (inputString.charAt(0)==charGrid[i][j]){  
                    if (inputString.length()==1) {return true;}  //Can be removed safely. If input contains only one char and can be found in grid. Then return true directly. 
                    else{  
                       boolean[][] shadowFlag=new boolean[charGrid.length][charGrid[0].length];
                       for (int x=shadowFlag.length-1;x>=0;x--)
                       {
                    	   for(int y=shadowFlag[0].length-1;y>=0;y--)
                    	   {
                    		   shadowFlag[x][y]=new Boolean(false);
                    	   }
                       }
                       shadowFlag[i][j]=true;  
                        if (searchInGrid(charGrid,i,j,inputString.substring(1),shadowFlag)){  
                            return true;  
                        }  
                    }  
                }  
            }  
        }  
        return false;  
    }  
}
