package com.cg.onlinevotingsystem.votedlistms.services;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import java.util.List;
public interface VotedListService {

    public int castVotedList(VotedList votedList);
    public int updateVotedListDetails(VotedList votedList) ;
    public int deletedVotedListDetails(int id);
    public List<VotedList> viewVotedList();


    /*public VotedList searchByVoterId(int voterId);
    public List<VotedList> searchByNominatedCandidateId(int candidateId);
     */

}
