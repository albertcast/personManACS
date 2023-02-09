package personManACS;

import java.util.List;


public class Person {

	private final String name;
	private final int age;
	private final String gender; //Male, Female
	
	
	/*
	 * Constructs a person with a name, age and gender.
	 * 
	 * @param name the name of the person
	 * @param age the age of the person
	 * @param gender the gender of the person
	 */
	
	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;	
	}
	
	public String name() { return name; }
	
	public int age() { return age; }
	
	/*
	 * Computes the average age of male and female persons in a list and returns the result in
	 * an array of two elements (the first element is the male mean age and the second on is the 
	 * female mean age)
	 */
	
	
	public double [] averageAgePerGender (List<Person> persons) { 
		
		return null;
		
	}
	
}
