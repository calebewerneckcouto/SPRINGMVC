package curso.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.springboot.model.Pessoa;
import curso.springboot.model.Profissao;
import curso.springboot.model.Telefone;
import curso.springboot.respository.ProfissaoRepository;

@Controller
public class ProfissaoController {
	@Autowired
	private ProfissaoRepository profissaoRepository;
	
	private Profissao profissao = new Profissao();
	
	
	@PostMapping("/addprofissoes")
	public ModelAndView addprofissoes(@RequestParam("profissao") String nomeProfissao) {
	    // Crie uma nova instância de Profissao e defina o nome da profissão
	    Profissao novaProfissao = new Profissao();
	    novaProfissao.setProfissao(nomeProfissao);

	    // Salve a nova profissão
	    profissaoRepository.save(novaProfissao);

	    ModelAndView modelAndView = new ModelAndView("cadastro/profissao");
	    modelAndView.addObject("profissoes", profissaoRepository.findAll());

	    return modelAndView;
	}

	
	@GetMapping("**/profissao")
	public ModelAndView profissao() {

	

		ModelAndView modelAndView = new ModelAndView("/cadastro/profissao");
		
		modelAndView.addObject("msgErro", "");
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


	
	

}
