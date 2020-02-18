package com.examples.test.views;

import com.examples.test.services.IssueService;
import com.examples.test.components.IssuesComponent;
import com.examples.test.model.Issue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import lombok.extern.slf4j.Slf4j;

@Route("menu")
@Slf4j
public class MainView extends VerticalLayout {//MainView

    private IssueService service = new IssueService();
    private Grid<Issue> grid = new Grid<>(Issue.class);
    private TextField filterText = new TextField();
    private IssuesComponent form = new IssuesComponent(this);

    public MainView() {
        filterText.setPlaceholder("Filter by title...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.EAGER);
        filterText.addValueChangeListener(e -> updateList());

        Button addCustomerBtn = new Button("Add new issue");
        addCustomerBtn.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setComponent(new Issue());
        });

        HorizontalLayout toolbar = new HorizontalLayout(filterText,
                addCustomerBtn);

        grid.setColumns("titolo", "desc", "reportedBy");

        HorizontalLayout mainContent = new HorizontalLayout(grid, form);
        mainContent.setSizeFull();
        grid.setMaxWidth("700px");

        add(new HorizontalLayout(filterText, toolbar), mainContent);
        setSizeFull();

        grid.asSingleSelect().addValueChangeListener(event ->
                form.setComponent(grid.asSingleSelect().getValue()));

        updateList();
    }

    public void updateList() {
        grid.setItems(service.getAllByTitle(filterText.getValue()));
    }
}
        /*
        HorizontalLayout h = new HorizontalLayout();
        /***********************************************************************************************/
        /*RestTemplate restTemplate = new RestTemplate();
        //Bottoni comandi mostra, aggiungi, elimina, modifica
        Button goToAdd = new Button("Add issue");
        Button delete = new Button("Delete issue");
        delete.setEnabled(false);
        Button show = new Button("Show issue");
        show.setEnabled(false);

        //per chiamate rest
        IssueService rest = new IssueService();

        //Creazione elenco iniziale nella pagina menu
        Issue[] issuesList = rest.getAll();
        Grid<Issue> grid = new Grid<>(Issue.class);
        grid.setItems(issuesList);
        grid.setColumns("id", "titolo");
        grid.setWidth("500px");*/
/***********************************************************************************************************************/

/***********************************************************************************************************************/
       /* Issue issueMod = new Issue();
        Dialog modificaDialog = new Dialog();
        modificaDialog.setCloseOnOutsideClick(false);

        Integer id;
        Label idSelezionato = new Label("Seleziona una issue");

        TextField insertTitle = new TextField();
        insertTitle.setLabel("Titolo");
        insertTitle.setWidth("290px");
        insertTitle.setPlaceholder("Inserisci il nuovo titolo");
        insertTitle.setMinLength(5);

        TextArea insertDesc = new TextArea();
        insertDesc.setLabel("Desc");
        insertDesc.setHeight("300px");
        insertDesc.setWidth("290px");
        insertDesc.setPlaceholder("Inserisci la nuova descrizione");

        TextField insertRepo = new TextField();
        insertRepo.setLabel("Reported By");
        insertRepo.setWidth("290px");
        insertRepo.setPlaceholder("Inserisci un nuovo report");
        insertRepo.setMinLength(5);

        Button conferma = new Button(new Label("Conferma"));
        Button annulla = new Button(new Label("Annulla"));

        Icon logoModifica = new Icon(VaadinIcon.EDIT);
        logoModifica.getStyle().set("cursor", "pointer");
        logoModifica.setSize("35px");
        logoModifica.setVisible(false);

        modificaDialog.add(new VerticalLayout(idSelezionato, insertTitle, insertDesc, insertRepo));
        modificaDialog.add(new HorizontalLayout(conferma, annulla));

        //Oggetti bottone mostra

        Dialog mostra = new Dialog();
        TextField idIssue = new TextField("Id");

        mostra.add();*/

/***********************************************************************************************************************/
        //Mostra dati issue
      /*  grid.asSingleSelect().addValueChangeListener(event -> {
            String s = String.format("%s", event.getValue());
            if(s.equals("null")){
                show.setEnabled(false);
            }else{
                show.setEnabled(true);
                Issue issue = rest.getById(event.getValue().getId());
            }
        });

        show.addClickListener(event ->{
            mostra.open();
        });*/

/***********************************************************************************************************************/
        //Comando modifica
        /*grid.asSingleSelect().addValueChangeListener(event -> {
            String s = String.format("%s", event.getValue());
            if(s.equals("null")){
                logoModifica.setVisible(false);
            }else{
                logoModifica.setVisible(true);

                Issue issueSelezionata = rest.getById(event.getValue().getId());

                Integer n = issueSelezionata.getId();
                insertTitle.setValue(issueSelezionata.getTitolo());
                insertDesc.setValue(issueSelezionata.getDesc());
                insertRepo.setValue(issueSelezionata.getReportedBy());

                idSelezionato.setText("Hai selezionato la issue " + n);
                issueMod.setId(n);
            }
        });

        //Apertura dialogo modifica issue selezionata
        logoModifica.addClickListener(buttonClickEvent ->{
        if(insertTitle.getValue() != null) {
            modificaDialog.open();
        }
            else{
            new Dialog(new Label("seleziona una")).open();
        }
                });

        //Conferma modifiche
        conferma.addClickListener(event -> {
            if(insertTitle.getValue().length() > 5 && insertDesc.getValue().length() > 5 && insertRepo.getValue().length() > 5) {
                issueMod.setTitolo(insertTitle.getValue());
                issueMod.setDesc(insertDesc.getValue());
                issueMod.setReportedBy(insertRepo.getValue());

                rest.putById(issueMod.getId(), insertTitle.getValue(), insertDesc.getValue(), insertRepo.getValue());
                modificaDialog.close();
                new Dialog(new Label("Modifiche confermate!")).open();
            }
            else{
                new Dialog(new Label("Completa i campi da modificare")).open();
            }
            Issue[] issueList = rest.getAll();
            grid.setItems(issueList);
        });


        //Annulla modifiche
        annulla.addClickListener(event ->{
           modificaDialog.close();
        });*/
/***********************************************************************************************************************/

/***********************************************************************************************************************/
        //Elimina issue selezionata
        /*Dialog eliminaDialog = new Dialog();
        Button confermaEliminazione = new Button("Conferma");
        Button annullaEliminazione = new Button("Annulla");

        grid.asSingleSelect().addValueChangeListener(event -> {
                    String s = String.format("%s", event.getValue());
                    if(s.equals("null")){
                        delete.setEnabled(false);


                    }else{
                        delete.setEnabled(true);

                        Issue issueSelezionata = rest.getById(event.getValue().getId());

                        Integer n = issueSelezionata.getId();
                        insertTitle.setValue(issueSelezionata.getTitolo());
                        insertDesc.setValue(issueSelezionata.getDesc());
                        insertRepo.setValue(issueSelezionata.getReportedBy());

                        idSelezionato.setText("Eliminare la issue " + n + "?");
                        eliminaDialog.add(new VerticalLayout(idSelezionato, new HorizontalLayout(confermaEliminazione, annullaEliminazione)));
                    }
                });

        //Apertura dialogo eliminazione issue selezionata
        delete.addClickListener(buttonClickEvent ->{
            eliminaDialog.open();
        });

        //Conferma eliminazione
        confermaEliminazione.addClickListener(event -> {
                rest.deleteById(issueMod.getId());
                eliminaDialog.close();
                new Dialog(new Label("Eliminazione confermata!")).open();
                Issue[] issueList = rest.getAll();
                grid.setItems(issueList);
                insertTitle.clear();
                insertDesc.clear();
                insertRepo.clear();
                delete.setEnabled(false);
        });

        //Annulla modifiche
        annullaEliminazione.addClickListener(event ->{
            eliminaDialog.close();
        });*/

/***********************************************************************************************************************/
        /*Div margineSinistro = new Div();
        margineSinistro.setWidth("500px");

        goToAdd.addClickListener(buttonClickEvent -> UI.getCurrent().navigate("aggiungi"));

        h.add(new VerticalLayout(
                new H1("Hello"),
                grid,
                new HorizontalLayout(
                        show,
                        goToAdd,
                        delete,
                        logoModifica)));

        add(
                new HorizontalLayout(
                        margineSinistro,
                        h
                )
            );*/
