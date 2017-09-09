package gui.helper;

import dao.DaoManager;
import entity.People;
import javax.swing.*;

public class PeopleCreator {

    private final static String NAME_TEXT = "Add meg a tag nevét!";
    private final static String ADDRESS_TEXT = "Add meg a tag lakcímét!";

    private People people;
    private boolean invalid;

    private PeopleCreator() {
        people = new People();
        invalid = false;
    }

    public static PeopleCreator preparation() {
        return new PeopleCreator();
    }

    public PeopleCreator withName() {
        String name = JOptionPane.showInputDialog(NAME_TEXT);
        if (name != null && !"".equals(name.trim())) {
            people.setName(name.trim());
            invalid = false;
        } else {
            invalid = true;
        }
        return this;
    }

    public PeopleCreator withAddress() {
        String address = JOptionPane.showInputDialog(ADDRESS_TEXT);
        if (address != null && !"".equals(address.trim())) {
            people.setAddress(address.trim());
            invalid = false;
        } else {
            invalid = true;
        }
        return this;
    }

    public PeopleCreator withlibraryID() {
        people.setLibraryID(DaoManager.getInstance().getPeopleDao().findAll().size() + 1);
        return this;
    }

    public People build() {
        return (invalid) ? null : people;
    }
}
