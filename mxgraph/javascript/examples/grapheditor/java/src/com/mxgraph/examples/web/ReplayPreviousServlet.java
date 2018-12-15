package com.mxgraph.examples.web;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ReplayPreviousServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4442397463551836919L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		OutputStream out = response.getOutputStream();
		String encoding = request.getHeader("Accept-Encoding");

		// Supports GZIP content encoding
		if (encoding != null && encoding.indexOf("gzip") >= 0)
		{
			response.setHeader("Content-Encoding", "gzip");
			out = new GZIPOutputStream(out);
		}

		PrintWriter writer = new PrintWriter(out);
		//writer.println("<html>");
		//writer.println("<head>");
		//writer.println("</head>");
		//writer.println("<body>");
		//writer.println("<script type=\"text/javascript\">");

		try
		{
			if (request.getContentLength() < Constants.MAX_REQUEST_SIZE)
			{
				//Map<String, String> post = parseMultipartRequest(request);
				//String xml = new String(post.get("upfile").getBytes(ENCODING),"UTF-8");
				//String filename = post.get("filename");

				// Uses JavaScript to load the XML on the client-side
				//String name=request.getParameter("name");
				String inMsg = "";
				Message msg = new Message();
				
				if (!ModelJsonServer.inMsgQueue.isEmpty()) {
					msg= ModelJsonServer.inMsgQueue.take();
					inMsg = msg.makeJSON();
					System.out.println("\n["+ Thread.currentThread().getName() +"]> inMsg: "+ inMsg);

				//writer.println("console.log(content:"+msg+");");
					//JSONObject jsonObj = new JSONObject();
					
					//JSONArray list = new JSONArray();
					//list.add(msg.getCapsuleName()); list.add(msg.getItemName());
					//jsonObj.put("list", list);
					//inMsg = jsonObj.toJSONString();
				}
				else {
					writer.println("Empty Queue");
				}
				
				writer.println(inMsg);
				
			}
			else
			{
				error(writer, "drawingTooLarge");
			}
		}
		catch (Exception e)
		{
			error(writer, "invalidOrMissingFile");
		}

		//writer.println("</script>");
		//writer.println("</body>");
		//writer.println("</html>");

		writer.flush();
		writer.close();
	}

	public static void error(PrintWriter w, String key)
	{
		w.println("<b><p>ERROR in MY CODE </p></b>");
	}

	

}
