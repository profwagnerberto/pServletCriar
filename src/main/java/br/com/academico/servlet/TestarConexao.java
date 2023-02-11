package br.com.academico.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.academico.jdbc.FabricaDeConexoes;

@WebServlet("/TestarConexao")
public class TestarConexao extends HttpServlet {
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse res) {
    Connection con;
    try {
      con = FabricaDeConexoes.pegarConexao();
      FabricaDeConexoes.encerrarRecursosBD(con);
    } catch (Exception e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    
//    Aluno aluno = new Aluno();
//    System.out.println("Criado aluno");
//    aluno.setCpf("5");
//    aluno.setNome("Malcom");
//    System.out.println("Atribuído");
//
//    AlunoDAO alunoDAO = new AlunoDAO();
//    System.out.println("Criado alunoDAO");
//    try {
//      alunoDAO.criar(aluno);
//      System.out.println("Inserido");
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
    
    String html = "" +
"    <!DOCTYPE html>" +
"    <html>" +
"      <head>" +
"        <meta charset='ISO-8859-1'>" +
"      </head>" +
"      <body>" +
"        <p><i>A conexão funcionou.333</i></p>" +
"      </body>" +
"    </html>" +
"";  

    PrintWriter resposta;
    try {
      resposta = res.getWriter();
      resposta.print(html);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}