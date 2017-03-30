package lk.harshana.model;

import org.springframework.data.annotation.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class Person.
 */
/**
 * @author Harshana Madusanka
 *
 */
public class Person {
	
	/** The id. */
	@Id
	private String id;
	
	/** The name. */
	private String name;
	
	/** The address. */
	private String address;
	
	/** The age. */
	private int age;
	
	/** The email. */
	private String email;
	
	/** The tel no. */
	private String telNo;
	
	/**
	 * Instantiates a new person.
	 */
	public Person() {}

	/**
	 * Instantiates a new person.
	 *
	 * @param name the name
	 * @param address the address
	 * @param age the age
	 * @param email the email
	 * @param telNo the tel no
	 */
	public Person(String name, String address, int age, String email, String telNo) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.email = email;
		this.telNo = telNo;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the tel no.
	 *
	 * @return the tel no
	 */
	public String getTelNo() {
		return telNo;
	}

	/**
	 * Sets the tel no.
	 *
	 * @param telNo the new tel no
	 */
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	
	
}
