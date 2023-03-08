package com.example.demo.domain.model;

public class Result {
    public boolean Success;
    public Result() {
        this.Success = true;
    }
    public Result(boolean Success){
        this.Success = Success;
    }

    public void setResult(boolean newSuccess) {
        this.Success = newSuccess;
    }
}
