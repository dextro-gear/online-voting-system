package com.cg.onlinevotingsystem.votedlistms.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class VotedList {

    @GeneratedValue
    @Id
    private int id;
    private Date pollingDateTime;
   /* private CooperativeSociety society;
    private RegisteredSocietyVoters voter;
    private NominatedCandidates candidate;
*/

    public VotedList(int id, Date pollingDateTime) {
        this.id = id;
        this.pollingDateTime = pollingDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPollingDateTime() {
        return pollingDateTime;
    }

    public void setPollingDateTime(Date pollingDateTime) {
        this.pollingDateTime = pollingDateTime;
    }
}
