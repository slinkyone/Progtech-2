package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class People extends PersistentEntity {

    @ManyToOne
    private Borrows borrows;

    @OneToMany(mappedBy = "people")
    private List<Borrows> borrowss;

    private static final long serialVersionUID = 1L;

    private String name;
    private String address;
    private Integer libraryID;

    public static final String[] PROPERTY_NAMES = {"Név", "Cím", "Könyvtárjegy szám"};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getLibraryID() {
        return libraryID;
    }

    public void setLibraryID(Integer libraryID) {
        this.libraryID = libraryID;
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
        if (!(object instanceof People)) {
            return false;
        }
        People other = (People) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Object get(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return name;
            case 1:
                return address;
            case 2:
                return libraryID;
            default:
                return null;
        }
    }

    @Override
    public void set(int columnIndex, Object value) {
        switch (columnIndex) {
            case 0:
                setName((String) value);
                break;
            case 1:
                setAddress((String) value);
                break;
            case 2:
                setLibraryID((Integer) value);
                break;
        }
    }
}
