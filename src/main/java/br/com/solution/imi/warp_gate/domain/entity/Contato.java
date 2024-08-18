package br.com.solution.imi.warp_gate.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contato")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;
	
	private String numeroTelefone;

	@Deprecated
	protected Contato() {}

	public Contato(String email, String numeroTelefone) {
		this.email = email;
		this.numeroTelefone = numeroTelefone;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((numeroTelefone == null) ? 0 : numeroTelefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (numeroTelefone == null) {
			if (other.numeroTelefone != null)
				return false;
		} else if (!numeroTelefone.equals(other.numeroTelefone))
			return false;
		return true;
	}

	
}
