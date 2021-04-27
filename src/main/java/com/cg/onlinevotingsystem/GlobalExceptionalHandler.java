package com.cg.onlinevotingsystem;


import com.cg.onlinevotingsystem.cooperativesocietyms.exceptions.SocietyNotFoundException;
import com.cg.onlinevotingsystem.dashboard.exceptions.ResultNotFoundException;
import com.cg.onlinevotingsystem.electionoffice.exceptions.ElectionOfficerNotFoundException;
import com.cg.onlinevotingsystem.nominatedcandidatems.exceptions.CandidateNotFoundException;
import com.cg.onlinevotingsystem.votedlistms.exceptions.VoteNotFoundException;
import com.cg.onlinevotingsystem.voterms.exceptions.VoterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public String handleCooperativeSocietyNotFound(SocietyNotFoundException e)
    {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public String handleResultNotFoundException(ResultNotFoundException e)
    {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public String handleElectionOfficerNotFoundException(ElectionOfficerNotFoundException e)
    {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public String handleCandidateNotFoundException(CandidateNotFoundException e)
    {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public String handleVoteNotFoundException(VoteNotFoundException e)
    {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public String handleVoterNotFoundException(VoterNotFoundException e)
    {
        return e.getMessage();
    }

}
