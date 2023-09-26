package curso.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

@Entity
public class Documentos {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	@Lob
	private byte[] file;

	@ForeignKey(name="pessoa_id")
	@ManyToOne
	private Pessoa pessoas;
	
	private String nomefile;
	
	private String tipofile;
	
	
	
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





	





	public byte[] getFile() {
		return file;
	}





	public void setFile(byte[] file) {
		this.file = file;
	}





	public Pessoa getPessoa() {
		return pessoas;
	}





	public void setPessoa(Pessoa pessoa) {
		this.pessoas = pessoa;
	}
	
	
	
	
	

}
