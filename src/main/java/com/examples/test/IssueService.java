package com.examples.test;

import com.examples.test.model.Issue;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IssueService {
    RestTemplate restTemplate;
    final String url = "http://localhost:8080/issues";

    public IssueService(){
        restTemplate = new RestTemplate();
    }

    public Issue[] getAll(){
        ResponseEntity<Issue[]> response =
                restTemplate.getForEntity(
                        "http://localhost:8080/issues/",
                        Issue[].class);

        return response.getBody();
    }

    public Issue getById(Integer id){
        Issue[] issues = null;
        Issue issue = null;

        ResponseEntity<Issue[]> response =
                restTemplate.getForEntity(
                        "http://localhost:8080/issues/",
                        Issue[].class);
        issues = response.getBody();
        for(int i = 0; i<issues.length; i++){
            if(issues[i].getId() == id){
                issue = issues[i];
            }
        }
        return issue;
    }

    public Issue getByTitle(String title){
        ResponseEntity<Issue[]> response =
                restTemplate.getForEntity(
                        "http://localhost:8080/issues/",
                        Issue[].class);
        Issue[] issues = response.getBody();
        for(int i = 0; i<issues.length;i++){
            if(title.equals(issues[i].getTitolo())){
                return issues[i];
            }
        }
        return null;
    }

    public boolean postIssue(String titolo, String desc, String repo) {
        Issue newIssue = new Issue(titolo, desc, repo);

        restTemplate.postForEntity(
                "http://localhost:8080/issues", newIssue, String.class);
        return true;
    }

    public boolean deleteById(Integer id){
        Issue issue = getById(id);
        if( issue != null) {
            restTemplate.delete("http://localhost:8080/issues?id=" + issue.getId());
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteByTitle(String title){
        Issue issue = getByTitle(title);
        if(issue != null) {
            restTemplate.delete("http://localhost:8080/issues?id=" + issue.getId());
            return true;
        }
        else{
            return false;
        }
    }

    public boolean putById(Integer id, String title, String desc, String repo){
        Issue newIssue = new Issue(id,title,desc,repo);
        restTemplate.put( "http://localhost:8080/issues", newIssue);
        return true;
    }
}
