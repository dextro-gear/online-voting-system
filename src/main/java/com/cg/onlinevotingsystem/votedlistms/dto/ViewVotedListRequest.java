package com.cg.onlinevotingsystem.votedlistms.dto;

import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;

import java.util.List;

public class ViewVotedListRequest {
    List<VotedList> list;

    public List<VotedList> getList() {
        return list;
    }

    public void setList(List<VotedList> list) {
        this.list = list;
    }

    public ViewVotedListRequest(List<VotedList> list) {
        this.list = list;


    }
}
