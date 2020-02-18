package com.examples.test.views;

import com.examples.test.services.IssueService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.beans.factory.annotation.Autowired;

@Route("modifica")
public class ModificaIssue extends Div {

    @Autowired
    IssueService rest;

    public ModificaIssue(){

        Div div = new Div();
        div.setWidth("940px");

        TextField insertId = new TextField();
        insertId.setLabel("Id");
        insertId.setWidth("290px");
        insertId.setPlaceholder("Inserisci id della issue da modificare");
        insertId.setMinLength(1);

        TextField insertTitle = new TextField();
        insertTitle.setLabel("Titolo");
        insertTitle.setWidth("290px");
        insertTitle.setPlaceholder("Inserisci il nuovo titolo");
        insertTitle.setMinLength(5);

        TextArea insertDesc = new TextArea();
        insertDesc.setLabel("Desc");
        insertDesc.setHeight("350px");
        insertDesc.setWidth("290px");
        insertDesc.setPlaceholder("Inserisci la nuova descrizione");

        TextField insertRepo = new TextField();
        insertRepo.setLabel("Reported By");
        insertRepo.setWidth("290px");
        insertRepo.setPlaceholder("Inserisci un nuovo report");
        insertRepo.setMinLength(5);

        Button confirm = new Button(new Label("Conferma"));
        confirm.setWidth("137px");
        Button returnButton = new Button(new Label("Torna indietro"));
        returnButton.setWidth("137px");
        returnButton.addClickListener(buttonClickEvent -> UI.getCurrent().navigate("menu"));

        Button conferma = new Button(new Label("si"));
        Button annulla = new Button(new Label("no"));

        Dialog d1 = new Dialog();

        /*confirm.addClickListener(click -> {
            if(insertId.getValue().length() >= 1 && !insertTitle.isEmpty() && !insertDesc.isEmpty() && !insertRepo.isEmpty()) {
                ControlloPresenza p = new ControlloPresenza();
                if (p.getById(Integer.parseInt(insertId.getValue()))) {
                        d1.open();
                } else {
                    Dialog error = new Dialog(new Label("Issue non esistente"));
                    error.open();
                }
            }
            else{
                Dialog error = new Dialog(new Label("compila i campi"));
                error.open();
            }
        });

        d1.add(new Label("Confermi modifiche?"), new HorizontalLayout(conferma, annulla));
        d1.setCloseOnOutsideClick(false);

        conferma.addClickListener(click ->{
            rest.putById(Integer.parseInt(insertId.getValue()), insertTitle.getValue(), insertDesc.getValue(), insertRepo.getValue());
            d1.close();
            new Dialog(new Label("Modifiche completate!")).open();
        });

        annulla.addClickListener(click ->{
            d1.close();
            new Dialog(new Label("Modifiche non salvate!"));
        });

    add(
            new HorizontalLayout(
                div,
                new VerticalLayout(
                     insertId,
                     insertTitle,
                     insertDesc,
                     insertRepo,
                     new HorizontalLayout(
                     confirm,
                     returnButton
                     )
                )
            )
        );
    }*/
}}