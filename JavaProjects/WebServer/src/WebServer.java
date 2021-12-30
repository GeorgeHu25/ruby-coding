import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class WebServer {
	private final int PORT = 8002;
	public static void main(String [] args) throws IOException{
		new WebServer();
		
		
		
	}
	
	public WebServer() throws IOException {
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
			
			server.createContext("/whizkidz", exchange -> {
				System.out.println("Connection to whizkidz page...");
				String response = "<h1 style= 'color:BurlyWood;'><a href ='/Bbob'>Hello Whizkidz<h/1> <img src=https://upload.wikimedia.org/wikipedia/commons/3/34/Jumping_dog_Ryder.jpg>";
				exchange.sendResponseHeaders(200, response.length());
				OutputStream stream = exchange.getResponseBody();
				stream.write(response.getBytes());
				stream.close();
			});
			
			server.createContext("/Bbob" ,exchange->{
					System.out.println("Connection to home page");
					String response = "<h1><a href = '/whizkidz'>Page 1</a></h1><img src = 'https://upload.wikimedia.org/wikipedia/commons/1/16/Greenland_Dog.jpg'> ";
					exchange.sendResponseHeaders(200, response.length());
					OutputStream stream = exchange.getResponseBody();
					stream.write(response.getBytes());
					stream.close();
				});
			
			server.setExecutor(null);
			server.start();
			System.out.println("Server started on port " + PORT);
		} catch(IOException e) {
			System.err.println(e.getMessage());
		}

			

		
		}
	}
	

