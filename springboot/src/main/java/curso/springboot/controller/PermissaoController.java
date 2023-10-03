package curso.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.springboot.model.Pessoa;
import curso.springboot.model.Role;
import curso.springboot.model.Usuario;
import curso.springboot.repository.RoleRepository;
import curso.springboot.repository.UsuarioRepository;
@Controller
public class PermissaoController {
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/permitir")
	public ModelAndView permissao() {
	


		ModelAndView modelAndView = new ModelAndView("cadastro/permissao");
		modelAndView.addObject("pessoaobj", new Pessoa());
		modelAndView.addObject("msg", new ArrayList<String>());
		
		List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
		
		modelAndView.addObject("usuarios",usuarios);
		List<Role> roles = roleRepository.findAll();
		
		
		
		List<Usuario> usuariosrole = usuarioRepository.findAllUsuariosWithRoles();
		modelAndView.addObject("permissoes",usuariosrole);
		modelAndView.addObject("roles",roles);
		
		return modelAndView;
	
	}
	
	
}