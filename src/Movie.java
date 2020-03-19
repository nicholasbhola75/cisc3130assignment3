package Assignment3;
import java.util.*;
import java.io.*;
/*
 * the Movie class represents a node in the ordered tree
 * has fields for the movie's title, its release year, and an array called genres containing all the movie's genres
 * the constructor sets the values for everything, in genres' case, a string is split into the array at each "|"
 * each Movie has pointers for a Movie on its left in the tree and a movie on its right, represented by leftMovie and rightMovie
 * there is a getter for the title as the title is very important in MovieBST methods as a key
 * there are mutators and accessors for the leftMovie and the rightMovie as well
 */
public class Movie {
	private String title;
	private int releaseYear;
	private String[] genres;
	private Movie leftMovie;
	private Movie rightMovie;
	
	public Movie(String t, int r, String g) {
		title = t;
		releaseYear = r;
		genres = g.split("\\|");
	}
	/*
	 * this method prints out the data contained in the node
	 * a for loop is used to print out the genres array fully
	 */
	public void displayMovie(PrintWriter outputfile) throws FileNotFoundException {	
		outputfile.print("Title: " + title + ", Release Year: " + releaseYear + ", Genres: ");
		for(int index = 0; index < genres.length; index++) {
			outputfile.print(genres[index] + ", ");
		}
		outputfile.println();
	}
	public String getTitle() {
		return title;
	}
	public Movie getLeftMovie() {
		return leftMovie;
	}
	public Movie getRightMovie() {
		return rightMovie;
	}
	public void setLeftMovie(Movie lm) {
		leftMovie = lm;
		
	}
	public void setRightMovie(Movie rm) {
		rightMovie = rm;
	}
}
