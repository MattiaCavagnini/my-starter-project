package com.examples.test.components;

import com.examples.test.model.Issue;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class IssuesComponent extends FormLayout {

    private TextField titolo = new TextField("First name");
    private TextField reportedBydesc = new TextField("Last name");
    private TextArea desctitolo = new TextArea();
    private Binder<Issue> binder = new Binder<>(Issue.class);


    public IssuesComponent() {
        binder.bindInstanceFields(this);
    }

}
