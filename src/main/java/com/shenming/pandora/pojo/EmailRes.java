package com.shenming.pandora.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class EmailRes implements Serializable {
    private static final long serialVersionUID = -7911476453645505313L;

    private int status;
    private ArrayList<Email> mails;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Email> getMails() {
        return mails;
    }

    public void setMails(ArrayList<Email> mails) {
        this.mails = mails;
    }

    @Override
    public String toString() {
        return "EmailRes{" +
                "status=" + status +
                ", mails=" + mails +
                '}';
    }
}
