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
import java.util.Base64;

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
        HttpSession session = req.getSession();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String country = req.getParameter("country");
        String[] hobbys = req.getParameterValues("hobby");
        StringBuilder hobby = new StringBuilder();
        if (hobbys != null) {
            for (int i = 0; i < hobbys.length; i++) {
              hobby.append(hobbys[i]);
              if (i != hobbys.length - 1) {
                hobby.append(", ");
              }
            }
          }
        String address = req.getParameter("address");
        Part image = req.getPart("picture");
        InputStream inputStream = image.getInputStream();
        byte[] bytes = inputStream.readAllBytes();
        String encodedString = Base64.getEncoder().encodeToString(bytes);
        // Handle file upload
        // Part filePart = req.getPart("picture");
        // if(!filePart.equals(null)){
        // String fileName = extractFileName(filePart);
        // String uploadPath = "/Users/kaviprakashramalingam/Desktop/Images/" + fileName;
        // // }
        // // if(!fileName.equals("")){
        // try (InputStream input = filePart.getInputStream()) {
        //     Files.copy(input, Path.of(uploadPath), StandardCopyOption.REPLACE_EXISTING);
        //     session.setAttribute("image", fileName);
        // }}
        
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        session.setAttribute("gender", gender);
        session.setAttribute("country", country);
        session.setAttribute("hobby", hobby);
        session.setAttribute("address", address);
        session.setAttribute("image", encodedString);
        HttpSession ses = req.getSession();

        out.println("<html>");
        out.println("<body>");
        out.println("<h3>Email: " + ses.getAttribute("email") + "</h3>");
        out.println("<h3>Password: " + ses.getAttribute("password") + "</h3>");
        out.println("<h3>Uploaded Picture: " + ses.getAttribute("image") + "</h3>");
        out.println("<h3>Gender: " + ses.getAttribute("gender") + "</h3>");
        out.println("<h3>Country: " + ses.getAttribute("country") + "</h3>");
        out.println("<h3>Hobby: " + ses.getAttribute("hobby") + "</h3>");
        out.println("<h3>Address: " + ses.getAttribute("address") + "</h3>");
        out.println("<img src=\""
        + "data:image/png;base64, "+ses.getAttribute("image")
        + "\" height=\"500\" width=\"500\"/><br>");
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
