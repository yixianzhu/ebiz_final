package Servlet;

import DataAccessObject.Dao;
import Bean.MealBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;


@WebServlet("/PopulateTable")
public class PopulateTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
        private Dao dao;
    public PopulateTable() {
        dao = new Dao();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		List<MealBean> meal=new ArrayList<MealBean>();
		meal=dao.getAlltables();
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(meal, new TypeToken<List<MealBean>>() {}.getType());

		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
                System.out.println(jsonArray);
		response.getWriter().print(jsonArray);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
