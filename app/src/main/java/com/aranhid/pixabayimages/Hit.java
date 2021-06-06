package com.aranhid.pixabayimages;

public class Hit {
    Integer id;
    String previewURL;
    String webformatURL;
    String user;
    String tags;

    public Hit(String user, String tags) {
        this.user = user;
        this.tags = tags;
    }
}
