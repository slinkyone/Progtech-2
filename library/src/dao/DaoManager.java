package dao;

import entity.Books;
import entity.People;
import entity.Borrows;

public class DaoManager {

    private GenericDao<Books> booksDao;
    private GenericDao<People> peopleDao;
    private GenericDao<Borrows> borrowsDao;

    public GenericDao<Books> getBooksDao() {
        if (booksDao == null) {
            booksDao = new DefaultDao<>(Books.class);
        }
        return booksDao;
    }

    public GenericDao<People> getPeopleDao() {
        if (peopleDao == null) {
            peopleDao = new DefaultDao<>(People.class);
        }
        return peopleDao;
    }

    public GenericDao<Borrows> getBorrowsDao() {
        if (borrowsDao == null) {
            borrowsDao = new DefaultDao<>(Borrows.class);
        }
        return borrowsDao;
    }

    private DaoManager() {
    }

    public static DaoManager getInstance() {
        return DaoManagerHolder.INSTANCE;
    }

    private static class DaoManagerHolder {

        private static final DaoManager INSTANCE = new DaoManager();
    }
}
