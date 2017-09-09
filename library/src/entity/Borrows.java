package entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Borrows extends PersistentEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private People people;
    @ManyToOne
    private Books book;
    private String borrowdate;
    private String returndate;

    public static final String[] PROPERTY_NAMES = {"Kölcsönző neve", "Könyv címe", "Kölcsönzés dátuma", "Visszahozás dátuma"};

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public String getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(String borrowdate) {
        this.borrowdate = borrowdate;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
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
        if (!(object instanceof Borrows)) {
            return false;
        }
        Borrows other = (Borrows) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.borrows[ id=" + id + " ]";
    }

    @Override
    public Object get(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return people;
            case 1:
                return book;
            case 2:
                return borrowdate;
            case 3:
                return returndate;
            default:
                return null;
        }
    }

    @Override
    public void set(int columnIndex, Object value) {
        switch (columnIndex) {
            case 0:
                setPeople((People) value);
                break;
            case 1:
                setBook((Books) value);
                break;
            case 2:
                setBorrowdate((String) value);
                break;
            case 3:
                setReturndate((String) value);
                break;
        }
    }
}
