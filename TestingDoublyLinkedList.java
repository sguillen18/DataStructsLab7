package Lab7;

public class TestingDoublyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList <String> l = new DoublyLinkedList<String>();
		l.add("pink");
		l.add("purple");
		l.add("green");
		l.print();
		l.reverse();
		l.print();
	}

}
