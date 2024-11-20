package br.com.lojaCamisa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.lojaCamisa.model.Camisa;


public class CamisaDao {
	private Connection conexao;
	
	public CamisaDao() {
		conexao = ConectionFactory.conectar();
	}
	
	public void inserir (Camisa camisa) {
		String sql = "INSERT INTO camisas (nome, tamanho, descricao, preco)" + "VALUES (?, ?, ?, ?)";
		
		PreparedStatement smtp; // Executar a consulta SQL
		try {
			// preparar a consulta
			smtp = conexao.prepareStatement(sql);
			// Preencher a posicao 1 com o nome da pizza
			smtp.setString(1, camisa.getNome());
			smtp.setString(2, camisa.getTamanho());
			smtp.setString(3, camisa.getDescricao());
			smtp.setDouble(4, camisa.getPreco());
			smtp.execute();
			smtp.close();
			conexao.close();
		} catch (Exception e) {
			System.out.println("Deu erro: " + e.getMessage());
		}
	}
	
	public List<Camisa> listar(){
		String sql = "SELECT * FROM camisas";
		
		PreparedStatement smtp;
		List<Camisa> camisas = new ArrayList<Camisa>();
		try {
			smtp = conexao.prepareStatement(sql);
			ResultSet resultado = smtp.executeQuery();
			// resultado (Lista de pizzas <resultSet>)
			while (resultado.next()) {
				Camisa ca = new Camisa();
				
				ca.setId(resultado.getLong("id"));
				ca.setNome(resultado.getString("nome"));
				ca.setPreco(resultado.getDouble("preco"));
				ca.setDescricao(resultado.getString("descricao"));
				ca.setTamanho(resultado.getString("tamanho"));
				camisas.add(ca);
			}
			resultado.close();
			smtp.close();
			conexao.close();
			return camisas;
			
			
		} catch (Exception e){
			throw new RuntimeException();
		}
		
	}
	
	public Camisa buscar(Long id) {
		String sql = "SELECT * FROM camisas WHERE id = ?";
		
		PreparedStatement smtp;
		
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setLong(1, id);
			ResultSet resultado = smtp.executeQuery();
			Camisa c = null; // não instanciando
			
			while (resultado.next()) {
				c = new Camisa();
				c.setId(resultado.getLong("id"));
				c.setNome(resultado.getString("nome"));
				c.setPreco(resultado.getDouble("preco"));
				c.setDescricao(resultado.getString("descricao"));
				c.setTamanho(resultado.getString("tamanho"));
				
			}
			
			resultado.close();
			smtp.close();
			conexao.close();
			return c;
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public void excluir(Long id) {
		String sql = "DELETE FROM camisas WHERE id = ?";
		
		PreparedStatement smtp;
		
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setLong(1, id);
			
			smtp.execute();
			smtp.close();
			conexao.close();
		}catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public void atualizar(Camisa camisa, Long id) {
		String sql = "UPDATE camisas SET nome = ?, preco = ?, descricao = ?, tamanho = ? WHERE id = ?";
		
		PreparedStatement smtp;
		
		try {
			smtp = conexao.prepareStatement(sql);
			smtp.setString(1, camisa.getNome());
			smtp.setDouble(2, camisa.getPreco());
			smtp.setString(3, camisa.getDescricao());
			smtp.setString(4, camisa.getTamanho());
			smtp.setLong(5, id);
			
			smtp.execute();
			smtp.close();
			conexao.close();
		} catch (Exception e){
			throw new RuntimeException();
		}
	}

}
