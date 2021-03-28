package com.cg.onlinevotingsystem.votedlistms.dto;


public class DeleteVotedListRequest {

    String response;
    int id;

    public DeleteVotedListRequest(String response, int id) {
        this.response= response;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}

