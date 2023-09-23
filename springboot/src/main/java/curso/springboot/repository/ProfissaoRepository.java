package curso.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import curso.springboot.model.Profissao;
import curso.springboot.model.Telefone;

@Transactional
@Repository
public interface ProfissaoRepository extends CrudRepository<Profissao, Long> {
	
	@Query("select p from Profissao p")	
	   public List<Profissao> getprofissoes(Long id);

}
