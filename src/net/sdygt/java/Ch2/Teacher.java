package net.sdygt.java.Ch2;

class Teacher extends Person {

    private final String TID;

    Teacher(String TID, String name) {
        super(name);
        this.TID = TID;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.TID + ' ' + this.name;
    }
}
