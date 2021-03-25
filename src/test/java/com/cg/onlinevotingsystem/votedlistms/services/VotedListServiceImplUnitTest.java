package com.cg.onlinevotingsystem.votedlistms.services;

import com.cg.onlinevotingsystem.votedlistms.dao.VotedListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class VotedListServiceImplUnitTest {
    @Mock
    VotedListRepository repository;

    @Spy
    @InjectMocks
    VotedListServiceImpl service ;


}
