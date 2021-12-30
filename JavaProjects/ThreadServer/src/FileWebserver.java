import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.*;
import java.util.concurrent.*;

import com.sun.net.httpserver.HttpServer;

public class FileWebserver {
	public static void main(String[] args) {
		new FileWebserver();
	}
	
	public FileWebserver() {
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
			
			server.createContext("/", exchange -> {
				System.out.println("Request...");
				String pathStr = exchange.getRequestURI().getPath().substring(1);
				Path path = Paths.get(pathStr);
//				System.out.println(path.toRealPath());
				byte[] response = new byte[0];
				try {
					Path realPath = path.toRealPath();
					System.out.println(realPath);
					response = Files.readAllBytes(realPath);
					exchange.sendResponseHeaders(200, response.length);
					
				} catch(NoSuchFileException e) {
					exchange.sendResponseHeaders(404, response.length);
				}
				
				OutputStream stream = exchange.getResponseBody();
				stream.write(response);
				stream.close();
			});
			ExecutorService service = Executors.newFixedThreadPool(10);
			server.setExecutor(service);
			server.start();
		} catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
