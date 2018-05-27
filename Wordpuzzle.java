import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner; 
import java.util.Random;
import java.io.IOException;

public class Wordpuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linearprobing<String> H = new Linearprobing<String>( );

	    System.out.println("enter the (a,b) dimensions of array.");
	    @SuppressWarnings("resource")
		Scanner reader1 = new Scanner(System.in);
	    int a = reader1.nextInt();
	    @SuppressWarnings("unused")
		Scanner reader2 = new Scanner(System.in);
	    int b = reader1.nextInt();
	    Random r = new Random();
	    char[][] mat= new char[a][b];
	    
//	    char mat[][] = {
//	    	    "hixtxxxxsx".toCharArray(),
//	            "xsxxhxxixx".toCharArray(),
//	            "xixxsihtxx".toCharArray(),
//	            "xhsxxxstxx".toCharArray(),
//	            "xtxahdxhxx".toCharArray(),
//	            "xxxthisixx".toCharArray(),
//	            "xxxxxxisxx".toCharArray(),
//	            "Praneethxx".toCharArray(),
//	            "xhxxxxxxtx".toCharArray(),
//	            "xxixxxxxxx".toCharArray()
//	  	  };
	    
	    
	    
	    
	  // generate 2D matrix with random characters  
	    for(int i=0;i<a;i++){
	    	for(int j=0;j<b;j++){
	    		
	    		char c = (char)(r.nextInt(26) + 'a');
	    		mat[i][j]=c;
	    		 System.out.print(c + " ");
	    		
	    	}
	    	System.out.println();
	    }
	 
	      System.out.println("Enter 1 for enhancement and 0 for non-enhancement");
	  
	      int enhancement;
	      Scanner reader3 = new Scanner(System.in);
	      enhancement = reader3.nextInt();
	  // reading the Dictionary into hash table 
	    try {
	        FileReader reader = new FileReader("C:\\Users\\haneesha\\eclipse-workspace\\Dictionar\\src\\dictionary.txt");
	        BufferedReader bufferedReader = new BufferedReader(reader);
	        String line;

	        while ((line = bufferedReader.readLine()) != null) {
	 //         System.out.println(line);
	            H.insert( line,false );
	            if(enhancement == 0 ) {
	            	continue;
	            } 
	           for(int p=1;p<=line.length();p++){
	           	   H.insert(line.substring(0, p), true);
	 //        	   System.out.println(line.substring(0, p));
	        	
	           }
	        	
	        }
	        reader.close();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    long startTime = System.currentTimeMillis( );
	   
	    StringBuilder sb = new StringBuilder();
	    for (int i=0; i<mat.length; i++)
	    {
	       for (int j=0; j<mat[i].length; j++)
	       {
		    sb.setLength(0);
	          for (int k=0; k + j < mat[i].length; k++)
	          {	 
	             sb.append(mat[i][j+k]);

	             if ( enhancement == 1 && !H.contains(new String(sb))[0]){
	            	 break;
	             } 
	             if (H.contains(new String(sb))[0] && !H.contains(new String(sb))[1]) 
	             {
	                 System.out.println("Found \"" + sb + "\" rightwards at "
			         + "(" + i + "," + j + ")");
	             }
	          }
	 
	 
	          /////
	          sb.setLength(0);
	          for (int k=0; k + i < mat.length; k++)
	          {	  
	             sb.append(mat[i+k][j]);
	             if ( enhancement == 1 && !H.contains(new String(sb))[0]){
	            	 break;
	             }
	             if (H.contains(new String(sb))[0] && !H.contains(new String(sb))[1]){ 
	                 System.out.println("Found \"" + sb + "\" downwards at "
			         + "(" + i + "," + j + ")");
	             }
	          }
	          /////
	          sb.setLength(0);
	          for (int k=0; j-k>=0; k++)
	          {	  
	             sb.append(mat[i][j-k]);
	             if ( enhancement == 1 && !H.contains(new String(sb))[0]){
	            	 break;
	             } 
	             if (H.contains(new String(sb))[0] && !H.contains(new String(sb))[1]) 
	             {
	                 System.out.println("Found \"" + sb + "\" leftwards at "
			         + "(" + i + "," + j + ")");
	             }
	          }
	          /////
	          sb.setLength(0);
	          for (int k=0; i-k>=0; k++)
	          {	  
	             sb.append(mat[i-k][j]);
	             if ( enhancement == 1 && !H.contains(new String(sb))[0]){
	            	 break;
	             } 
	             if (H.contains(new String(sb))[0] && !H.contains(new String(sb))[1]) 
	             {
	                 System.out.println("Found \"" + sb + "\" upwards at "
			         + "(" + i + "," + j + ")");
	             }
	          }
	          /////
	          sb.setLength(0);
	          for (int k=0; i+k <mat.length&& j+k <mat[i].length; k++)
	          {	  
	             sb.append(mat[i+k][j+k]);
	             if ( enhancement == 1 && !H.contains(new String(sb))[0]){
	            	 break;
	             } 
	             if (H.contains(new String(sb))[0] && !H.contains(new String(sb))[1]) 
	             {
	                 System.out.println("Found \"" + sb + "\" right downwards at "
			         + "(" + i + "," + j + ")");
	             }
	          }
	          ////
	          sb.setLength(0);
	          for (int k=0; i-k >=0 && j+k < mat[i].length; k++)
	          {	  
	             sb.append(mat[i-k][j+k]);
	             if ( enhancement == 1 && !H.contains(new String(sb))[0]){
	            	 break;
	             } 
	             if (H.contains(new String(sb))[0] && !H.contains(new String(sb))[1]) 
	             {
	                 System.out.println("Found \"" + sb + "\"  right upwards at "
			         + "(" + i + "," + j + ")");
	             }
	          }
	          /////
	          sb.setLength(0);
	          for (int k=0; i-k >=0 && j-k >= 0; k++)
	          {	  
	             sb.append(mat[i-k][j-k]);
	             if ( enhancement == 1 && !H.contains(new String(sb))[0]){
	            	 break;
	             } 
	             if (H.contains(new String(sb))[0] && !H.contains(new String(sb))[1]) 
	             {
	                 System.out.println("Found \"" + sb + "\"  left upwards at "
			         + "(" + i + "," + j + ")");
	             }
	          }
	          /////
	          sb.setLength(0);
	          for (int k=0; i+k < mat.length && j-k >= 0; k++)
	          {	  
	             sb.append(mat[i+k][j-k]);
	             if ( enhancement == 1 && !H.contains(new String(sb))[0]){
	            	 break;
	             } 
	             if (H.contains(new String(sb))[0] && !H.contains(new String(sb))[1]) 
	             {
	                 System.out.println("Found \"" + sb + "\" left downwards at "
			         + "(" + i + "," + j + ")");
	             }
	          }
	          /////
	          
	          
	       }
	    }
	  
	    long endTime = System.currentTimeMillis( );
	    System.out.println( "Elapsed time: " + (endTime - startTime) );
	}
}
