package api.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import api.View.View;
import api.contract.InterfaceService;
import api.service.RequestService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/api/request")
public class RequestController extends HttpServlet{
    private InterfaceService service;

    public RequestController() {
        this.service = new RequestService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json ; charset=utf-8");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = resp.getWriter();

        try {
            List<Object> Requests=service.index();
            out.println(View.show(Requests));
            resp.setStatus(HttpServletResponse.SC_OK);
            out.close();
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            System.out.println(e.getMessage());
        }
    }

    
        
    

    }


