package curso.springboot.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import curso.springboot.model.Usuario;
import curso.springboot.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	
	
	
	@PostMapping("**/addusuario/")
	public ModelAndView addFonePessoa(@RequestParam("login") String login,@RequestParam("senha") String senha,@RequestParam("nome") String nome) {
		
		
		Usuario usuario = new Usuario();
				ModelAndView modelAndView = new ModelAndView("cadastro/usuarios");

		
	
		
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String result = encoder.encode(senha);
		
		usuario.setLogin(login);
		usuario.setSenha(result);
		usuario.setNome(nome);
		
		
		usuarioRepository.save(usuario);
		
		
		modelAndView.addObject("msg", "Usuario Salvo");
		
		
		
		modelAndView.addObject("usuarios", usuarioRepository.findAll());

		return modelAndView;
	}

	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/usuarios")
	public ModelAndView pessoas() {
	


		ModelAndView modelAndView = new ModelAndView("cadastro/usuarios");
		modelAndView.addObject("pessoaobj", new Pessoa());
		modelAndView.addObject("msg", new ArrayList<String>());
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		return modelAndView;
		
	}
	
	@GetMapping("/removerusuario/{idusuario}")
	public ModelAndView removerusuario(@PathVariable("idusuario") Long idusuario) {
		
		
		
		usuarioRepository.deleteById(idusuario);
		
		ModelAndView modelAndView = new ModelAndView("cadastro/usuarios");
		modelAndView.addObject("pessoaobj", new Pessoa());
		modelAndView.addObject("msg", "Usuario Excluido");
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		return modelAndView;
		
	}
	
		
	}



