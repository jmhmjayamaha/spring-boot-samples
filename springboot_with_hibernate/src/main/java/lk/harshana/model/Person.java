package lk.harshana.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Person.
 */
@Entity
@Table(name="person")
public class Person implements Serializable {
	
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
	
	/** The id. */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	/** The name. */
	@Column(name="id")
	private String name;
	
	/** The address. */
	@Column(name="id")
	private String address;
	
	/** The nic. */
	@Column(name="id")
	private String nic;
	
	/** The tel no. */
	@Column(name="id")
	private String telNo;
	
	/** The email. */
	@Column(name="id")
	private String email;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
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
	 * Gets the nic.
	 *
	 * @return the nic
	 */
	public String getNic() {
		return nic;
	}

	/**
	 * Sets the nic.
	 *
	 * @param nic the new nic
	 */
	public void setNic(String nic) {
		this.nic = nic;
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
 }
