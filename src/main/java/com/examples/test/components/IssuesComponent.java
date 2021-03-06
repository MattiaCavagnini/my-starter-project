package com.examples.test.components;

import com.examples.test.services.IssueService;
import com.examples.test.views.MainView;
import com.examples.test.model.Issue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class IssuesComponent extends FormLayout {//CustomerForm

    private IssueService service = new IssueService();

    private TextField titolo = new TextField("Titolo");
    private TextField reportedBy = new TextField("Reported By");
    private TextArea desc = new TextArea("Desc");

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    private Binder<Issue> binder = new Binder<>(Issue.class);

    private MainView mainView;

    public IssuesComponent(MainView mainView) {

        titolo.setWidth("400px");
        desc.setWidth("400px");
        desc.setHeight("200px");
        reportedBy.setWidth("400px");

        setVisible(false);
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(new VerticalLayout(titolo, desc, reportedBy,buttons));

        binder.bindInstanceFields(this);

        this.mainView = mainView;

        save.addClickListener(event -> save());
        delete.addClickListener(event -> delete());
    }

    private void save() {
        Issue customer = binder.getBean();
        service.postIssue(customer.getTitolo(), customer.getDesc(), customer.getReportedBy());
        mainView.updateList();
        setComponent(null);
    }

    private void delete() {
        Issue customer = binder.getBean();
        service.deleteById(customer.getId());
        mainView.updateList();
        
    }

    public void setComponent(Issue issue) {
        binder.setBean(issue);

        if(issue == null) {
            setVisible(false);
        } else {
            setVisible(true);
            titolo.focus();
        }
    }
}
