package com.iness.servlets;

import com.google.gson.Gson;
import com.iness.dao.main.AbstractDao;
import com.iness.json.AbstractsHolder;
import com.iness.model.main.Abstract;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/abstracts")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf8");
        response.setContentType("application/json");

        AbstractDao abstractDao = new AbstractDao();
        List<Abstract> abstractsOral = abstractDao.getAbstractsByType(true);
        List<Abstract> abstractsPoster = abstractDao.getAbstractsByType(false);

        AbstractsHolder holder = new AbstractsHolder();
        holder.setOral(abstractsOral);
        holder.setPoster(abstractsPoster);

        Gson gson = new Gson();
        response.setStatus(200);
        response.getWriter().println(gson.toJson(holder));
        response.getWriter().close();
    }
}