package org.beyachad.gongandroid.rest;

public interface GongsListener<Data> {
    void onSuccess(Data result);
    void onFailure(Exception exception);
}
