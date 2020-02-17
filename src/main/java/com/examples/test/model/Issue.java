package com.examples.test.model;

import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDate;

    @Data
    public class Issue {
        private
        Integer id;
        private String titolo;
        private String desc;
        private String reportedBy;
        private LocalDate data;

        public Issue(String titolo, String desc, String reportedBy){
            this.titolo = titolo;
            this.desc = desc;
            this.reportedBy = reportedBy;
            this.data = LocalDate.now();
        }

        public Issue(Integer id, String titolo, String desc, String reportedBy){
            this.id = id;
            this.titolo = titolo;
            this.desc = desc;
            this.reportedBy = reportedBy;
            this.data = LocalDate.now();
        }

        public Issue(){}

        public Issue(Issue issue){
            this.id = issue.id;
            this.titolo = issue.titolo;
            this.desc = issue.desc;
            this.reportedBy = issue.reportedBy;
        }
        public void setId(Integer id){
            this.id = id;
        }

        @Id
        public Integer getId(){
            return id;
        }
        public String toString(){
            return titolo + desc + reportedBy;
        }
}