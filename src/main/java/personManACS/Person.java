package personManACS;

import java.util.ArrayList;
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
		if(name.isBlank() || age < 0 || (gender != "Male" && gender != "Female"))
			throw new RuntimeException("Datos introducidos inválidos. Los datos deben ser: nombre no vacío, edad positiva y género Male o Female. Los datos introducidos son: Nombre - " + 
					name + " ,edad - " + age + " ,género - " + gender);
		this.name = name;
		this.age = age;
		this.gender = gender;	
	}
	
	public String name() { return name; }
	
	public int age() { return age; }
	
	public String gender() {
		return gender;
	}
	
	/*
	 * Computes the average age of male and female persons in a list and returns the result in
	 * an array of two elements (the first element is the male mean age and the second on is the 
	 * female mean age)
	 */
	
	
	public static double [] averageAgePerGender (List<Person> persons) { 
		if(!persons.isEmpty()) {
			int totalMale = 0, totalFemale = 0, totalAgeMale = 0, totalAgeFemale = 0;
			for (Person person : persons) {
				if(person.gender().equalsIgnoreCase("Male")) {
					totalMale++;
					totalAgeMale += person.age();
				} else if(person.gender().equalsIgnoreCase("Female")) {
					totalFemale++;
					totalAgeFemale += person.age();
				}
			}
			double [] aux = new double[2];
			if(totalMale > 0) {
				aux[0] = totalAgeMale/totalMale;
			} else {
				aux[0] = 0;
			}
			
			if(totalFemale > 0) {
				aux[1] = totalAgeFemale/totalFemale;
			} else {
				aux[1] = 0;
			}
			return aux;
			
			
		}
		
		return null;
		
	}
	
}
