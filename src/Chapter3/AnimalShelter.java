package Chapter3;

import java.util.LinkedList;

public class AnimalShelter {
	public static class Animal {
		public String name;
		public static int num = 0;
		public int serial;
		public String name(){
			return toString();
		}
		public Animal(String name) {
			this.name = name;
			this.serial = Animal.num ++;
		}
	}
	
	public static class Cat extends Animal {

		public Cat(String name) {
			super(name);
		}
		public String toString(){
			return "Cat name "+ this.name;
		}
	}
	
	public static class Dog extends Animal {

		public Dog(String name) {
			super(name);
		}
		public String toString(){
			return "Dog name "+ this.name;
		}
	}	
	
	public static LinkedList<Animal> dog = new LinkedList<Animal>();
	public static LinkedList<Animal> cat = new LinkedList<Animal>();
	
	public static void enqueue(Animal animal ) {
		if(animal instanceof Dog){
			dog.addLast((Dog)animal);
		} else {
			cat.addLast((Cat)animal);
		}

	}
	
	public static Animal dequeueAny(){
		if(dog.size() == 0 && cat.size()!= 0) return dequeueCat();
		if(dog.size() != 0 && cat.size()== 0) return dequeueDog();
		Animal d = dog.removeFirst();
		Animal c = cat.removeFirst();
		if(d.serial<c.serial ) {
			cat.addFirst(c);
			return d;
		} else {
			dog.addFirst(d);
			return c;
		}
	}
	
	public static Animal dequeueDog(){
		return dog.removeLast();
	}

	public static Animal dequeueCat(){
		return cat.removeLast();
	}
	
	public int size(){
		return cat.size()+dog.size();
	}
	public static void main(String[] args) {
		AnimalShelter animals = new AnimalShelter();
		AnimalShelter.enqueue(new Cat("Callie"));
		AnimalShelter.enqueue(new Cat("Kiki"));
		AnimalShelter.enqueue(new Dog("Fido"));
		AnimalShelter.enqueue(new Dog("Dora"));
		AnimalShelter.enqueue(new Cat("Kari"));
		AnimalShelter.enqueue(new Dog("Dexter"));
		AnimalShelter.enqueue(new Dog("Dobo"));
		AnimalShelter.enqueue(new Cat("Copa"));
		
		System.out.println(AnimalShelter.dequeueAny().name());	
		System.out.println(AnimalShelter.dequeueAny().name());	
		System.out.println(AnimalShelter.dequeueAny().name());	
		
		AnimalShelter.enqueue(new Dog("Dapa"));
		AnimalShelter.enqueue(new Cat("Kilo"));
		
		while (animals.size() != 0) {
			System.out.println(AnimalShelter.dequeueAny().name());	
		}
	}

}