package WateringSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Ehelepola on 31/05/2015.
 */
@WebServlet(name = "ajaxHandle")
public class ajaxHandle extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String moisture = (String)req.getServletContext().getAttribute("moisture");
        String output="";
        if(moisture==null){

            output="nodata";
        }else{
            output=moisture;
        }
        //System.out.println(output+" ajaxHandle");
        //req.getRequestDispatcher("index.jsp").forward(req, res);
        res.addHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = res.getWriter();
        out.println(output);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
