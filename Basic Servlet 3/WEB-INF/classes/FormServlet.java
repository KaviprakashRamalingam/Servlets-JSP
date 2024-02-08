import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Enumeration;

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
    
    public FormServlet (){
        System.out.println("called");
    }

    public void handle(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<body>");

        HttpSession session = req.getSession();

        // Handle file upload separately
        // Part filePart = req.getPart("picture");
        // String fileName = extractFileName(filePart);
        // String uploadPath = "/Users/kaviprakashramalingam/Desktop/Images/" + fileName;
        // if (!fileName.equals("")){
        // try (InputStream input = filePart.getInputStream()) {
        //     Files.copy(input, Path.of(uploadPath), StandardCopyOption.REPLACE_EXISTING);
        //     out.println("<h3>Uploaded Picture: " + fileName + "</h3>");
        // }}

        // Get parameter names enumeration
        Enumeration<String> paramNames = req.getParameterNames();

        // Iterate through parameter names
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String paramValue = req.getParameter(paramName);
            session.setAttribute(paramName, paramValue);
            out.println("<h3>" + paramName + ": " + paramValue + "</h3>");
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
