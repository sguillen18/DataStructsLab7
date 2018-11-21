package Lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestingDoublyLinkedList {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		DoublyLinkedList <String> l = new DoublyLinkedList<String>();
		l.add("pink");
		l.add("purple");
		l.add("green");
		l.print();
		l.reverse();
		l.print();
		
		File inFile = new File("C:\\Users\\hillg2\\eclipse-workspace\\DataStructures\\src\\Lab7\\polygon.txt");
		Scanner sc = new Scanner(inFile);
		
		Polygon p = new Polygon();
		p.readFromFile(sc);
		System.out.println("Original");
		p.display();
		
		System.out.println("Reversed");
		p.reverse();
		p.display();
		
		sc.close();
	}

}
