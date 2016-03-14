package json_serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class Person implements Serializable {
	String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	
}

public class Test {
	
	public static void main(String[] args) {
		
		Person mike = new Person("Mike The Man");
		/*try {
			writeToFile(mike);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		try {
			readFile();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println(e.getMessage());
		}

}
	
	public static void writeToFile(Person p) throws IOException{
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Person.bin"));
		
		objectOutputStream.writeObject(p);
}
	
	public static void readFile() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Person.bin"));
		
		Person name = (Person) objectInputStream.readObject();
		System.out.println(name);
	}
	
}