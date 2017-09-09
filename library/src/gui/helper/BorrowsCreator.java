package gui.helper;

import entity.Books;
import entity.Borrows;
import entity.People;

public class BorrowsCreator {

    private Borrows borrows;
    private boolean invalid;

    private BorrowsCreator() {
        borrows = new Borrows();
    }

    public static BorrowsCreator preparation() {
        return new BorrowsCreator();
    }

    public BorrowsCreator withPeople(People people) {
        borrows.setPeople(people);
        return this;
    }

    public BorrowsCreator withBooks(Books books) {
        borrows.setBook(books);
        return this;
    }

    public BorrowsCreator withBorrowdate(String date) {
        borrows.setBorrowdate(date);
        return this;
    }

    public BorrowsCreator withReturndate(String date) {
        borrows.setReturndate(date);
        return this;
    }

    public Borrows build() {
        return borrows;
    }

}
