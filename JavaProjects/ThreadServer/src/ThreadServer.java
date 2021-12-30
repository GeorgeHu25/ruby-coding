import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.*;

import com.sun.net.httpserver.HttpServer;



public class ThreadServer {
	public static void main(String[] args) {
		new ThreadServer();
	}
	
	public ThreadServer() {
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(9000), 0);
			
			server.createContext("/thread", exchange -> {
				String response = Thread.currentThread().getName();
				exchange.sendResponseHeaders(200, responseLength());
				OutputStream stream = exchange.getResponseBody();
				stream.write(response.getBytes());
				stream.close();
			});
			
			ExecutorService service = Executors.newFixedThreadPool(10);
			server.setExecutor(service);
			server.start();
		} catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}

	private long responseLength() {
		// TODO Auto-generated method stub
		return 0;
	}
}
