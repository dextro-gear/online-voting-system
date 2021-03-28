package com.cg.onlinevotingsystem.voterms.ui;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.ICooperativeSocietyService;
import com.cg.onlinevotingsystem.cooperativesocietyms.ui.CooperativeSocietyUI;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.IRegisteredSocietyVotersService;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component
public class voterUI {

    @Autowired
    IRegisteredSocietyVotersService service;

    public static void main(String[] args) {
        voterUI app=new voterUI();
        app.display();
    }

    public void display() {
        CooperativeSociety s1 = new CooperativeSociety( "Meraki", "Dev", "verumbakam","Mesur", "Teni", "111111");
        CooperativeSociety s2 = new CooperativeSociety("Meluha", "Deviya", "minambakam","Meshur", "Aryalur", "222222");
        CooperativeSociety s3 = new CooperativeSociety("Sandar", "Shiv", "karrembakam","Miniasi", "Erode", "333333");
        CooperativeSociety s4 = new CooperativeSociety("Menaar", "Anika", "chanderi","Kaamna", "Jhansi", "444444");
        CooperativeSociety s5 = new CooperativeSociety("Mugil", "Devraj", "basheera","Aakash", "Mirzapur", "555555");
        CooperativeSociety s6 = new CooperativeSociety("Sikant", "Vijay", "chiniyam","Megham", "Amravati", "666666");
        CooperativeSociety s7 = new CooperativeSociety("Vinayam", "Indra", "devgarh","Paripakta", "Chiyaan", "777777");
        CooperativeSociety s8 = new CooperativeSociety("Maghil", "Mandana", "kovur","Damina", "Kohlapur", "888888");
        CooperativeSociety s9 = new CooperativeSociety("Shakti", "Somnath", "kosuvampalayam","Soch", "Mulugu", "999999");
        CooperativeSociety s10 = new CooperativeSociety("Muham", "Anish", "chandrapur","Dharti", "Chinima", "101010");

        System.out.println("\nVoter Creation..........");
        RegisteredSocietyVoters t1 = service.voterRegistration("A001","Ritik", "S", "Male", "password1", "General", "9997876560", "ritik@gmail.com", "House No. 1", "MR Nagar",
                "Mesur", "Theni", 111111,true, s1);
        RegisteredSocietyVoters t2 = service.voterRegistration("A002","Raja", "A", "Male", "password2", "General", "9952688959", "raja@gmail.com", "House No. 2", "GR Nagar",
                "Mehsur", "Aryalur", 222222,true, s2);
        RegisteredSocietyVoters t3 = service.voterRegistration("A003","Shvi", "G", "Female", "password3", "SC", "7389217147", "shivanya@gmail.com", "House No. 3", "LR Nagar",
                "Soch", "Mulugu", 999999,true, s9);
        RegisteredSocietyVoters t4 = service.voterRegistration("A004","Samira", "H", "Female", "password4", "OBC", "9109587771", "s@gmail.com", "House No. 4", "SR Nagar",
                "Miniasi", "Erode", 333333,true, s3);
        RegisteredSocietyVoters t5 = service.voterRegistration("A005","Sam", "M", "Male", "password5", "General", "9109587774", "sam@gmail.com", "House No. 5", "RS Nagar",
                "Megham", "Amravati", 444444,false, s4);
        RegisteredSocietyVoters t6 = service.voterRegistration("A006","Mira", "A", "Female", "password6", "General", "9993320929", "mira@gmail.com", "House No. 6", "SMR Nagar",
                "Mehsur", "Aryalur", 222222,true, s2);
        RegisteredSocietyVoters t7 = service.voterRegistration("A007","Ira", "N", "Female", "password7", "SC", "9109587772", "ira@gmail.com", "House No. 4", "SRM Nagar",
                "Megham", "Amravati", 666666,true, s6);
        RegisteredSocietyVoters t8 = service.voterRegistration("A008","Samir", "J", "Male", "password8", "OBC", "9109587773", "samir@gmail.com", "House No. 4", "STR Nagar",
                "Megham", "Amravati", 666666,false, s6);
        RegisteredSocietyVoters t9 = service.voterRegistration("A009","Amir", "K", "Male", "password9", "General", "9109587775", "amira@gmail.com", "House No. 4", "TR Nagar",
                "Miniasi", "Erode", 333333,true, s3);
        RegisteredSocietyVoters t10 = service.voterRegistration("A010","Ram", "L", "Male", "password10", "OBC", "9109587776", "ram@gmail.com", "House No. 4", "RS Nagar",
                "Paripakta", "Chiyaan", 777777,true, s7);
        RegisteredSocietyVoters t11 = service.voterRegistration("A011","Mohit", "D", "Male", "password11", "SC", "9109587777", "mohit@gmail.com", "House No. 4", "SR Nagar",
                "Damina", "Amravati", 888888,false, s8);
        RegisteredSocietyVoters t12 = service.voterRegistration("A012","Mehuli", "H", "Female", "password12", "General", "9109587778", "mehuli@gmail.com", "House No. 4", "SMR Nagar",
                "Megham", "Amravati", 666666,true, s6);
        RegisteredSocietyVoters t13 = service.voterRegistration("A013","Sia", "N", "Female", "password13", "OBC", "9109587779", "sia@gmail.com", "House No. 4", "SR Nagar",
                "Soch", "Mulugu", 666666,false, s9);
        RegisteredSocietyVoters t14 = service.voterRegistration("A014","Saira", "V", "Female", "password14", "General", "9109587710", "saira@gmail.com", "House No. 4", "TR Nagar",
                "Paripakta", "Chihyaan", 777777,true, s7);
        RegisteredSocietyVoters t15 = service.voterRegistration("A015","Samy", "P", "Male", "password15", "OBC", "9109587711", "samira@gmail.com", "House No. 4", "SR Nagar",
                "Mesur", "Theni", 666666,false, s1);

        System.out.println(t1);

        System.out.println();
        System.out.println("\nView Voter Details..........");
        System.out.println();
        List<RegisteredSocietyVoters> list = service.viewRegisteredVoterList();
        System.out.println("\nVoter Details------->" +list);


        System.out.println();
        System.out.println("\nSearch Voter By Id..........");
        System.out.println();

        RegisteredSocietyVoters t16 = service.searchByVoterID(t1.getId());
        System.out.println(t16);

        System.out.println();
        System.out.println("\nDelete Voter..........");
        System.out.println();

        RegisteredSocietyVoters t17 = service.deleteRegisteredVoter(t1.getId());
        System.out.println("\nVoter deleted");

    }

}
