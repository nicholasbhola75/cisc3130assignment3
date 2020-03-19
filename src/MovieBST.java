package Assignment3;
import java.util.*;
import java.io.*;
/*
 * the class of the ordered tree
 * contains Movie nodes
 * has one data field, called first, holding the root of the tree
 * method find() locates movies in the tree by title
 * method getFirst() returns the first Movie node in the tree, needed for the subtree method mainly
 * method insert() adds new nodes
 * method subSet() creates subsets of the ordered tree at specified values
 */
public class MovieBST {
	private Movie first;
	public void MovieBTS() {
		first = null;
	}
	/*
	 * returns Movie nodes from the tree
	 * key represents the title of a movie
	 * depending on whether the key is greater or lesser than the current node, the method will search-
	 * either to the left or the right until it locates the movie
	 * Finally it returns either the located movie or null
	 */
	public Movie find(String key) {
		Movie current = first;
		while(current.getTitle() != key) {
			if(key.compareTo(current.getTitle()) < 0) {
				current = current.getLeftMovie();
			}
			else {
				current = current.getLeftMovie();
			}
			if(current == null) {
				return null;
			}
		}
		return current;
	}
	public Movie getFirst() {
		return first;
	}
	/*
	 *inserts new nodes into the tree with title, releaseYear, and genres
	 * Uses these in order to build new movie nodes
	 * If first is null, the new movie node is set to first
	 * otherwise, a while loop is used to put new nodes into the tree depending on if the new node's title-
	 * is greater or lesser than the first node
	 * Then it continues down the tree
	 */
	public void insert(String title, int releaseYear, String genres) {
		Movie newMovie = new Movie(title, releaseYear, genres);
		if(first == null) {
			first = newMovie;
		}
		else {
			Movie current = first;
			Movie parent;
			while(true) {
				parent = current;
				if(title.compareTo(current.getTitle()) < 0) {
					current = current.getLeftMovie();
					if(current == null) {
						parent.setLeftMovie(newMovie);
						return;
					}
				}
				else {
					current = current.getRightMovie();
					if(current == null) {
						parent.setRightMovie(newMovie);
						return;
					}
				}
			}
		}
	}
	/*
	 * this method is used to create subtrees of the ordered tree
	 * it recursively calls itself until it reaches a node that is between start and end based on its title
	 * then the movie's information is printed to a separate file
	 * only what is between start and end will print
	 */
	public void subSet(Movie node, String start, String end, PrintWriter outputfile) throws FileNotFoundException {
		if(node == null) {
			return;
		}
		if(start.compareTo(node.getTitle()) < 0) {
			subSet(node.getLeftMovie(), start, end, outputfile);
		}
		if(start.compareTo(node.getTitle()) <= 0 && end.compareTo(node.getTitle()) >= 0) {
			node.displayMovie(outputfile);
		}
		if(end.compareTo(node.getTitle()) > 0) {
			subSet(node.getRightMovie(), start, end, outputfile);
		}

	}
}
