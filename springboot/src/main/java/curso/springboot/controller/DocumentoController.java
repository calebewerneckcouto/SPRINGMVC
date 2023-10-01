package curso.springboot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import curso.springboot.model.Documentos;
import curso.springboot.model.Pessoa;
import curso.springboot.repository.DocumentoRepository;
import curso.springboot.repository.PessoaRepository;
import javassist.expr.NewArray;

@Controller
public class DocumentoController {
	
	

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private DocumentoRepository documentoRepository;
	
	
	
	@RequestMapping(method = RequestMethod.POST, 
			value = "**/upload/{pessoaid}", consumes = {"multipart/form-data"})
	public ModelAndView salvarDocumentos(@PathVariable("pessoaid") Long pessoaid, @RequestParam("descricao") String descricao, final MultipartFile file) throws IOException {
		
		Documentos doc = new Documentos();
		Pessoa pessoa = pessoaRepository.findById(pessoaid).get();
	
		ModelAndView modelAndView = new ModelAndView("cadastro/documentos");

	
		doc.setDescricao(descricao);
		doc.setFile(file.getBytes());
		doc.setTipofile(file.getContentType());
		doc.setNomefile(file.getOriginalFilename());
		doc.setPessoa(pessoa);
		
		documentoRepository.save(doc);
		modelAndView.addObject("msg", "Salvo!");
		modelAndView.addObject("pessoaobj", pessoa);
	
		modelAndView.addObject("documentos", documentoRepository.getdocumentos(pessoaid));
		return modelAndView;
		
		
		
		
	}
	
		@GetMapping("**/baixarfile/{iddocumento}")
		public void baixararquivo(@PathVariable("iddocumento")Long iddocumento,
				HttpServletResponse response) throws IOException {
			
			
			
			/*Consultar o objeto pessoa no banco*/
			
			Documentos doc = documentoRepository.findById(iddocumento).get();
			if(doc.getDescricao() != null) {
				
				/*Setar tamanho da resposta*/
				response.setContentLengthLong(doc.getFile().length);
				
				/*Tipo do arquivo para Download*/
				response.setContentType(doc.getTipofile());
				
				/*Define o cabeçalho da resposta*/
			     String headerKey = "Content-Disposition";
			     String headerValue = String.format("attachment;filename=\"%s\"",doc.getNomefile());
			     
			     response.setHeader(headerKey, headerValue);
			     
			     
			     /*Finaliza a resposta*/
			     response.getOutputStream().write(doc.getFile());
			     	
			}
			
		}

		
		@GetMapping("/documentos/{idpessoa}")
		public ModelAndView documentos(@PathVariable("idpessoa") Long idpessoa) {
			
			Optional<Pessoa> pessoa = pessoaRepository.findById(idpessoa);

			ModelAndView modelAndView = new ModelAndView("cadastro/documentos");
			modelAndView.addObject("pessoaobj", pessoa.get());
			modelAndView.addObject("msg", new ArrayList<String>());
			modelAndView.addObject("documentos", documentoRepository.getdocumentos(idpessoa));
			return modelAndView;
			
		}
	

	
	
	
	@GetMapping("/removerdocumento/{iddocumento}")
	public ModelAndView removerdocumentos(@PathVariable("iddocumento") Long iddocumento) {
		
	Pessoa pessoa = new Pessoa();
		
		documentoRepository.deleteById(iddocumento);
		
		ModelAndView modelAndView = new ModelAndView("cadastro/documentos");
		
		modelAndView.addObject("pessoaobj", pessoa);
		modelAndView.addObject("msg", "Documento Excluido!!");
		
		modelAndView.addObject("documentos", documentoRepository.getdocumentos(iddocumento));
		return modelAndView;
		
	}
}
		
	
	

	
	

