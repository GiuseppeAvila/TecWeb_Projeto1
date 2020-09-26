package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.Tasks;

/**
 * Servlet implementation class Adiciona
 */
@WebServlet("/Adiciona")
public class Adiciona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adiciona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DAO dao;
		
		try {
			dao = new DAO();
			
			Tasks task = new Tasks();
			
			task.setTitle(request.getParameter("title"));
			task.setCreator(request.getParameter("creator"));
			task.setTag(request.getParameter("tag"));
			
			dao.adiciona(task);
			
			request.setAttribute("tasks",task);
			RequestDispatcher dispatcher = request.getRequestDispatcher("lista.jsp");
			dispatcher.forward(request, response);
			
			dao.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
