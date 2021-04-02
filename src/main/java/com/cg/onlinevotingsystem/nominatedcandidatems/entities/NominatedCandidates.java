package com.cg.onlinevotingsystem.nominatedcandidatems.entities;

import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class NominatedCandidates{

    @Id
    @GeneratedValue
    private int candidateID;

    private String nominationFormNo;

    @OneToOne
    private RegisteredSocietyVoters societyVoter;


    public NominatedCandidates() {
    }

    public NominatedCandidates(String nominationFormNo, RegisteredSocietyVoters voter) {
        this.nominationFormNo = nominationFormNo;
        this.societyVoter = voter;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public String getNominationFormNo() {
        return nominationFormNo;
    }

    public void setNominationFormNo(String nominationFormNo) {
        this.nominationFormNo = nominationFormNo;
    }

    public RegisteredSocietyVoters getSocietyVoter() {
        return societyVoter;
    }

    public void setSocietyVoter(RegisteredSocietyVoters societyVoter) {
        this.societyVoter = societyVoter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NominatedCandidates)) return false;
        NominatedCandidates that = (NominatedCandidates) o;
        return candidateID == that.candidateID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidateID);
    }

    @Override
    public String toString() {
        return "NominatedCandidates{" +
                "candidateID=" + candidateID +
                ", nominationFormNo='" + nominationFormNo + '\'' +
                '}';
    }


}
