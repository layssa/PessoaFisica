package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.PessoaFisica;

public class PessoaFisicaJdbcDAO {

	private Connection conn;
	
	public PessoaFisicaJdbcDAO (Connection conn) {
		this.conn = conn;
	} 
	
	public void salvar (PessoaFisica p) throws SQLException {
		String sql = "insert into pessoafisica (cpf, rg, nome, endereco, cidade, bairro, cep, estado, sexo, telefone, celular) values ('"+p.getCpf()+"','"+p.getRg()+"','"+p.getNome()+"','"+p.getEndereco()+"','"+p.getCidade()+"','"+p.getBairro()+"','"+p.getCep()+"','"+p.getEstado()+"','"+p.getSexo()+"','"+p.getTelefone()+"','"+p.getCelular()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatment = this.conn.prepareStatement(sql);
		prepareStatment.executeUpdate();
		prepareStatment.close();
	}
	
	public void imprimir (PessoaFisica p) throws SQLException {
		Statement stm = conn.createStatement(); 
		String sql = "select * from pessoa where cpf = '"+p.getCpf()+"'";
		String sex = "select sexo from pessoa where cpf = '"+p.getCpf()+"'";	
		System.out.println(sql);
		ResultSet rs = stm.executeQuery(sql);
		PreparedStatement prepareStatment = this.conn.prepareStatement(sql);
		this.conn.prepareStatement(sex);
		prepareStatment.execute();
		prepareStatment.close();
	
	

	while(rs.next()){
		view.PessoaFisica pf = new view.PessoaFisica(); 
		//apresentar numa println
		 pf.txtNome.setText(rs.getString("nome"));
		System.out.println("CPF: "+  pf.txtNome);
	}
	}

}
