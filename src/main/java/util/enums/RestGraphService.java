package util.enums;

public enum RestGraphService {
    BASE_URL("https://graph.microsoft.com"),
    TOKEN("<here goes the token>"),
    API_VERSION("beta"),
    MESSAGES_RESOURCE("/me/messages");
    String url;

    RestGraphService(String url) {
        this.url = url;
    }


    @Override
    public String toString() {
        return url;
    }
}
