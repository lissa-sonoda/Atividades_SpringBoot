package br.org.generation.lojadegames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long iduser;
	
	@NotBlank(message = "O nome é obrigatório")
	@Size(min = 2, max = 120, message = "O nome deve conter entre 2 a 120 caracteres")
	private String name;
	
	@NotNull(message = "O nome de usuário é obrigatório")
	@Size(min = 2, max = 200, message = "O nome de usuário deve conter entre 2 a 200 caracteres")
	private String username;
	
	@NotNull(message = "A senha é obrigatória")
	@Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("user")
	private List<Produto> product;
	
	public Usuario(long iduser, String name, String username, String password) {
		this.iduser = iduser;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	
	public Usuario() {}

	public long getIduser() {
		return iduser;
	}

	public void setIduser(long iduser) {
		this.iduser = iduser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Produto> getProduct() {
		return product;
	}

	public void setProduct(List<Produto> product) {
		this.product = product;
	}

}
