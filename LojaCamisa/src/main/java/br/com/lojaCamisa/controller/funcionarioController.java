package br.com.lojaCamisa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.lojaCamisa.dao.FuncionarioDao;
import br.com.lojaCamisa.model.Funcionario;

@Controller
public class funcionarioController {
	
	@RequestMapping("/homeFun")
	public String homeFun(Model model) {
		
		FuncionarioDao dao = new FuncionarioDao();
		
		model.addAttribute("funcionarios", dao.listar());
		
	    return "homeFun";  // Certifique-se de que a view está no local correto.
	}
	
	@RequestMapping("/formulario")
	public String formulario(Long idFuncionario, Model model) {
		FuncionarioDao dao = new FuncionarioDao();
		
		Funcionario f = new Funcionario();
		
		if (idFuncionario != null) {
			f = dao.buscar(idFuncionario);
		}
		
		model.addAttribute("funcionario", f);
		
	    return "formulario";
	}
	
	@RequestMapping("/funcionario")
	public String funcionario(Long idFuncionario, Model model) {
		
		FuncionarioDao dao = new FuncionarioDao();
		
		model.addAttribute("funcionario", dao.buscar(idFuncionario));
		
		return "funcionario";
	}
	
	@RequestMapping(value = "adicionarFuncionario", method = RequestMethod.POST)
	public String adicionarFuncionario(Funcionario funcionario) {
		FuncionarioDao dao = new FuncionarioDao(); 
		dao.inserir(funcionario);
		return "redirect:homeFun";
	}
	
	
	@RequestMapping(value = "atualizarFuncionario", method = RequestMethod.POST)
	public String atualizarFuncionario(Long idFuncionario, Funcionario f) {
		FuncionarioDao dao = new FuncionarioDao();
		
		dao.atualizar(f, idFuncionario);
		
		return "redirect:homeFun";
	}
	
	@RequestMapping("deletarFuncionario")
	public String deletarCamisa(Long idFuncionario) {
		FuncionarioDao dao = new FuncionarioDao();
		
		dao.excluir(idFuncionario);
		
		return "redirect:homeFun";
	}
	
}
