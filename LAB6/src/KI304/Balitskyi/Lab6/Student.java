package KI304.Balitskyi.Lab6;

public class Student implements Comparable<Object> {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public int compareTo(Object other) {
        if (other instanceof Student) {
            return Integer.compare(this.grade, ((Student) other).grade);
        } else if (other instanceof Book) {
            return Double.compare(this.grade, ((Book) other).getPrice());
        }
        return 0;
    }

    // решта методів залишаються незмінними
    @Override
    public String toString() {
        return name + " (grade: " + grade + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return grade == other.grade && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() * 31 + grade;
    }
}