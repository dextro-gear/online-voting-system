package com.cg.onlinevotingsystem;

import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



/*@SpringBootTest
public class OnlineVotingSystemVoterTest {

    @Autowired
    @Test
    public void test_searchByVoterID(){
        RegisteredSocietyVoters t1 = new RegisteredSocietyVoters();
        t1.setId(1);
        t1.setVoterIdCardNo("A001");
        t1.setFirstName("Ritik");
        t1.setLastName("Singh");
        t1.setGender("Male");
        t1.setPassword("password1");
        t1.setReservationCategory("General");
        t1.setMobileNo("9997876560");
        t1.setEmailId("ritik@gmail.com");
        t1.setAddress1("House No. 1");
        t1.setAddress2("MR Nagar");
        t1.setMandal("Aurangabad");
        t1.setDistrict("Mathura");
        t1.setPincode(281006);
        t1.setSociety("Society 1");
        t1.setCastedVote(true);

        Assertions.assertEquals(1,t1.getId());
        Assertions.assertEquals("A001",t1.getVoterIdCardNo());
    }

    @Test
    public void test_viewRegisteredVoterList(){
        RegisteredSocietyVoters society1 = new RegisteredSocietyVoters(1,"A001","Ritik", "Singh", "Male", "password1", "General", "9997876560", "ritik@gmail.com", "House No. 1", "MR Nagar",
                "Aurangabad", "Mathura", 281006, "Society 1", true);
        RegisteredSocietyVoters society2 = new RegisteredSocietyVoters(2,"A002","Rishav", "Singh", "Male", "password2", "General", "9996663331", "rishav@gmail.com", "House No. 2", "MR Nagar",
                "Aurangabad", "Mathura", 281006, "Society 1", false);


    }
}
*/