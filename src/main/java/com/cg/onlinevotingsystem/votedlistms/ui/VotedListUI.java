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

        CooperativeSociety s1 = new CooperativeSociety( "Meraki", "Dev", "Verumbakam","Mesur", "Teni", "603203");
        RegisteredSocietyVoters voter1=new RegisteredSocietyVoters("A001", "Ritik", "Singh",
                "Male", "password1", "General", "9997876560", "ritik@gmail.com",
                "House No. 1", "MR Nagar", "Aurangabad", "Mathura",
                281006, true, s1);
        NominatedCandidates candidate1=new NominatedCandidates("4321", voter1);



        CooperativeSociety s2 = new CooperativeSociety( "Meraki", "Dev", "Verumbakam","Mesur", "Teni", "603203");
        RegisteredSocietyVoters voter2=new RegisteredSocietyVoters("A001", "Ritik", "Singh",
                "Male", "password1", "General", "9997876560", "ritik@gmail.com",
                "House No. 1", "MR Nagar", "Aurangabad", "Mathura",
                281006, true, s2);
        NominatedCandidates candidate2=new NominatedCandidates("1234", voter2);

        CooperativeSociety s3 = new CooperativeSociety("Meluha", "Deviya", "minambakam","Meshur", "Aryalur", "222222");
        RegisteredSocietyVoters voter3 = new RegisteredSocietyVoters("A001","Ritik", "S", "Male", "password1", "General", "9997876560", "ritik@gmail.com", "House No. 1", "MR Nagar",
                "Mesur", "Theni", 111111,true, s3);
        NominatedCandidates candidate3 = new NominatedCandidates("5678",voter3);




        CooperativeSociety s4 = new CooperativeSociety("Menaar", "Anika", "chanderi","Kaamna", "Jhansi", "444444");
        CooperativeSociety s5 = new CooperativeSociety("Mugil", "Devraj", "basheera","Aakash", "Mirzapur", "555555");
        CooperativeSociety s6 = new CooperativeSociety("Sikant", "Vijay", "chiniyam","Megham", "Amravati", "666666");
        CooperativeSociety s7 = new CooperativeSociety("Vinayam", "Indra", "devgarh","Paripakta", "Chiyaan", "777777");
        CooperativeSociety s8 = new CooperativeSociety("Maghil", "Mandana", "kovur","Damina", "Kohlapur", "888888");
        CooperativeSociety s9 = new CooperativeSociety("Shakti", "Somnath", "kosuvampalayam","Soch", "Mulugu", "999999");
        CooperativeSociety s10 = new CooperativeSociety("Muham", "Anish", "chandrapur","Dharti", "Chinima", "101010");


        RegisteredSocietyVoters v4 = new RegisteredSocietyVoters("A004","Samira", "H", "Female", "password4", "OBC", "9109587771", "s@gmail.com", "House No. 4", "SR Nagar",
                "Miniasi", "Erode", 333333,true, s3);
        RegisteredSocietyVoters v5 = new RegisteredSocietyVoters("A005","Sam", "M", "Male", "password5", "General", "9109587774", "sam@gmail.com", "House No. 5", "RS Nagar",
                "Megham", "Amravati", 444444,false, s4);
        RegisteredSocietyVoters v6 = new RegisteredSocietyVoters("A006","Mira", "A", "Female", "password6", "General", "9993320929", "mira@gmail.com", "House No. 6", "SMR Nagar",
                "Mehsur", "Aryalur", 222222,true, s2);
        RegisteredSocietyVoters v7 = new RegisteredSocietyVoters("A007","Ira", "N", "Female", "password7", "SC", "9109587772", "ira@gmail.com", "House No. 4", "SRM Nagar",
                "Megham", "Amravati", 666666,true, s6);
        RegisteredSocietyVoters v8 = new RegisteredSocietyVoters("A008","Samir", "J", "Male", "password8", "OBC", "9109587773", "samir@gmail.com", "House No. 4", "STR Nagar",
                "Megham", "Amravati", 666666,false, s6);
        RegisteredSocietyVoters v9 = new RegisteredSocietyVoters("A009","Amir", "K", "Male", "password9", "General", "9109587775", "amira@gmail.com", "House No. 4", "TR Nagar",
                "Miniasi", "Erode", 333333,true, s3);
        RegisteredSocietyVoters v10 = new RegisteredSocietyVoters("A010","Ram", "L", "Male", "password10", "OBC", "9109587776", "ram@gmail.com", "House No. 4", "RS Nagar",
                "Paripakta", "Chiyaan", 777777,true, s7);
        RegisteredSocietyVoters v11 = new RegisteredSocietyVoters("A011","Mohit", "D", "Male", "password11", "SC", "9109587777", "mohit@gmail.com", "House No. 4", "SR Nagar",
                "Damina", "Amravati", 888888,false, s8);
        RegisteredSocietyVoters v12 = new RegisteredSocietyVoters("A012","Mehuli", "H", "Female", "password12", "General", "9109587778", "mehuli@gmail.com", "House No. 4", "SMR Nagar",
                "Megham", "Amravati", 666666,true, s6);
        RegisteredSocietyVoters v13 = new RegisteredSocietyVoters("A013","Sia", "N", "Female", "password13", "OBC", "9109587779", "sia@gmail.com", "House No. 4", "SR Nagar",
                "Soch", "Mulugu", 666666,false, s9);
        RegisteredSocietyVoters v14 = new RegisteredSocietyVoters("A014","Saira", "V", "Female", "password14", "General", "9109587710", "saira@gmail.com", "House No. 4", "TR Nagar",
                "Paripakta", "Chihyaan", 777777,true, s7);
        RegisteredSocietyVoters v15 = new RegisteredSocietyVoters("A015","Samy", "P", "Male", "password15", "OBC", "9109587711", "samira@gmail.com", "House No. 4", "SR Nagar",
                "Mesur", "Theni", 666666,false, s1);

        NominatedCandidates candidate4 = new NominatedCandidates("8765",v4);

        VotedList castVotedList1= votedListService.castVotedList(voter1,candidate1,s1);
        VotedList castVotedList2= votedListService.castVotedList(voter2,candidate2,s2);
        VotedList castVotedList4= votedListService.castVotedList(v5,candidate1,s3);
        VotedList castVotedList5= votedListService.castVotedList(v6,candidate2,s10);
        VotedList castVotedList6= votedListService.castVotedList(v7,candidate1,s9);
        VotedList castVotedList7= votedListService.castVotedList(v8,candidate1,s5);
        VotedList castVotedList8= votedListService.castVotedList(v9,candidate3,s5);
        VotedList castVotedList9= votedListService.castVotedList(v10,candidate1,s4);
        VotedList castVotedList10= votedListService.castVotedList(v11,candidate1,s6);
        VotedList castVotedList11= votedListService.castVotedList(v12,candidate4,s1);
        VotedList castVotedList12= votedListService.castVotedList(v13,candidate1,s3);
        VotedList castVotedList13= votedListService.castVotedList(v14,candidate4,s2);
        VotedList castVotedList14= votedListService.castVotedList(v15,candidate4,s3);



        VotedList updateVotedListDetails1 = votedListService.updateVotedListDetails(castVotedList1.getId(), voter1,candidate1,s1);

        VotedList deletedVotedListDetails1= votedListService.deletedVotedListDetails(castVotedList2.getId());

        List<VotedList> list =votedListService.viewVotedList();

        VotedList votedListById =votedListService.searchByVoterId(voter1.getId());


        System.out.println("\nPrinting details of castVotedList ***************************************\n"+castVotedList1.toString());

        System.out.println("\nUpdating details of votedList ********************************\n"+updateVotedListDetails1.toString());

        System.out.println("\nPrinting the list of votedList *****************************\n "+list.toString());
      
        System.out.println("\nPrinting the votedList by voterId ****************************\n"+votedListById);

    }

}
