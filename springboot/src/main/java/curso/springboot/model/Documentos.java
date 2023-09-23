package curso.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Documentos {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	
	
	private String nomefile;
	
	
	
	
	
	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getDescricao() {
		return descricao;
	}





	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}





	public String getNomefile() {
		return nomefile;
	}





	public void setNomefile(String nomefile) {
		this.nomefile = nomefile;
	}





	public String getTipofile() {
		return tipofile;
	}





	public void setTipofile(String tipofile) {
		this.tipofile = tipofile;
	}





	private String tipofile;
	
	
	
	
	

}
