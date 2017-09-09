package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Books extends PersistentEntity {

    @OneToMany(mappedBy = "book")
    private List<Borrows> borrowss;

    private String author;
    private String title;
    private Integer ISBN;
    private Integer ev;
    private Integer bookamount;

    public static final String[] PROPERTY_NAMES = {"Író", "Cím", "ISBN", "Év", "dbszám"};

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getYear() {
        return ev;
    }

    public void setYear(Integer year) {
        this.ev = year;
    }

    public Integer getBookAmount() {
        return bookamount;
    }

    public void setBookAmount(Integer bookamount) {
        this.bookamount = bookamount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return author + " - " + title;
    }

    @Override
    public Object get(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return author;
            case 1:
                return title;
            case 2:
                return ISBN;
            case 3:
                return ev;
            case 4:
                return bookamount;
            default:
                return null;
        }
    }

    @Override
    public void set(int columnIndex, Object value) {
        switch (columnIndex) {
            case 0:
                setAuthor((String) value);
                break;
            case 1:
                setTitle((String) value);
                break;
            case 2:
                setISBN((Integer) value);
                break;
            case 3:
                setYear((Integer) value);
                break;
            case 4:
                setBookAmount((Integer) value);
                break;
        }
    }
}
