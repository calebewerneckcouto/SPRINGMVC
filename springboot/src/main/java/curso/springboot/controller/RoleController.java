package curso.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.springboot.model.Pessoa;
import curso.springboot.model.Profissao;
import curso.springboot.model.Role;
import curso.springboot.model.Telefone;
import curso.springboot.model.Usuario;
import curso.springboot.repository.ProfissaoRepository;
import curso.springboot.repository.RoleRepository;
import curso.springboot.repository.UsuarioRepository;

@Controller
public class RoleController {

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@PostMapping("**/addrole/")
	public ModelAndView addFonePessoa(@RequestParam("id") Long id,@RequestParam("nomerole")String nomeRole) {
		
		
		Role role = new Role();
				ModelAndView modelAndView = new ModelAndView("cadastro/role");

		
		
		role.setId(id);
		role.setNomeRole(nomeRole);
		
		
		
		roleRepository.save(role);
		modelAndView.addObject("msg", "Role Salva");
		
		List<Role> roles = roleRepository.findAll();
		modelAndView.addObject("roles",roles);

		return modelAndView;
	}
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/removerrole/{idrole}")
	public ModelAndView removerrole(@PathVariable("idrole") Long idrole) {
		
		
		
		roleRepository.deleteById(idrole);
		
		ModelAndView modelAndView = new ModelAndView("cadastro/role");
	
		List<Role> roles = roleRepository.findAll();
		modelAndView.addObject("roles",roles);
		modelAndView.addObject("msg", "Role foi excluida!");
		return modelAndView;
		
	}
	
	
	
	
	
	
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/role")
	public ModelAndView role() {
	


		ModelAndView modelAndView = new ModelAndView("cadastro/role");
		modelAndView.addObject("pessoaobj", new Pessoa());
		modelAndView.addObject("msg", new ArrayList<String>());
		List<Role> roles = roleRepository.findAll();
		modelAndView.addObject("roles",roles);
		return modelAndView;
		
	}
}
	
	