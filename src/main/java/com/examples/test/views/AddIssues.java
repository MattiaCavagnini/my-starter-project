package com.examples.test.views;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertThat;

@Route("aggiungi")
@CssImport("styles/styles.css")
@PWA(name = "My App", shortName = "My App")
public class AddIssues extends VerticalLayout {




    /*
    private final ObjectMapper objectMapper = new ObjectMapper();

    public AddIssues() {
        IssueService rest = new IssueService();

        Div div = new Div();
        div.setWidth("1000px");

        TextField titleField = new TextField();
        titleField.setLabel("Title");
        titleField.setPlaceholder("Minimo 5 caratteri");
        titleField.setWidth("350px");

        TextArea descField = new TextArea();
        descField.setLabel("Desc");
        descField.setHeight("350px");
        descField.setWidth("350px");
        descField.setPlaceholder("Minimo 10 caratteri");

        TextField reportedField = new TextField();
        reportedField.setLabel("Reported by");
        reportedField.setPlaceholder("Minimo 5 caratteri");
        reportedField.setWidth("350px");

        titleField.setMinLength(5);
        descField.setMinLength(10);
        reportedField.setMinLength(5);

        Button saveButton = new Button("Save");

        saveButton.addClickListener(click ->{
            String titolo = titleField.getValue();
            String desc = descField.getValue();
            String repo = reportedField.getValue();

            Dialog dialog = new Dialog();
            dialog.setCloseOnEsc(false);
            dialog.setCloseOnOutsideClick(false);

            Dialog confirm = new Dialog();
            confirm.add(new Label("Salvato!"));

            Dialog cancel = new Dialog();
            cancel.add(new Label("Annullato!"));

            Label messageLabel = new Label();

                Button confirmButton = new Button("Confirm", event -> {
                    messageLabel.setText("Confirmed!");
                    rest.postIssue(titleField.getValue(), descField.getValue(), reportedField.getValue());
                    dialog.close();
                    confirm.open();
                    titleField.clear();
                    descField.clear();
                    reportedField.clear();
                });

                Button cancelButton = new Button("Cancel", event -> {
                    messageLabel.setText("Cancelled...");
                    dialog.close();
                    cancel.open();
                    titleField.clear();
                    descField.clear();
                    reportedField.clear();
                });
                dialog.add(new VerticalLayout(new Label("Confermi?"), new HorizontalLayout(confirmButton, cancelButton)));
                    dialog.open();
        });
        Button returnButton = new Button(new Label("Torna indietro"));
        Div d = new Div();
        d.setWidth("50px");
        returnButton.addClickListener(buttonClickEvent -> UI.getCurrent().navigate("menu"));
        add(
                new HorizontalLayout(
                        div,
                        new VerticalLayout(
                             titleField,
                             descField,
                             reportedField,
                             new HorizontalLayout(
                                     d,
                             saveButton,
                             returnButton)
                  ))
        );
    }*/
}