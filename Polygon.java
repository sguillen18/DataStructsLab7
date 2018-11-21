package Lab7;

import java.util.Scanner;

public class Polygon {
	DoublyLinkedList <Line> lines;
	
	public Polygon() {
		
	}
	
	public void readFromFile(Scanner sc) {
		while(sc.hasNextLine()) {
			char[] line = sc.nextLine().toCharArray();
			double x1 = 0, y1 = 0, x2 = 0, y2 = 0;
			DoublyLinkedList <Double> d = new DoublyLinkedList<Double>();
			String num = null;
			
			for(int i = 0; i < line.length; i++) {
				if(line[i] == ')' || line[i] == '(' || line[i] == ' ') {
					if(num != null) {
						double dd = Double.valueOf(num);
						d.add(dd);
						num = null;
					}
					if(Character.isLetter(line[i])) {
						throw new IllegalArgumentException();
					}
				}
				
				else {
					num += line[i];
				}
					
			}
			
			for(int j = 0; j < 4; j++) {
				double f = d.getEntry(j);
				if(j == 0)
					x1 = f;
				if(j == 1)
					y1 = f;
				if(j == 2)
					x2 = f;
				if(j == 3)
					y2 = f;
			}
			
			Line l = new Line(x1, y1, x2, y2);
			lines.add(l);
		}
	}
	
	public void reverse() {
		lines.reverse();
		
		for(int i = 0; i < lines.getLength(); i++) {
			
		}
	}

}
