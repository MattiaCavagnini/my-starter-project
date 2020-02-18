package com.examples.test.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("elimina")
public class DeleteIssue extends Div {

    /*@Autowired
    IssueService rest;

    public DeleteIssue() {
        TextField idTextfield = new TextField("Inserisci id dell'issue da eliminare");
        idTextfield.setWidth("230px");
        TextField titleTextfield = new TextField("Inserisci il titolo dell'issue da eliminare");
        titleTextfield.setWidth("230px");

        Div div = new Div();
        div.setWidth("1000px");
        //bottone di validazione
        Button delete1Button = new Button("conferma");
        Button delete2Button = new Button("conferma");

        //bottoni conferma
        Button confirmButton1 = new Button("Si");
        Button cancelButton1 = new Button("No");
        Button confirmButton2 = new Button("Si");
        Button cancelButton2 = new Button("No");

        Dialog confirm = new Dialog();
        confirm.add(new VerticalLayout(new Label("Confermi?"),new HorizontalLayout(confirmButton1, cancelButton1)));
        confirm.setCloseOnOutsideClick(false);

        Button return1Button = new Button(new Label("Torna indietro"));
        Button return2Button = new Button(new Label("Torna indietro"));

        return1Button.addClickListener(buttonClickEvent -> UI.getCurrent().navigate("menu"));

        delete1Button.setWidth("230px");
        delete2Button.setWidth("230px");
        return1Button.setWidth("230px");

        Dialog confirm2 = new Dialog();
        confirm2.add(new VerticalLayout(new Label("Confermi?"), new HorizontalLayout(confirmButton2, cancelButton2)));

        //cerca ed elimina dall'id
        delete2Button.addClickListener(click-> {
            if(idTextfield.getValue().length() >= 1) {
                confirm.open();
            }
            else{
                Dialog error = new Dialog(new Label("Inserisci un id valido"));
                error.open();
            }

            confirmButton1.addClickListener(event -> {
                if(rest.deleteById(Integer.parseInt(idTextfield.getValue()))) {
                    confirm.close();
                    new Dialog(new Label("Eliminato!")).open();
                    idTextfield.clear();
                }
                else{
                    confirm.close();
                    new Dialog(new Label("Issue non trovata!")).open();
                }
            });
            cancelButton1.addClickListener(event -> {
                confirm.close();
                new Dialog(new Label("Annullato!")).open();
                idTextfield.clear();
            });
        });

        //cerca ed elimina dal titolo
        delete1Button.addClickListener(click-> {
            if(!titleTextfield.isEmpty()){
                //procedura eliminazione issue
                confirm2.open();
            }
            else{
                Dialog error = new Dialog(new Label("Inserisci un titolo valido"));
                error.open();
            }

            confirmButton2.addClickListener(event -> {
                if(rest.deleteByTitle(titleTextfield.getValue())) {
                    confirm2.close();
                    new Dialog(new Label("Eliminato!")).open();
                    titleTextfield.clear();
                }
                else{
                    confirm2.close();
                    new Dialog(new Label("Issue non trovata!")).open();
                }
            });

            //annullamento selezione
            cancelButton2.addClickListener(event -> {
                confirm2.close();
                new Dialog(new Label("Annullato!")).open();
                titleTextfield.clear();
            });
        });

        add(
            new HorizontalLayout(
                    div,
                new VerticalLayout(
                  idTextfield,
                  new HorizontalLayout(
                    delete2Button
                    ),
                    titleTextfield,
                    new HorizontalLayout(
                            delete1Button
                 ),
                    return1Button
            )
        ));
    }*/
}