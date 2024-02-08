import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;

/**
 *
 * @author kaviprakashramalingam
 */
public class FormServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handle(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handle(req, resp);
    }

    public void handle(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Map<String, String[]> paramMap = req.getParameterMap();
        out.println("<html>");
        out.println("<body>");
        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            String paramName = entry.getKey();
            String[] paramValues = entry.getValue();

            if (paramName.equals("picture")) {
                // Part filePart = req.getPart("picture");
                String fileName = req.getPart("picture");
                // String uploadPath = "/Users/kaviprakashramalingam/Desktop/Images/" + fileName;

                // try (InputStream input = filePart.getInputStream()) {
                //     Files.copy(input, Path.of(uploadPath), StandardCopyOption.REPLACE_EXISTING);
                // }

                out.println("<h3>Uploaded Picture: " + fileName + "</h3>");
            } else {
                // Handle other parameters
//            session.setAttribute(paramName, paramValues[0]);
                out.println("<h3>" + paramName + ": " + paramValues[0] + "</h3>");
            }
        }
        out.println("</body>");
        out.println("</html>");
    }

    // private String extractFileName(Part part) {
    //     String contentDisposition = part.getHeader("content-disposition");
    //     String[] tokens = contentDisposition.split(";");
    //     for (String token : tokens) {
    //         if (token.trim().startsWith("filename")) {
    //             return token.substring(token.indexOf("=") + 2, token.length() - 1);
    //         }
    //     }
    //     return "";
    // }
}
