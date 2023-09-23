package curso.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profissao {

	@Id
	private Long id;

	private String profissao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	

}
