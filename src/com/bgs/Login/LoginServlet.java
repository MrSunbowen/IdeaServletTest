package com.bgs.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@WebServlet("/login")
@MultipartConfig
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String username=req.getParameter("username");
        String password=req.getParameter("password");

        Part part=req.getPart("fileName");
        String dirPath=req.getServletContext().getRealPath("/");
//        String fileName=part.getSubmittedFileName();
//        part.write(dirPath+File.separator+fileName);

        String form=part.getContentType();
        String header=part.getHeader("Content-Disposition");
        String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
        part.write(dirPath+File.separator+fileName);
        /*InputStream is=part.getInputStream();
        FileOutputStream fos=new FileOutputStream(dirPath+"\\"+fileName);
        int data=is.read();
        while (data != -1){
            fos.write(data);
            data=is.read();
        }
        fos.close();
        is.close();
*/
        System.out.println(username+"-"+password+"-"+dirPath);
        resp.getWriter().print("<H2>"+username+"-"+password+"<a href='/"+fileName+"'>"+fileName+"</a>"+"</H2>");
    }

}
