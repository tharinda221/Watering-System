package WateringSystem;


import java.io.*;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class WateringSystem extends HttpServlet {


    private static String username="user";


    public void init() throws ServletException {

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String mos = req.getParameter("mos");

        String moisture = (String)req.getServletContext().getAttribute("moisture");

        if(moisture==null){

            moisture=new String(mos);
            req.getServletContext().setAttribute("moisture", moisture);
        }else{

            moisture=new String(mos);
            req.getServletContext().setAttribute("moisture", moisture);
        }
        req.setAttribute("moisture", "yeah");
        System.out.println(mos);

        try {
            DataHandle d=new DataHandle();

//            if(d.checkUser(username)){
//                d.updateOnlineData(username,temp,mos,hum);6
//            }
//            else{
//                d.insertOnlineData(username,temp,mos,hum);
//            }


            req.getRequestDispatcher("index.jsp").forward(req, res);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
        //implement doPost method to handle post requests.
    }
}
