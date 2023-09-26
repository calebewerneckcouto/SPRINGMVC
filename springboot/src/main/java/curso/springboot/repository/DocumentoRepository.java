package curso.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import curso.springboot.model.Documentos;
import curso.springboot.model.Telefone;

@Repository
@Transactional
public interface DocumentoRepository extends JpaRepository<Documentos, Long>{
	
     
   
   
   @Query("select d from Documentos d where d.pessoas.id = ?1")	
   public List<Documentos> getdocumentos(Long id);
   
   
 
   
   
   
}
