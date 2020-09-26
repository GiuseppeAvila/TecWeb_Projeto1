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
 * Servlet implementation class Edita
 */
@WebServlet("/Edita")
public class Edita extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edita() {
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
			
			task.setId(Integer.valueOf(request.getParameter("id")));
			task.setTitle(request.getParameter("title"));
			task.setCreator(request.getParameter("creator"));
			task.setTag(request.getParameter("tag"));
			
			dao.edita(task);
			
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
