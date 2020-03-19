package Assignment3;
import java.util.*;
import java.io.*;
/*
 * Program reads in data about movies from a csv file and sorts them into a binary search tree
 * the MovieBST class represents the class of the ordered tree
 * a while loop searches through the file by line to fill the 2D array myList
 * each line is split at each comma into each row of the 2D array
 * the replaceAll()s were used to remove any extra commas or parenthesis interfering with the split
 * Next, each row from the 2D array is inserted into the MovieLens ordered tree
 * the MovieLens class has three parameters: a movie title, the movie's release date (an integer), and the movie's genres
 * After the tree is full of all of the file's data, it prevents three subtrees of the ordered trees to a separate file
 * the subtrees are ordered and prints all the data between the movies specified
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		MovieBST MovieLens = new MovieBST();
		File output = new File("C:\\Users\\nickb\\Desktop\\out.txt");
	    PrintWriter outputfile = new PrintWriter(output);
	    File file = new File("C:\\Users\\nickb\\Documents\\ml-latest-small\\movies.csv");
	    Scanner cFile = new Scanner(file);
	    String[][] myList = new String[10000][50];
	    int i = 0;
	    while(cFile.hasNext()) {
	    	String line = cFile.nextLine();
	    	String line2 = line.replaceAll(", ", " ");
		    String line3 = line2.replaceAll(",0", "0");	    
		    String line9 = line3.replaceAll("\\(1", ",1");
		    String line91 = line9.replaceAll("\\(2", ",2");
		    String line10 = line91.replaceAll("\\)", "");
		    String line12 = line10.replaceAll("\\(", "");
		    String line11 = line12.replaceAll("\"", "");
		    String[] str = line11.split(",");
		    for (int w = 0; w < str.length; w++) {	    	  
		    	  myList[i][w] = str[w];
		      }
		      i++;
	    }
	    for (int y = 1; y < myList.length; y++) {
	    	if(myList[y][1] != null) {
	    	MovieLens.insert(myList[y][1], Integer.parseInt(myList[y][2]), myList[y][3]);
	    	}
	    }
	    MovieLens.subSet(MovieLens.getFirst(),"Candyman: Farewell to the Flesh", "Homeward Bound II: Lost in San Francisco", outputfile);
	    outputfile.println();
	    MovieLens.subSet(MovieLens.getFirst(),"Aladdin", "Dances with Wolves", outputfile);
	    outputfile.println();
	    MovieLens.subSet(MovieLens.getFirst(),"Three Musketeers", "Welcome to the Dollhouse", outputfile);
	    outputfile.close();
	}
	
}
