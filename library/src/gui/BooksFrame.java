package gui;

import dao.DaoManager;
import entity.Books;
import entity.Borrows;
import entity.People;
import static gui.FrameConstants.*;
import gui.helper.BooksCreator;
import gui.helper.BorrowsCreator;
import gui.helper.PeopleCreator;
import gui.model.GenericTableModel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.event.*;
import javax.swing.table.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class BooksFrame extends JFrame {

    private JTable table, table2, table3;
    private JPanel toolBar;

    private JButton addBooks;
    private JButton removeBooks;

    private JButton addPeople;
    private JButton removePeople;

    private JButton addBorrowsbutton;
    private JButton removeBorrowsbutton;

    private ListSelectionListener selectionListener;
    private ActionListener addBooksAction;
    private ActionListener removeBooksAction;

    private ActionListener addPeopleAction;
    private ActionListener removePeopleAction;

    private ActionListener addBorrowsAction;
    private ActionListener removeBorrowsAction;

    public BooksFrame() {
        linkActionListeners();

        initFrame();

        initTable();
        initTable2();
        initTable3();

        initButtons();
        initToolBar();

        fill();
    }

    private void initFrame() {
        setTitle(FrameConstants.FRAME_TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setLayout(new GridLayout(2, 0));
        setLocationRelativeTo(null);
    }

    private void initTable() {
        GenericTableModel<Books> model = new GenericTableModel<>(DaoManager.getInstance().getBooksDao(), Books.PROPERTY_NAMES);
        TableRowSorter sorter = new TableRowSorter<>(model);
        table = new JTable(model);
        table.setRowSorter(sorter);
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(selectionListener);
    }

    private void initTable2() {
        GenericTableModel<People> people = new GenericTableModel<>(DaoManager.getInstance().getPeopleDao(), People.PROPERTY_NAMES);
        TableRowSorter sorter = new TableRowSorter<>(people);
        table2 = new JTable(people);
        table2.setRowSorter(sorter);
        table2.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table2.getSelectionModel().addListSelectionListener(selectionListener);
    }

    private void initTable3() {
        GenericTableModel<Borrows> borrows = new GenericTableModel<>(DaoManager.getInstance().getBorrowsDao(), Borrows.PROPERTY_NAMES);
        TableRowSorter sorter = new TableRowSorter<>(borrows);
        table3 = new JTable(borrows);
        table3.setRowSorter(sorter);
        table3.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table3.getSelectionModel().addListSelectionListener(selectionListener);
    }

    private void initButtons() {
        addBooks = new JButton("Könyv hozzáadása");
        addBooks.addActionListener(addBooksAction);

        removeBooks = new JButton("Könyv törlése");
        removeBooks.addActionListener(removeBooksAction);
        removeBooks.setEnabled(false);

        addPeople = new JButton("Kölcsönző hozzáadása");
        addPeople.addActionListener(addPeopleAction);

        removePeople = new JButton("Kölcsönző törlése");
        removePeople.addActionListener(removePeopleAction);
        removePeople.setEnabled(false);

        addBorrowsbutton = new JButton("Kölcsönzés");
        addBorrowsbutton.addActionListener(addBorrowsAction);

        removeBorrowsbutton = new JButton("Visszahozta a könyvet");
        removeBorrowsbutton.addActionListener(removeBorrowsAction);
        removeBorrowsbutton.setEnabled(false);
    }

    private void initToolBar() {
        toolBar = new JPanel();
        toolBar.add(addBooks);
        toolBar.add(removeBooks);

        toolBar.add(addPeople);
        toolBar.add(removePeople);

        toolBar.add(addBorrowsbutton);
        toolBar.add(removeBorrowsbutton);
    }

    private void fill() {
        add(toolBar);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(new JScrollPane(table2), BorderLayout.CENTER);
        add(new JScrollPane(table3), BorderLayout.CENTER);
    }

    private void linkActionListeners() {
        selectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (table.getSelectedRow() > -1) {
                    GenericTableModel<Books> model = (GenericTableModel<Books>) table.getModel();
                    int rowIndex = table.convertRowIndexToModel(table.getSelectedRow());
                    Books selected = model.getEntity(rowIndex);
                    if (selected != null) {
                        removeBooks.setEnabled(true);
                    }
                } else {
                    removeBooks.setEnabled(false);
                }

                if (table2.getSelectedRow() > -1) {
                    GenericTableModel<People> model2 = (GenericTableModel<People>) table2.getModel();
                    int rowIndex2 = table2.convertRowIndexToModel(table2.getSelectedRow());
                    People selected2 = model2.getEntity(rowIndex2);
                    if (selected2 != null) {
                        removePeople.setEnabled(true);
                    }
                } else {
                    removePeople.setEnabled(false);
                }

                if (table3.getSelectedRow() > -1) {
                    GenericTableModel<Borrows> model3 = (GenericTableModel<Borrows>) table3.getModel();
                    int rowIndex3 = table3.convertRowIndexToModel(table3.getSelectedRow());
                    Borrows selected3 = model3.getEntity(rowIndex3);
                    if (selected3 != null) {
                        removeBorrowsbutton.setEnabled(true);
                    }
                } else {
                    removeBorrowsbutton.setEnabled(false);
                }
            }
        };

        addBooksAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Books books = BooksCreator.preparation()
                        .withTitle()
                        .withAuthor()
                        .withISBN()
                        .withYear()
                        .withAmount()
                        .build();
                GenericTableModel<Books> model = (GenericTableModel<Books>) table.getModel();
                model.addEntity(books);
            }
        };

        addPeopleAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                People people = PeopleCreator.preparation()
                        .withName()
                        .withAddress()
                        .withlibraryID()
                        .build();
                GenericTableModel<People> model = (GenericTableModel<People>) table.getModel();
                model.addEntity(people);
            }
        };

        addBorrowsAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() > -1 && table2.getSelectedRow() > -1) {

                    GenericTableModel<Books> model = (GenericTableModel<Books>) table.getModel();
                    int rowIndex2 = table.convertRowIndexToModel(table.getSelectedRow());

                    GenericTableModel<People> model2 = (GenericTableModel<People>) table2.getModel();
                    int rowIndex = table2.convertRowIndexToModel(table2.getSelectedRow());

                    Borrows borrows = BorrowsCreator.preparation()
                            .withPeople(model2.getEntity(rowIndex))
                            .withBooks(model.getEntity(rowIndex2))
                            .withBorrowdate(Date.valueOf(LocalDate.now()).toString())
                            .withReturndate("0000-00-00")
                            .build();
                    if (borrows != null) {
                        GenericTableModel<Borrows> model3 = (GenericTableModel<Borrows>) table3.getModel();
                        model3.addEntity(borrows);
                    }

                }
            }
        };

        removeBooksAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() > -1) {
                    GenericTableModel<Books> model = (GenericTableModel<Books>) table.getModel();
                    int rowIndex = table.convertRowIndexToModel(table.getSelectedRow());
                    System.out.println("Rowindex: " + rowIndex);
                    model.removeEntity(rowIndex);
                }
            }
        };

        removePeopleAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table2.getSelectedRow() > -1) {
                    GenericTableModel<People> model2 = (GenericTableModel<People>) table2.getModel();
                    int rowIndex2 = table2.convertRowIndexToModel(table2.getSelectedRow());
                    System.out.println("Rowindex: " + rowIndex2);
                    model2.removeEntity(rowIndex2);
                }
            }
        };

        removeBorrowsAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table3.getSelectedRow() > -1) {
                    GenericTableModel<Borrows> model = (GenericTableModel<Borrows>) table3.getModel();
                    int rowIndex = table3.convertRowIndexToModel(table3.getSelectedRow());

                    Borrows borrows = BorrowsCreator.preparation()
                            .withPeople(model.getEntity(rowIndex).getPeople())
                            .withBooks(model.getEntity(rowIndex).getBook())
                            .withBorrowdate(model.getEntity(rowIndex).getBorrowdate())
                            .withReturndate(Date.valueOf(LocalDate.now()).toString())
                            .build();
                    if (borrows != null) {
                        GenericTableModel<Borrows> model3 = (GenericTableModel<Borrows>) table3.getModel();
                        model3.removeEntity(rowIndex);
                        model3.addEntity(borrows);
                    }
                }
            }
        };
    }
}
