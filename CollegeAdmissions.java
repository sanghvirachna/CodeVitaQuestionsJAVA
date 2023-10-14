import java.util.*;

class College {
    String name;
    int seats;
    int vacantSeats;
    List<Student> admittedStudents;

    public College(String name, int seats) {
        this.name = name;
        this.seats = seats;
        this.vacantSeats = seats;
        this.admittedStudents = new ArrayList<>();
    }
}

class Student {
    int id;
    double percentage;
    List<String> preferences;

    public Student(int id, double percentage, List<String> preferences) {
        this.id = id;
        this.percentage = percentage;
        this.preferences = preferences;
    }
}

public class CollegeAdmissions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numColleges = scanner.nextInt();
        int numStudents = scanner.nextInt();

        List<College> colleges = new ArrayList<>();
        for (int i = 0; i < numColleges; i++) {
            int seats = scanner.nextInt();
            colleges.add(new College("C-" + (i + 1), seats));
        }

        List<Student> students = new ArrayList<>();
        scanner.nextLine(); // consume the newline character after numStudents
        for (int i = 0; i < numStudents; i++) {
            String[] studentData = scanner.nextLine().split(",");
            int id = Integer.parseInt(studentData[0].substring(8));
            double percentage = Double.parseDouble(studentData[1]);
            List<String> preferences = new ArrayList<>();
            for (int j = 2; j < studentData.length; j++) {
                preferences.add(studentData[j]);
            }
            students.add(new Student(id, percentage, preferences));
        }

        // Sort students based on percentage in descending order
        students.sort((s1, s2) -> Double.compare(s2.percentage, s1.percentage));

        // Round 1 admissions
        for (Student student : students) {
            for (String collegeName : student.preferences) {
                College college = getCollege(colleges, collegeName);
                if (college.vacantSeats > 0) {
                    college.admittedStudents.add(student);
                    college.vacantSeats--;
                    break;
                }
            }
        }

        // Round 2 admissions
        for (Student student : students) {
            if (!isAdmitted(colleges, student)) {
                College college = getCollegeWithMostVacantSeats(colleges);
                college.admittedStudents.add(student);
                college.vacantSeats--;
            }
        }

        // Calculate cut-off percentage for each college
        List<String> cutOffs = new ArrayList<>();
        for (College college : colleges) {
            if (college.admittedStudents.isEmpty()) {
                cutOffs.add(college.name + " n/a");
            } else {
                college.admittedStudents.sort((s1, s2) -> Double.compare(s2.percentage, s1.percentage));
                double cutOff = college.admittedStudents
                        .get(Math.min(college.seats - 1, college.admittedStudents.size() - 1)).percentage;
                cutOffs.add(college.name + " " + String.format("%.2f", cutOff));
            }
        }

        // Sort colleges based on cut-off percentage in descending order
        cutOffs.sort((c1, c2) -> {
            double cutOff1 = Double.parseDouble(c1.split(" ")[1]);
            double cutOff2 = Double.parseDouble(c2.split(" ")[1]);
            return Double.compare(cutOff2, cutOff1);
        });

        // Print the result
        for (String cutOff : cutOffs) {
            System.out.println(cutOff);
        }
        scanner.close();
    }

    private static College getCollege(List<College> colleges, String collegeName) {
        for (College college : colleges) {
            if (college.name.equals(collegeName)) {
                return college;
            }
        }
        return null;
    }

    private static boolean isAdmitted(List<College> colleges, Student student) {
        for (College college : colleges) {
            if (college.admittedStudents.contains(student)) {
                return true;
            }
        }
        return false;
    }

    private static College getCollegeWithMostVacantSeats(List<College> colleges) {
        College collegeWithMostVacantSeats = colleges.get(0);
        for (College college : colleges) {
            if (college.vacantSeats > collegeWithMostVacantSeats.vacantSeats) {
                collegeWithMostVacantSeats = college;
            }
        }
        return collegeWithMostVacantSeats;
    }
}