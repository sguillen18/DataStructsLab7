# DataStructsLab7

1) Create a class DoublyLinkedList <T> which implements ListInterface<T>  and 
Iterable <T>.
a)	The implementation uses a doubly linked chain: the nodes have references to both next node and the previous node.




You will see that the search and adding to the end are easier than with one-directional chain; adding in the middle and removal needs resetting both links. 
b)	You will need the private method getNodeAt (int position). Make sure to implement it with traversing the chain by one node rather than with two nodes (curr and prev) in simple linked chain. 
c)	When creating the iterator, you may make the method remove throw UnsupportedOperationExtention unless you need this method for the bonus part.
d)	 In addition to the interface methods, create a method reverse which reverses the list, swapping next and prev links and swapping head and tail. Do it in place (without creating an array).

2)	Create a class Line with private fields start and end of type Point2d. You can define Point2d as an inner class. Define constructors
Line (double x1, double y1, double x2, double y) and 
Line (Point2d start, Point2d end) and the methods needed for implementation of the Polygon.




3)	For testing: create a class Polygon with one private field DoublyLinkedList <Line>. Define a method readFromFile (Scanner sc) similarly to what you did in the Lab 5.
Define a method display.
Also, define a method reverse for the polygon. Pay attention: it not only reverses the chain, but swaps the lines ends. 
In the main method, fill a polygon from the file polygon.txt, display it, then reverse the polygon and display again.

4)	(bonus 10 pts): define methods allowing to fill gaps in the polygon. In the attached file, the gaps are between 4th and 5th lines, and between tail and head. You may need iterators to do it.
