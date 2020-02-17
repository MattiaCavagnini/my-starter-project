package com.examples.test.controllo;

import com.examples.test.IssueService;
import com.examples.test.model.Issue;

public class ControlloPresenza {
    IssueService issueService;

    public ControlloPresenza(){
        issueService = new IssueService();
    }

    public boolean getById(Integer id) {
        boolean risultato = false;
        Issue[] issueList = issueService.getAll();

        for(int i=0; i<issueList.length; i++){
            if (issueList[i].getId().equals(id)) {
                risultato = true;
            }
        }
        return risultato;
    }

    public Integer getIdByTitle(String title){
        Integer risultato = 0;
        Issue[] issueList = issueService.getAll();

        for(int i=0; i<issueList.length; i++){
            if (issueList[i].getTitolo().equals(title)) {
                risultato = issueList[i].getId();
            }
        }
        return risultato;
    }

    public boolean byTitle(String titolo){
        boolean risultato = false;

        Issue[] issueList = issueService.getAll();

        for(int i=0; i<issueList.length; i++){
            if (issueList[i].getTitolo().equals(titolo)) {
                risultato = true;
            }
        }
        return risultato;
    }
}