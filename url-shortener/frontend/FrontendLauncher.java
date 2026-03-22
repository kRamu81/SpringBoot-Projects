import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;

/**
 * Simple HTTP server to serve the frontend files.
 * Run this from the /frontend directory.
 * Usage: javac FrontendLauncher.java && java FrontendLauncher
 */
public class FrontendLauncher {

    public static void main(String[] args) throws IOException {
        int port = 3000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("✅ Frontend Server running at http://localhost:" + port);
        System.out.println("   Open http://localhost:" + port + " in your browser.");
        System.out.println("   Make sure the Spring Boot backend is running on port 8080.");

        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange t) throws IOException {
                String uri = t.getRequestURI().getPath();
                if (uri.equals("/")) uri = "/index.html";

                File file = new File("." + uri);

                if (file.exists() && !file.isDirectory()) {
                    String method = t.getRequestMethod();
                    String contentType = getContentType(uri);

                    t.getResponseHeaders().set("Content-Type", contentType);
                    t.sendResponseHeaders(200, file.length());

                    if ("GET".equals(method)) {
                        OutputStream os = t.getResponseBody();
                        Files.copy(file.toPath(), os);
                        os.close();
                    } else {
                        t.getResponseBody().close();
                    }
                } else {
                    String response = "404: File Not Found - " + uri;
                    t.sendResponseHeaders(404, response.length());
                    OutputStream os = t.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                }
            }

            private String getContentType(String path) {
                if (path.endsWith(".html")) return "text/html; charset=utf-8";
                if (path.endsWith(".css"))  return "text/css";
                if (path.endsWith(".js"))   return "application/javascript";
                if (path.endsWith(".json")) return "application/json";
                if (path.endsWith(".png"))  return "image/png";
                if (path.endsWith(".jpg") || path.endsWith(".jpeg")) return "image/jpeg";
                return "text/plain";
            }
        });

        server.start();
    }
}
