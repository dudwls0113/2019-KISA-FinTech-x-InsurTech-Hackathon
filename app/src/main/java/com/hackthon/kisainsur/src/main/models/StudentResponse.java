package com.hackthon.kisainsur.src.main.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StudentResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ArrayList<Student> students;

    public class Student{
        @SerializedName("name")
        private String name;

        @SerializedName("mobileNumber")
        private String mobileNumber;

        @SerializedName("isPay")
        private String isPay;

        @SerializedName("isInsure")
        private String isInsure;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getIsPay() {
            return isPay;
        }

        public void setIsPay(String isPay) {
            this.isPay = isPay;
        }

        public String getIsInsure() {
            return isInsure;
        }

        public void setIsInsure(String isInsure) {
            this.isInsure = isInsure;
        }
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}