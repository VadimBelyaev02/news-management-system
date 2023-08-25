package com.vadim.userservice.util.constants;

public class Html {

    public final static String HTML_FORM = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"UTF-8\">\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<style>\n" +
            "  body {\n" +
            "    font-family: Arial, sans-serif;\n" +
            "    background-color: #f4f4f4;\n" +
            "    margin: 0;\n" +
            "    padding: 0;\n" +
            "    display: flex;\n" +
            "    justify-content: center;\n" +
            "    align-items: center;\n" +
            "    height: 100vh;\n" +
            "  }\n" +
            "\n" +
            "  .form-container {\n" +
            "    background-color: #ffffff;\n" +
            "    padding: 20px;\n" +
            "    border-radius: 8px;\n" +
            "    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n" +
            "    text-align: center;\n" +
            "  }\n" +
            "\n" +
            "  .btn {\n" +
            "    padding: 10px 20px;\n" +
            "    background-color: #3498db;\n" +
            "    color: #ffffff;\n" +
            "    border: none;\n" +
            "    border-radius: 4px;\n" +
            "    cursor: pointer;\n" +
            "    font-size: 16px;\n" +
            "  }\n" +
            "\n" +
            "  .btn:hover {\n" +
            "    background-color: #2980b9;\n" +
            "  }\n" +
            "</style>\n" +
            "<title>I</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "  <div class=\"form-container\">\n" +
            "    <form method=\"post\" action=\"%s\">\n" +
            "      <input type=\"submit\" class=\"btn\" value=\"Confirm email\">\n" +
            "    </form>\n" +
            "  </div>\n" +
            "</body>\n" +
            "</html>\n";
    public static String getHtmlForm(String title, String URL) {
     //   return String.format(HTML_FORM, URL);
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "<style>\n" +
                "  body {\n" +
                "    font-family: Arial, sans-serif;\n" +
                "    background-color: #f4f4f4;\n" +
                "    margin: 0;\n" +
                "    padding: 0;\n" +
                "    display: flex;\n" +
                "    justify-content: center;\n" +
                "    align-items: center;\n" +
                "    height: 100vh;\n" +
                "  }\n" +
                "\n" +
                "  .form-container {\n" +
                "    background-color: #ffffff;\n" +
                "    padding: 20px;\n" +
                "    border-radius: 8px;\n" +
                "    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\n" +
                "    text-align: center;\n" +
                "  }\n" +
                "\n" +
                "  .btn {\n" +
                "    padding: 10px 20px;\n" +
                "    background-color: #3498db;\n" +
                "    color: #ffffff;\n" +
                "    border: none;\n" +
                "    border-radius: 4px;\n" +
                "    cursor: pointer;\n" +
                "    font-size: 16px;\n" +
                "  }\n" +
                "\n" +
                "  .btn:hover {\n" +
                "    background-color: #2980b9;\n" +
                "  }\n" +
                "</style>\n" +
                "<title>I</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div class=\"form-container\">\n" +
                "    <form method=\"patch   \" action=\"" + URL + "\">\n" +
                "      <input type=\"submit\" class=\"btn\" value=\"Confirm email\">\n" +
                "    </form>\n" +
                "  </div>\n" +
                "<h1>If the fucking button doesn't work because of stupid gmail service, click here: <a href=\""+URL+"\">" + "CONFIRMATION" + "</a></h1> " +
                "</body>\n" +
                "</html>\n";
    }
}
/*
       String text = "<html>" +
                "<head><title>" + subject + "</title></head>" +
                "<body>" +
                "<form method=\"post\" action=\"" + URL + "\">" +
                "<input type=\"submit\" value=\"Confirm\">" +
                "</form>" +
                "</body>" +
                "</html>";
 */