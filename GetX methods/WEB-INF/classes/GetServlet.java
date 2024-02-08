import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author kaviprakashramalingam
 */
public class GetServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handle(req, resp);
    }

    public void handle(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        StringBuilder txt = new StringBuilder();

        txt.append("<html>");
        txt.append("<h1>HttpServletRequest getX() methods</h1>");
        txt.append("<body>");
        txt.append("<label>getAuthType(): ");
        txt.append(req.getAuthType() == null ? "-" : req.getAuthType());
        txt.append("</label><br/>");
        txt.append("<label>getContextPath(): ");
        txt.append(req.getContextPath() == null ? "-" : req.getContextPath());
        txt.append("</label><br/>");

        txt.append("<label>getCookies(): ");
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            Iterator<Cookie> cookiesIterator = Arrays.stream(cookies).iterator();
            while (cookiesIterator.hasNext()) {
              Cookie cookie = cookiesIterator.next();
               txt.append("Name: ");
               txt.append(cookie.getName());
               txt.append(" and ");
               txt.append("Value: ");
               txt.append(cookie.getValue());
                if (cookiesIterator.hasNext()) {
                txt.append(",");
            }}
        } else {
            txt.append("-");
        }
           txt.append("</label><br>");
        String headerName = "If-Modified-Since";
        long dateHeaderValue = req.getDateHeader(headerName);
        String formattedDate = (dateHeaderValue == -1) ? "-" : formatDate(dateHeaderValue);
        txt.append("<label>getDateHeader(").append(headerName).append("): ");
        txt.append(formattedDate);
        txt.append("</label><br/>");

        txt.append("<label>getHeader(): ");
        txt.append(req.getHeader("host") == null ? "-" : req.getHeader("host"));
        txt.append("</label><br/>");

        Enumeration<String> getHeaderNames = req.getHeaderNames();
        txt.append("<label>getHeaderNames(): ");
        if (getHeaderNames.hasMoreElements()) {
            Iterator<String> getHeaderNamesIterator = getHeaderNames.asIterator();
            while (getHeaderNamesIterator.hasNext()) {
              String getHeaderName = getHeaderNamesIterator.next();
              txt.append(getHeaderName);
              if (getHeaderNamesIterator.hasNext()) {
              txt.append(", ");
              }}
        } else {
            txt.append("-");
        }
        txt.append("</label><br/>");

        txt.append("<label>getHeaders(name): ");
        getHeaderNames = req.getHeaderNames();
        if (getHeaderNames.hasMoreElements()) {
            txt.append("<br>");
            Iterator<String> headerNamesIterator = getHeaderNames.asIterator();
            while (headerNamesIterator.hasNext()) {
              headerName = headerNamesIterator.next();
              txt.append("getHeaders(").append(headerName).append(")").append(": ");
              Enumeration<String> headers = req.getHeaders(headerName);
              if (headers.hasMoreElements()) {
                Iterator<String> headersIterator = headers.asIterator();
                while (headersIterator.hasNext()) {
                    String header = headersIterator.next();
                    txt.append(header);
                    if (headersIterator.hasNext()) {
                        txt.append(", ");
                    }
                    }
               } else {
                    txt.append("-");
               }
                if (headerNamesIterator.hasNext()) {
                txt.append("<br>");
                }
            }
        } else {
            txt.append("-");
        }
        txt.append("</label><br>");

        txt.append("<label>getIntHeader(name): ");
        txt.append("-");
        txt.append("</label><br>");

        txt.append("<label>getMethod(): ");
        txt.append(req.getMethod());
        txt.append("</label><br>");

        txt.append("<label>getPart(name): -");
        txt.append("</label><br>");

        txt.append("<label>getParts(): -");
        txt.append("</label><br>");

        txt.append("<label>getPathInfo(): ");
        txt.append(req.getPathInfo() == null ? "-" : req.getPathInfo());
        txt.append("</label><br>");

        txt.append("<label>getPathTranslated(): ");
        txt.append(req.getPathTranslated() == null ? "-" : req.getPathTranslated());
        txt.append("</label><br>");

        txt.append("<label>getQueryString(): ");
        txt.append(req.getQueryString() == null ? "-" : req.getQueryString());
        txt.append("</label><br>");

        txt.append("<label>getRemoteUser(): ");
        txt.append(req.getRemoteUser() == null ? "-" : req.getRemoteUser());
        txt.append("</label><br>");

        txt.append("<label>getRequestedSessionId(): ");
        txt.append(req.getRequestedSessionId() == null ? "-" : req.getRequestedSessionId());
        txt.append("</label><br>");

        txt.append("<label>getRequestURI(): ");
        txt.append(req.getRequestURI() == null ? "-" : req.getRequestURI());
        txt.append("</label><br>");

        txt.append("<label>getRequestURL(): ");
        txt.append(req.getRequestURL() == null ? "-" : req.getRequestURL());
        txt.append("</label><br>");

        txt.append("<label>getServletPath(): ");
        txt.append(req.getServletPath() == null ? "-" : req.getServletPath());
        txt.append("</label><br>");

        txt.append("<label>getSession(): ");
        HttpSession session = req.getSession();
        if (session != null) {
            txt.append("Your session ID is  ").append(session.getId());
        } else {
            txt.append("-");
        }
        txt.append("</label><br>");

        txt.append("<label>getUserPrincipal(): ");
        Principal userPrincipal = req.getUserPrincipal();
        if (userPrincipal != null) {
            txt.append(userPrincipal.getName());
        } else {
            txt.append("-");
        }
        txt.append("</label><br><br><br>");

        txt.append("<h1>ServletRequest methods</h1>");
        txt.append("<label>getAsyncContext(): -");
        txt.append("</label><br>");

        txt.append("<label>getAttributeNames(): ");
        Enumeration<String> attributeNames = req.getAttributeNames();
        if (attributeNames.hasMoreElements()) {
            Iterator<String> attributeNamesIterator = attributeNames.asIterator();
            while (attributeNamesIterator.hasNext()) {
             String att_name = attributeNamesIterator.next();
             txt.append(att_name);
             if (attributeNamesIterator.hasNext()) {
                txt.append(", ");
              }
           }
        } else {
            txt.append("-");
        }
        txt.append("</label><br>");

        txt.append("<label>getAttribute(name): ");
        if (attributeNames.hasMoreElements()) {
            Iterator<String> attributeNamesIterator = attributeNames.asIterator();
            while (attributeNamesIterator.hasNext()) {
                String name = attributeNamesIterator.next();
                txt.append(name);
                if (attributeNamesIterator.hasNext()) {
                   String attributeName = attributeNamesIterator.next();
                   txt.append("getAttribute(").append(attributeName).append(")").append(": ");
                   Enumeration<String> headers = req.getHeaders(attributeName);
                   if (headers.hasMoreElements()) {
                        Iterator<String> headersIterator = headers.asIterator();
                        while (headersIterator.hasNext()) {
                            String header = headersIterator.next();
                            txt.append(header);
                            if (headersIterator.hasNext()) {
                                txt.append(", ");
                            }
                        }
                    } else {
                        txt.append("-");
                    }
                    if (attributeNamesIterator.hasNext()) {
                        txt.append(", ");
                    }
                }
            }
        } else {
            txt.append("-");
        }
        txt.append("</label><br>");

        txt.append("<label>getCharacterEncoding(): ");
        txt.append(req.getCharacterEncoding() == null ? "-" : req.getCharacterEncoding());
        txt.append("</label><br>");

        txt.append("<label>getContentLength(): ");
        txt.append(req.getContentLength());
        txt.append("</label><br>");

        txt.append("<label>getContentLengthLong(): ");
        txt.append(req.getContentLengthLong());
        txt.append("</label><br>");

        txt.append("<label>getContentType(): ");
        txt.append(req.getContentType() == null ? "-" : req.getContentType());
        txt.append("</label><br>");

        txt.append("<label>getDispatcherType(): ");
        txt.append(req.getDispatcherType() == null ? "-" : req.getDispatcherType());
        txt.append("</label><br/>");

//        InputStream inputStream = req.getInputStream();
//        byte[] buffer = new byte[1024];
//        int bytesRead;
//        StringBuilder requestBody = new StringBuilder();
//        while ((bytesRead = inputStream.read(buffer)) != -1) {
//            requestBody.append(new String(buffer, 0, bytesRead));
//        }
//        txt.append("<label>getInputStream(): ");
//        txt.append(requestBody.toString());
//        txt.append("</label><br/>");

        txt.append("<label>getLocalAddr(): ");
        txt.append(req.getLocalAddr() == null ? "-" : req.getLocalAddr());
        txt.append("</label><br>");

        txt.append("<label>getLocale() : ");
        Locale locale = req.getLocale();
        if (locale != null) {
            txt.append(locale.getCountry());
        } else {
            txt.append("-");
        }
        txt.append("</label><br>");

        txt.append("<label>getLocales() :");
        Enumeration<Locale> locales = req.getLocales();
        if (locales.hasMoreElements()) {
            Iterator<Locale> localesIterator = locales.asIterator();
            while (localesIterator.hasNext()) {
                Locale locale1 = localesIterator.next();
                if (locale1 != null) {
                    txt.append(locale1.getCountry());
                    if (localesIterator.hasNext()) {
                        txt.append(", ");
                    }
                }
            }
        } else {
            txt.append("-");
        }
        txt.append("</label><br>");

        txt.append("<label>getLocalName(): ");
        txt.append(req.getLocalName() == null ? "-" : req.getLocalName());
        txt.append("</label><br>");

        txt.append("<label>getParameterMap(): ");
        Map<String, String[]> parameterMap = req.getParameterMap();
        if (parameterMap.isEmpty()) {
            txt.append("-");
        } else {
            parameterMap.forEach((name, param) -> {
                txt.append("<label>");
                txt.append(name).append(": ");
                Iterator<String> paramIterator = Arrays.stream(param).iterator();
                while (paramIterator.hasNext()) {
                    txt.append(paramIterator.next());
                    if (paramIterator.hasNext()) {
                        txt.append(",");
                    }
                }
                txt.append("</label><br>");
            });
        }
        txt.append("</label><br>");

        txt.append("<label>getParameterNames(): ");
        Enumeration<String> parameterNames = req.getParameterNames();
        if (parameterNames.hasMoreElements()) {
            Iterator<String> parameterNamesIterator = parameterNames.asIterator();
            while (parameterNamesIterator.hasNext()) {
                String name = parameterNamesIterator.next();
                txt.append(name);
                if (parameterNamesIterator.hasNext()) {
                    txt.append(", ");
                }
            }
        } else {
            txt.append("-");
        }
        txt.append("</label><br>");

        txt.append("<label>getParameterValues(): ");
        if (parameterNames.hasMoreElements()) {
            Iterator<String> parameterNamesIterator = parameterNames.asIterator();
            while (parameterNamesIterator.hasNext()) {
                String name = parameterNamesIterator.next();
                String[] parameterValues = req.getParameterValues(name);
                txt.append("getParameterValues(").append(name).append("): ");
                if (parameterValues.length > 0) {
                    Iterator<String> parameterValuesIterator = Arrays.stream(parameterValues).iterator();
                    while (parameterValuesIterator.hasNext()) {
                        String parameterValue = parameterValuesIterator.next();
                        txt.append(parameterValue);
                        if (parameterValuesIterator.hasNext()) {
                            txt.append(", ");
                        }
                    }
                }
                if (parameterNamesIterator.hasNext()) {
                    txt.append(", ");
                }
            }
        }

        txt.append("<label>getProtocol(): ");
        txt.append(req.getProtocol() == null ? "-" : req.getProtocol());
        txt.append("</label><br>");

        BufferedReader reader = req.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        txt.append("<label>getReader(): ");
        txt.append(requestBody.toString());
        txt.append("</label><br/>");

        txt.append("<label>getRemoteAddr(): ");
        txt.append(req.getRemoteAddr() == null ? "-" : req.getRemoteAddr());
        txt.append("</label><br>");

        txt.append("<label>getRemoteHost(): ");
        txt.append(req.getRemoteHost() == null ? "-" : req.getRemoteHost());
        txt.append("</label><br>");

        txt.append("<label>getRemotePort(): ");
        txt.append(req.getRemotePort());
        txt.append("</label><br>");

        txt.append("<label>getScheme(): ");
        txt.append(req.getScheme() == null ? "-" : req.getScheme());
        txt.append("</label><br>");

        txt.append("<label>getServerName(): ");
        txt.append(req.getServerName() == null ? "-" : req.getServerName());
        txt.append("</label><br>");

        txt.append("<label>getServerPort(): ");
        txt.append(req.getServerPort());
        txt.append("</label><br>");

        txt.append("<label>getServletContext(): ");
        txt.append(req.getServletContext() == null ? "-" : req.getServletContext().getServletContextName());
        txt.append("</label><br/>");

        txt.append("</body>");
        txt.append("</html>");
        out.println(txt);
        out.flush();
    }

    private String formatDate(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
        return sdf.format(new Date(timestamp));
    }
}
