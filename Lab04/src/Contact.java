import java.util.Scanner;

class Contact {
	String name;
	String phone;
	String email;

	public boolean equals(Object x) {
		Contact c = (Contact) x;
		return (name.equals(c.name) || phone.equals(c.phone) || email
				.equals(c.email));
	}

	public String toString() {
		return "Name:" + name + " Phone:" + phone + " Email:" + email;
	}
}

