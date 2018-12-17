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
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RunServlet extends HttpServlet
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
				ModelJsonServer.run = true;
				Message msg = new Message();

				if (ModelJsonServer.run) {
					if (!ModelJsonServer.tmpStack.isEmpty()) { //tmpStak is not null!
						msg = ModelJsonServer.tmpStack.pop();
					}else if (!ModelJsonServer.inMsgQueue.isEmpty()) { //tmpStak is not null!
						msg = ModelJsonServer.inMsgQueue.take();
					}else {
						ModelJsonServer.run = false;
						ModelJsonServer.inMsgQueue.put(msg);
						//break;
					}
					
					ModelJsonServer.mainStack.push(msg);
					inMsg = msg.makeJSON();
					System.out.println("\n[Run]> inMsg: "+ inMsg);
					writer.println(inMsg);
					TimeUnit.SECONDS.sleep(1);

			    }else {
			    	//Doing run in not valid ! null msg will be sent!
			    	inMsg = msg.makeJSON();
			    	writer.println(inMsg);
					TimeUnit.SECONDS.sleep(1);
			    }
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
