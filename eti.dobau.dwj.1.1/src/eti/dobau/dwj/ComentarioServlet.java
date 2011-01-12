package eti.dobau.dwj;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value="/comentario")
public class ComentarioServlet extends HttpServlet {

	private static final long serialVersionUID = -2023985544401694948L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String comentario = request.getParameter("comentario");

		if (comentario != null && !comentario.isEmpty()) {
			HttpSession session = request.getSession();
			this.armazenaComentario(session, comentario);
		}

		this.getServletContext()
			.getRequestDispatcher("/")
			.forward(request, response);
	}

	/**
	 *
	 * @param session
	 * @param comentario
	 */
	private void armazenaComentario(HttpSession session, String comentario) {
		this.getComentarios(session).add(comentario);
	}

	/**
	 *
	 * @param session
	 * @return
	 */
	private Vector<String> getComentarios(HttpSession session) {
		Vector<String> comentarios = (Vector<String>) session.getAttribute("comentarios");

		if (comentarios == null) {
			comentarios = new Vector<String>();
			session.setAttribute("comentarios", comentarios);
		}

		return comentarios;
	}

}
