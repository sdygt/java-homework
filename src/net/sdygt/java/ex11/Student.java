package net.sdygt.java.ex11;

class Student extends Person {

    private final String SID;

    Student(String SID, String name) {
        super(name);
        this.SID = SID;

    }

    @Override
    public String toString() {
        return this.SID + " " + this.name;
    }
}
