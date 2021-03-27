package com.cg.onlinevotingsystem.votedlistms.ui;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.votedlistms.services.VotedListServiceImpl;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VotedListUI {

    @Autowired
    VotedListServiceImpl votedListService;

    public void start(){

        RegisteredSocietyVoters voter1=new RegisteredSocietyVoters("A001", "Ritik", "Singh",
                "Male", "password1", "General", "9997876560", "ritik@gmail.com",
                "House No. 1", "MR Nagar", "Aurangabad", "Mathura",
                281006, true, null);
        NominatedCandidates candidate1=new NominatedCandidates();
        CooperativeSociety society1 = new CooperativeSociety( "Meraki", "Dev",
                "Verumbakam","Mesur", "Teni", "603203");



        RegisteredSocietyVoters voter2=new RegisteredSocietyVoters("A001", "Ritik", "Singh",
                "Male", "password1", "General", "9997876560", "ritik@gmail.com",
                "House No. 1", "MR Nagar", "Aurangabad", "Mathura",
                281006, true, null);
        NominatedCandidates candidate2=new NominatedCandidates();
        CooperativeSociety society2 = new CooperativeSociety( "Meraki", "Dev",
                "Verumbakam","Mesur", "Teni", "603203");


        VotedList castVotedList1= votedListService.castVotedList(voter1,candidate1,society1);

        VotedList castVotedList2= votedListService.castVotedList(voter2,candidate2,society2);

        VotedList updateVotedListDetails1 = votedListService.updateVotedListDetails(castVotedList1.getId(), voter1,candidate1,society1);

        VotedList deletedVotedListDetails1= votedListService.deletedVotedListDetails(castVotedList2.getId());

        List<VotedList> list =votedListService.viewVotedList();

        VotedList votedListById =votedListService.searchByVoterId(voter1.getId());


        System.out.println("\nPrinting details of castVotedList ***************************************\n"+castVotedList1.toString());

        System.out.println("\nUpdating details of votedList ********************************\n"+updateVotedListDetails1.toString());

        System.out.println("\nPrinting the list of votedList *****************************\n "+list.toString());
      
        System.out.println("\nPrinting the votedList by voterId ****************************\n"+votedListById);

    }

}
