package WateringSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by Ehelepola on 26/04/2015.
 */
@WebServlet(name = "Servlet")
public class Welcome extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


        String moisture = (String)req.getServletContext().getAttribute("moisture");

        String sevDate = (String)req.getServletContext().getAttribute("sevDate");
        String sevTime = (String)req.getServletContext().getAttribute("sevTime");
        String sevWat = (String)req.getServletContext().getAttribute("sevWat");
        System.out.println(sevDate+" "+sevTime+" "+sevWat);
        if(moisture==null){
            req.setAttribute("moisture"," ");

        }else{

            req.setAttribute("moisture",moisture);
        }
        if(sevDate==null || sevTime==null || sevWat==null ){
            req.setAttribute("sevDate"," ");
            req.setAttribute("sevTime"," ");
            req.setAttribute("sevWat"," ");
        }else{
            req.setAttribute("sevDate",sevDate);
            req.setAttribute("sevTime",sevTime);
            req.setAttribute("sevWat",sevWat);
        }

        req.getRequestDispatcher("index.jsp").forward(req, res);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
