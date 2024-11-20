package br.com.lojaCamisa.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.lojaCamisa.dao.CamisaDao;
import br.com.lojaCamisa.dao.ConectionFactory;
import br.com.lojaCamisa.model.Camisa;

//Anotação
@Controller
public class indexController {
	
	@RequestMapping("/")
	public String inicio() {
		ConectionFactory.conectar();
		
		return "redirect:home";
	}
	
	
	@RequestMapping("/home") // http://localhost:8080 /
	//String -> Retorno de uma pagina
	public String index(Model model) {
		CamisaDao dao = new CamisaDao();
		
		model.addAttribute("camisas", dao.listar());
		
		
		return "home"; // home.html
	}
	
	@RequestMapping("/form")
	public String form(Long idCamisa, Model model) {
		CamisaDao dao = new CamisaDao();
		
		Camisa c = new Camisa();
		
		if (idCamisa != null) {
			c = dao.buscar(idCamisa);
		}
		
		model.addAttribute("camisa", c);
		
		return "form"; // form.html
	}
	
	@RequestMapping ("/pizza")
	public String pizza(Long idCamisa, Model model) {
		
		CamisaDao dao = new CamisaDao();
		
		model.addAttribute("camisas", dao.buscar(idCamisa));
		
		return "pizza";
	}
	
	@RequestMapping(value = "adicionarCamisa", method = RequestMethod.POST)
	public String adicionarCamisa(Camisa camisa) {
		CamisaDao dao = new CamisaDao(); 
		dao.inserir(camisa);
		return "redirect:home";
	}
	
	@RequestMapping(value = "atualizarCamisa", method = RequestMethod.POST)
	public String atualizarCamisa(Long idCamisa, Camisa c) {
		CamisaDao dao = new CamisaDao();
		
		dao.atualizar(c, idCamisa);
		
		return "redirect:home";
	}
	
	@RequestMapping("deletarCamisa")
	public String deletarCamisa(Long idCamisa) {
		
		CamisaDao dao = new CamisaDao();
		dao.excluir(idCamisa);
		
		return "redirect:home";
	}
}
