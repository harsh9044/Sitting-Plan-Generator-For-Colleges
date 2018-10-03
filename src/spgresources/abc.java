package spgresources;

import java.io.File;

import java.io.IOException;

import java.io.PrintWriter;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;

import javax.servlet.annotation.MultipartConfig;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.example.dao.Dao;


@WebServlet(urlPatterns = {"/abc"})

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 100)

public class abc extends HttpServlet {

// this if directory name where the file will be uploaded and saved

private static final String SAVE_DIR = "files";

// this is the method which is created by system it self

protected void processRequest(HttpServletRequest request, HttpServletResponse response)

throws ServletException, IOException {

response.setContentType("text/html;charset=UTF-8");

try (PrintWriter out = response.getWriter()) {

// this tyr is created by me for the connection of database

try {

// this is the path provide by me to save the image

String savePath = "D:" + File.separator + File.separator+ SAVE_DIR;

/*in place of C: you can place a path wher you need to save the image*/

// this comment will picup the image file and have convert it into file type

File fileSaveDir = new File(savePath);

if (!fileSaveDir.exists()) {

fileSaveDir.mkdir();

}

// this two comment will take the name and image form web page

String name = request.getParameter("name");

Part part = request.getPart("file");

// this comment will extract the file name of image

String fileName = extractFileName(part);

// this will print the image name and user provide name

out.println(fileName);

out.println("\n" + name);

/*if you may have more than one files with same name then you can calculate

some random characters and append that characters in fileName so that it will

make your each image name identical.*/

part.write(savePath + File.separator + fileName);

/*

You need this loop if you submitted more than one file

for (Part part : request.getParts()) {

String fileName = extractFileName(part);

part.write(savePath + File.separator + fileName);

}*/

// connection to database


PreparedStatement pst=Dao.getCon().prepareStatement("INSERT INTO record (name,path) values (?, ?)");

pst.setString(1,name);
String filePath = savePath + File.separator + File.separator + fileName;
pst.setString(2,filePath);
pst.executeQuery();





} catch (Exception ex) {

out.println("error" + ex);

}

}

}

// the extractFileName() is method used to extract the file name

private String extractFileName(Part part) {

String contentDisp = part.getHeader("content-disposition");

String[] items = contentDisp.split(";");

for (String s : items) {

if (s.trim().startsWith("filename")) {

return s.substring(s.indexOf("=") + 2, s.length() - 1);

}

}

return "";

}

@Override

protected void doGet(HttpServletRequest request, HttpServletResponse response)

throws ServletException, IOException {

processRequest(request, response);

}

@Override

protected void doPost(HttpServletRequest request, HttpServletResponse response)

throws ServletException, IOException {

processRequest(request, response);

}

@Override

public String getServletInfo() {

return "Short description";

}// 

}

