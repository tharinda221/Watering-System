package WateringSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Ehelepola on 31/05/2015.
 */
@WebServlet(name = "wateringTime")
public class wateringTime extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Calendar cal = Calendar.getInstance();
        cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( sdf.format(cal.getTime()) );
        String time=sdf.format(cal.getTime());

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date Currentdate = new Date();
        String date = dateFormat.format(Currentdate);


        //String date = req.getParameter("date");
        //String time = req.getParameter("time");
        String wateringtime = req.getParameter("wateringtime");

        String sevDate = (String)req.getServletContext().getAttribute("date");
        String sevTime = (String)req.getServletContext().getAttribute("time");
        String sevWat = (String)req.getServletContext().getAttribute("wateringtime");

        if(sevDate == null || sevTime==null || sevWat==null){

            sevDate = new String(date);
            sevTime=new String(time);
            req.getServletContext().setAttribute("sevDate", sevDate);
            req.getServletContext().setAttribute("sevTime", sevTime);
            sevWat=new String(wateringtime);
            req.getServletContext().setAttribute("sevWat", sevWat);
        }else{

            sevDate = new String(date);
            sevTime=new String(time);
            req.getServletContext().setAttribute("sevDate", sevDate);
            req.getServletContext().setAttribute("sevTime", sevTime);
            sevWat=new String(wateringtime);
            req.getServletContext().setAttribute("sevWat", sevWat);
        }

        req.setAttribute("sevDate", "yes");
        req.setAttribute("sevTime", "yes");
        req.setAttribute("sevWat", "yes");
        System.out.println(sevDate+" "+sevTime+" "+sevWat);
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
