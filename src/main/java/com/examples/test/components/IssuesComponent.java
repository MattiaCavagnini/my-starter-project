package com.examples.test.components;

import com.examples.test.model.Issue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class IssuesComponent extends FormLayout {

    private TextField titolo = new TextField("Titolo");
    private TextField reportedBy = new TextField("Reported By");
    private TextArea desc = new TextArea();

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    private Binder<Issue> binder = new Binder<>(Issue.class);

    public IssuesComponent() {
        HorizontalLayout buttons = new HorizontalLayout(save, delete);

        binder.bindInstanceFields(this);
        add(titolo, desc, reportedBy, buttons);
    }

    public void setCustomer(Issue issue) {
        binder.setBean(issue);

        if(issue == null) {
            setVisible(false);
        } else {
            setVisible(true);
            titolo.focus();
        }
    }



}
