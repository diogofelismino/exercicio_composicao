package entities;

import java.util.Date;

public class Client {
	private String name;
	private String email;
	private Date nascimento;
	
	public Client() {}

	public Client(String name, String email, Date nascimento) {
		this.name = name;
		this.email = email;
		this.nascimento = nascimento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	

}
