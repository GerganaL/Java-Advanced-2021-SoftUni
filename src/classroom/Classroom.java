package classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Classroom {
    private int capacity;
    private List<Student> students;

    public Classroom(int capacity){
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents (){
        return this.students;
    }

    public  int getStudentsCount(){
        return this.students.size();
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setData(List<Student> data) {
        this.students = data;
    }

    public List<Student> getData() {
        return students;
    }

    public String registerStudent(Student student){
        if(this.students.size()<this.capacity){
            this.students.add(student);
            return "Student is already in the classroom";
        }
        return "No seats in the classroom";
    }

    public String dismissStudent(Student student){
        if(this.students.contains(student)){
            String firstName=student.getFirstName();
            String lastName= student.getLastName();
            this.students.remove(student);
            return String.format("Removed student %s %s",firstName,lastName);
        }
        return "Student not found";
    }

    public String getSubjectInfo(String subject){
        List<Student>currentSubject=this.students.stream().filter(e->e.getBestSubject().equals(subject)).collect(Collectors.toList());
        if(currentSubject.isEmpty()){
            return "No students enrolled for the subject";
        }else {
            StringBuilder students = new StringBuilder(String.format("Subject: %s",subject));
            students.append(System.lineSeparator()).append("Students:").append(System.lineSeparator());
            currentSubject.forEach(e->students.append(e.getFirstName()).append(" ").append(e.getLastName()).append(System.lineSeparator()));
            return students.toString().trim();
        }
    }

    public Student getStudent(String firstName, String lastName){
        return this.students.stream().filter(e->e.getFirstName().equals(firstName)&&e.getLastName().equals(lastName))
                .findFirst().orElse(null);
    }

    public String getStatistics(){
        StringBuilder output = new StringBuilder(String.format("Classroom size: %d",this.students.size()));
        this.students.forEach(e-> output.append(System.lineSeparator()).append("==").append(e));
        return output.toString();
    }
}
