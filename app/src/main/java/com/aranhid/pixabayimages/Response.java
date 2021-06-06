package com.aranhid.pixabayimages;

public class Response {
    Integer total;
    Integer totalHits;
    Hit[] hits;

    @Override
    public String toString() {
        return "totalHits = " + totalHits;
    }
}
