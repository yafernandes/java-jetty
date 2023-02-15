package com.datadog.lbe;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class App {
	public static void main(String[] args) throws Exception {
		Server server = new Server(9090);
		ServletHandler handler = new ServletHandler();
		server.setHandler(handler);
		handler.addServletWithMapping(SimpleServlet.class, "/hello/*");
		server.start();
		server.join();
	}
}
