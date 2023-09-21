package curso.springboot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;
@SuppressWarnings("deprecation")
@Entity
public class Documentos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String documento;

	@ForeignKey(name = "pessoa_id")
	@ManyToOne
	private Pessoa pessoas;

	@Lob
	private byte[] file;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
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
