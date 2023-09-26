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
import curso.springboot.model.Telefone;
import curso.springboot.repository.ProfissaoRepository;

@Controller
public class ProfissaoController {

	
	@Autowired
  ProfissaoRepository profissaoRepository;
	
	@PostMapping("**/addprofissao/")
	public ModelAndView addFonePessoa(@RequestParam("profissao") String profissao) {
		
		
		Profissao profissao2 = new Profissao();
				ModelAndView modelAndView = new ModelAndView("cadastro/profissao");

		
		
		profissao2.setProfissao(profissao);
		
		
		
		profissaoRepository.save(profissao2);
		
		
		modelAndView.addObject("profissoes", profissaoRepository.findAll());

		return modelAndView;
	}
	
	
	@GetMapping("/removerprofissao/{idprofissao}")
	public ModelAndView removertelefone(@PathVariable("idprofissao") Long idprofissao) {
		
		
		
		profissaoRepository.deleteById(idprofissao);
		
		ModelAndView modelAndView = new ModelAndView("cadastro/profissao");
	
		modelAndView.addObject("profissoes", profissaoRepository.findAll());
		return modelAndView;
		
	}
	
	


	
	
	@RequestMapping(method = RequestMethod.GET, value = "/profissao")
	public ModelAndView pessoas() {
	


		ModelAndView modelAndView = new ModelAndView("cadastro/profissao");
		modelAndView.addObject("pessoaobj", new Pessoa());
		modelAndView.addObject("msg", new ArrayList<String>());
		modelAndView.addObject("profissoes", profissaoRepository.findAll());
		return modelAndView;
		
	}
}
	
	