public class YogaData {
    //beginner level
    private String url_easy = "https://www.youtube.com/embed/d8QqXLV3tWM";
    private String dataUrl_easy =
            "<html>" +
                    "<body>" +
                    "<iframe width=\"100%\" height=\"100%\" src=\""+url_easy+"\" frameborder=\"0\" " +
                    "allowfullscreen/>" +
                    "</body>" +
                    "</html>";

    public String getDataUrl_easy() {
        return dataUrl_easy;
    }

    public String getUrl_easy() {
        return url_easy;
    }

    //intermediate level
    private String url_intermediate = "https://www.youtube.com/embed/6AtaS8xJG4E";

    private String dataUrl =
            "<html>" +
                    "<body>" +
                    "<iframe width=\"100%\" height=\"100%\" src=\""+url_intermediate+"\" frameborder=\"0\" allowfullscreen/>" +
                    "</body>" +
                    "</html>";

    public String getUrl_intermediate() {
        return url_intermediate;
    }


    //expert level
    private String url_expert = "https://www.youtube.com/embed/18mnOUa482Y?start=141";

    private String dataUrl_exp =
            "<html>" +
                    "<body>" +
                    "<iframe width=\"100%\" height=\"100%\" src=\""+url_expert+"\" frameborder=\"0\" allowfullscreen/>" +
                    "</body>" +
                    "</html>";

    public String getUrl_expert() {
        return url_expert;
    }
}
