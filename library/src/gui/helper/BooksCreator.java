package gui.helper;

import entity.Books;
import javax.swing.*;

public class BooksCreator {

    private final static String NAME_TEXT = "Add meg a könyv címétt!";
    private final static String AUTHOR_TEXT = "Add meg az írót!";
    private final static String ISBN_TEXT = "Add meg a könyv ISBN kódját!";
    private final static String AMOUNT_TEXT = "Add meg mennyi könyv van összesen!";
    private final static String YEAR_TEXT = "Add meg a könyv kiadási évét";

    private Books book;
    private boolean invalid;

    private BooksCreator() {
        book = new Books();
        invalid = true;
    }

    public static BooksCreator preparation() {
        return new BooksCreator();
    }

    public BooksCreator withTitle() {
        String title = JOptionPane.showInputDialog(NAME_TEXT);
        if (title != null && !"".equals(title.trim())) {
            book.setTitle(title.trim());
            invalid = false;
        } else {
            invalid = true;
        }
        return this;
    }

    public BooksCreator withAuthor() {
        String author = JOptionPane.showInputDialog(AUTHOR_TEXT);
        if (author != null && !"".equals(author.trim())) {
            book.setAuthor(author.trim());
            invalid = false;
        } else {
            invalid = true;
        }
        return this;
    }

    public BooksCreator withISBN() {
        String isbn = JOptionPane.showInputDialog(ISBN_TEXT);
        if (isbn != null && !"".equals(isbn.trim())) {
            book.setISBN(Integer.parseInt(isbn.trim()));
            invalid = false;
        } else {
            invalid = true;
        }
        return this;
    }

    public BooksCreator withYear() {
        String year = JOptionPane.showInputDialog(YEAR_TEXT);
        if (year != null && !"".equals(year.trim())) {
            book.setYear(Integer.parseInt(year.trim()));
            invalid = false;
        } else {
            invalid = true;
        }
        return this;
    }

    public BooksCreator withAmount() {
        String amount = JOptionPane.showInputDialog(AMOUNT_TEXT);
        if (amount != null && !"".equals(amount.trim())) {
            book.setBookAmount(Integer.parseInt(amount.trim()));
            invalid = false;
        } else {
            invalid = true;
        }
        return this;
    }

    public Books build() {
        return invalid ? null : book;
    }

}
