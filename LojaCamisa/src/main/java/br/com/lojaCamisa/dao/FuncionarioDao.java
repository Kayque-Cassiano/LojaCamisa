package br.com.lojaCamisa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.lojaCamisa.model.Funcionario;

public class FuncionarioDao {
	
	private Connection conexao;
	
	public FuncionarioDao() {
		conexao = ConectionFactory.conectar();
	}
	
	public void inserir (Funcionario funcionario) {
		String sql = "INSERT INTO funcionarios (nome, cargo, telefone, idade, email)" + "VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement smtp;
			
		try {
			smtp = conexao.prepareStatement(sql);
			
			smtp.setString(1, funcionario.getNome());
			smtp.setString(2, funcionario.getCargo());
			smtp.setString(3, funcionario.getTelefone());
			smtp.setInt(4, funcionario.getIdade());
			smtp.setString(5, funcionario.getEmail());
			smtp.execute();
			smtp.close();
			conexao.close();
			
		} catch (Exception e) {
			System.out.println("Deu erro: " + e.getMessage());
		}
	}
	
	public List<Funcionario> listar(){
		String sql = "SELECT * FROM funcionarios";
		
		PreparedStatement smtp;
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		try {
			smtp = conexao.prepareStatement(sql);
			ResultSet resultado = smtp.executeQuery();
			
			while(resultado.next()){
				Funcionario fu = new Funcionario();
				
				fu.setId(resultado.getLong("id"));
				fu.setNome(resultado.getString("nome"));
				fu.setCargo(resultado.getString("cargo"));
				fu.setTelefone(resultado.getString("telefone"));
				fu.setIdade(resultado.getInt("idade"));
				fu.setEmail(resultado.getString("email"));
				funcionarios.add(fu);
			}
			
			resultado.close();
			smtp.close();
			conexao.close();
			return funcionarios;
			
		}catch (Exception e) {
			
			throw new RuntimeException();
		}
	}
	
	public Funcionario buscar (Long id) {
		String sql = "SELECT * FROM funcionarios WHERE id = ?";
		
		PreparedStatement smtp;
		
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setLong(1, id);
			ResultSet resultado = smtp.executeQuery();
			Funcionario f = null;
			while (resultado.next()) {
				f = new Funcionario();
				f.setId(resultado.getLong("id"));
				f.setNome(resultado.getString("nome"));
				f.setCargo(resultado.getString("cargo"));
				f.setTelefone(resultado.getString("telefone"));
				f.setIdade(resultado.getInt("idade"));
				f.setEmail(resultado.getString("email"));
			}
			
			resultado.close();
			smtp.close();
			conexao.close();
			return f;
			
		} catch (Exception e) {
			throw new RuntimeException() ;
		}
	}
	
	public void excluir (Long id) {
		String sql = "DELETE FROM funcionarios WHERE id = ?";
		
		PreparedStatement smtp;
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setLong(1, id);
			
			smtp.execute();
			smtp.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public void atualizar(Funcionario funcionario, Long id) {
		String sql = "UPDATE funcionarios SET nome = ?, cargo = ?, telefone = ?, idade = ?, email = ? WHERE id = ?";
		System.out.println(id);
		PreparedStatement smtp;
		
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setString(1, funcionario.getNome());
			smtp.setString(2, funcionario.getCargo());
			smtp.setString(3, funcionario.getTelefone());
			smtp.setInt(4, funcionario.getIdade());
			smtp.setString(5, funcionario.getEmail());
			smtp.setLong(6, id);
			
			smtp.execute();
			smtp.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
}
