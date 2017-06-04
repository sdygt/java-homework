package net.sdygt.java.ex11;

class Score {
    private final Student student;
    private final Course course;
    private int value;

    Score(Student student, Course course, int value) {
        this.student = student;
        this.course = course;
        this.value = value;
    }

    Score(Student student, Course course, Grade grade) {
        this.student = student;
        this.course = course;
        switch (grade) {
            case A:
                this.value = 95;
                break;
            case B:
                this.value = 85;
                break;
            case C:
                this.value = 75;
                break;
            case D:
                this.value = 65;
                break;
            case F:
                this.value = 0;
                break;
        }
    }

    @Override
    public String toString() {
        return this.student.getName() + " <<" + this.course.getTitle() + ">> " + this.value;
    }
}
