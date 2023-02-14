package persona;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class PersonTest {
	List<Person> personas;
	double[] expectedResult, result;	
	@BeforeEach
	void startWith() {
		personas = new ArrayList<Person>();
		expectedResult = new double[2];
		expectedResult[0] = 0;
		expectedResult[1] = 0;
	}
	@AfterEach
	void endWith() {
		personas = null;
		expectedResult = null;
	}
	@Test
	void nombrePersona() {
		assertEquals("Ana", new Person("Ana", 1, "Female").name());
	}	
	@Test
	void personaNombreVacio() {
		assertThrows(RuntimeException.class, () -> new Person("", 3, "Male"));
	}
	@Test
	void personaEdadNegativa() {
		assertThrows(RuntimeException.class, () -> new Person("Alberto", -1, "Male"));
	}	
	@Test
	void personaGeneroDiferente() {
		assertThrows(RuntimeException.class, () -> new Person("Alberto", 25, "Patata"));
	}
	@Test
	void hombreNormal() {
		assertDoesNotThrow(() -> new Person("Alberto", 25, "Male"));
	}
	@Test
	void mujerNormal() {
		assertDoesNotThrow(() -> new Person("Maria", 25, "Female"));
	}
	@Test
	void mediaEdadesCeroPersonas() {
		assertNull(Person.averageAgePerGender(personas));
	}
	@Test
	void mediaEdadesSoloUnHombre() {
		personas.add(new Person("Alberto", 25, "Male"));
		expectedResult[0] = 25;
		result = Person.averageAgePerGender(personas);
		assertEquals(expectedResult[0], result[0]);
		assertEquals(expectedResult[1], result[1]);
	}
	@Test
	void mediaEdadesSoloUnaMujer() {
		personas.add(new Person("Maria", 25, "Female"));
		expectedResult[1] = 25;
		result = Person.averageAgePerGender(personas);
		assertEquals(expectedResult[0], result[0]);
		assertEquals(expectedResult[1], result[1]);
	}
	@Test
	void mediaEdadesUnaMujerUnHombre() {
		personas.add(new Person("Alberto", 25, "Male"));
		personas.add(new Person("Maria", 25, "Female"));
		expectedResult[0] = 25;
		expectedResult[1] = 25;
		result = Person.averageAgePerGender(personas);
		assertEquals(expectedResult[0], result[0]);
		assertEquals(expectedResult[1], result[1]);
	}
	@Test
	void mediaEdadesDosHombres() {
		personas.add(new Person("Alberto", 30, "Male"));
		personas.add(new Person("Juan", 10, "Male"));
		expectedResult[0] = 20;
		expectedResult[1] = 0;
		result = Person.averageAgePerGender(personas);
		assertEquals(expectedResult[0], result[0]);
		assertEquals(expectedResult[1], result[1]);
	}
	@Test
	void mediaEdadesTresHombres() {
		personas.add(new Person("Alberto", 30, "Male"));
		personas.add(new Person("Juan", 10, "Male"));
		personas.add(new Person("Manolo", 50, "Male"));
		expectedResult[0] = 30;
		expectedResult[1] = 0;
		result = Person.averageAgePerGender(personas);
		assertEquals(expectedResult[0], result[0]);
		assertEquals(expectedResult[1], result[1]);
	}
	@Test
	void mediaEdadesTresHombresTresMujeres() {
		personas.add(new Person("Alberto", 30, "Male"));
		personas.add(new Person("Juan", 10, "Male"));
		personas.add(new Person("Manolo", 50, "Male"));
		personas.add(new Person("Maria", 30, "Female"));
		personas.add(new Person("Pepa", 20, "Female"));
		personas.add(new Person("Ana", 50, "Female"));
		expectedResult[0] = 30;
		expectedResult[1] = 100/3;
		result = Person.averageAgePerGender(personas);
		assertEquals(expectedResult[0], result[0]);
		assertEquals(expectedResult[1], result[1]);
	}
}