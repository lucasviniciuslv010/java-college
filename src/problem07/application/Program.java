package problem07.application;

import java.util.ArrayList;
import java.util.List;

import problem07.model.entities.Circle;
import problem07.model.entities.Rectangle;
import problem07.model.entities.Shape;

/*
Faça um programa que retorne a soma das áreas de uma lista de figuras.
*/

public class Program {

	public static void main(String[] args) {
			
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Rectangle(3.0, 2.0));
		shapes.add(new Circle(2.0));
		
		double totalArea = totalArea(shapes);
		System.out.println(String.format("%.2f", totalArea));
		
		
		// ========================================================
		
		
		List<Rectangle> myRectangles = new ArrayList<>();
		myRectangles.add(new Rectangle(3.0, 2.0));
		myRectangles.add(new Rectangle(7.1, 4.9));
		
		totalArea = totalArea(myRectangles);
		System.out.println(String.format("%.2f", totalArea));
		
		
		// ========================================================
		
		
		List<Circle> myCircles = new ArrayList<>();
		myCircles.add(new Circle(2.0));
		myCircles.add(new Circle(3.0));
		
		totalArea = totalArea(myCircles);
		System.out.println(String.format("%.2f", totalArea));
		
	}
	
	// Bounded Wildcards
	public static double totalArea(List<? extends Shape> list) {
		double totalArea = 0.0;
		for (Shape shape : list) {
			totalArea += shape.area();
		}
		return totalArea;
	}

}