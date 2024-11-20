package br.com.lojaCamisa.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConectionFactory {
	private static final String USER = "root";
	private static final String SENHA = "root";
	
	public static Connection conectar() {
		// java database connection
		try {
			// invocar a biblioteca de conexao ao banco de dados
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojaCamisa", USER, SENHA);
			return conexao;
		} catch (Exception e) {
			// throw -> jogar para cima
			// RuntimeException -> Erro que aconteceu enquanto o codigo rodava
			throw new RuntimeException();
		}
	}
}
