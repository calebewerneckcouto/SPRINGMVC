package curso.springboot.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import curso.springboot.model.Documentos;
import curso.springboot.model.Pessoa;
import curso.springboot.model.Profissao;


@Repository
@Transactional
public interface DocumentoRepository extends CrudRepository<Documentos, Long>{
	
	
	@Query("select d from Documentos d")
	public List<Documentos> getProfissoes(Long id);
	
	
	
	

}
