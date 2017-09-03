package pl.coderslab.web.Homework_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet_01_Homework_01")
public class Servlet_01_Homework_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File file = new File("C:\\Users\\Gosia\\Documents\\CodersLab\\Zadania\\WAR_JAVA_W_01_JEE_Servlety_solutions\\Servlety\\src\\pl\\coderslab\\web\\Homework_01\\oop.txt");
		StringBuilder reading = new StringBuilder();
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				reading.append(scan.nextLine() + "<br>");
				
			}scan.close();
		} catch (FileNotFoundException e) {
			response.getWriter().append("brak pliku");
		}
		response.getWriter().append(reading.toString());
		

	}

}
