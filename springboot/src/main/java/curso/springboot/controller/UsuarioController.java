package curso.springboot.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.springboot.model.Pessoa;
import curso.springboot.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@GetMapping("/addusuario/")
	public ModelAndView documentos(@RequestParam("login") String login, @RequestParam("senha")String senha,@RequestParam("nome")String nome) {
		
		

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastrousuarios");
		
		modelAndView.addObject("msg", new ArrayList<String>());
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		return modelAndView;
		
	}


}
