package curso.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import curso.springboot.model.Documentos;
import curso.springboot.model.Pessoa;
import curso.springboot.respository.DocumentoRepository;
import curso.springboot.respository.PessoaRepository;
import net.sf.jasperreports.data.http.RequestMethod;

@Controller
public class DocumentoController {
	
	
	
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	

	@Autowired
	private DocumentoRepository documentoRepository;
	
	
	
	

	@RequestMapping(method = org.springframework.web.bind.annotation.RequestMethod.POST, value = "upload", consumes = {"multipart/form-data" })
	public ModelAndView salvardocumento(@RequestParam("documento") String documento, final MultipartFile file)
			throws IOException {

		Documentos doc = new Documentos();
       
		
		
		
			doc.setDocumento(documento);
			doc.setFile(file.getBytes());
		
		
	
			documentoRepository.save(doc);

		

		ModelAndView andView = new ModelAndView("cadastro/documentos");
		andView.addObject("documentos", documentoRepository.findAll());

		return andView;

	}

	@GetMapping("/documentos/{idpessoa}")
	public ModelAndView documentos(@PathVariable("idpessoa") Long idpessoa) {
		
		
		
		Documentos documentos = new Documentos();
		
		
		
		
		Pessoa pessoa = pessoaRepository.findById(idpessoa).get();

		

			ModelAndView modelAndView = new ModelAndView("cadastro/documentos");
			modelAndView.addObject("pessoaobj", pessoa);
			modelAndView.addObject("documentos", documentoRepository.findAll());

			

			

		

		

	
		return modelAndView;
	}
		
		
		
		
		
		

	

	@GetMapping("/removerdocumento/{iddocumento}")
	public ModelAndView removerdocumento(@PathVariable("iddocumento") Long id) {

		documentoRepository.deleteById(id);

		ModelAndView modelAndView = new ModelAndView("cadastro/documentos");

		modelAndView.addObject("documentos", documentoRepository.findAll());
		return modelAndView;

	}

}