package curso.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import curso.springboot.model.Documentos;
import curso.springboot.model.Role;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	
	 @Query("select r from Role r")	
	   public List<Role> getroles(Long id);
	  

}
