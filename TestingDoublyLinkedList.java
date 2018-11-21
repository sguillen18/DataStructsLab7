package Lab7;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
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
		p.display();
		
		sc.close();
	}
	

	
	public void paint(Graphics g, Polygon p)
	{
		Graphics2D g2 = (Graphics2D) g;
		for(int i = 0; i < p.getLines().getLength(); i++) {
			Line l = p.getLines().getEntry(i);
			double x1 = (l.getStart().getX()+100) * 100;
			double y1 = (l.getStart().getY()+100) * 100;
			double x2 = (l.getEnd().getX()+100) * 100;
			double y2 = (l.getEnd().getY()+100) * 100;
			Shape s = new Line2D.Double(x1, y1, x2, y2);
			g2.draw(s);
		}
	}

}
