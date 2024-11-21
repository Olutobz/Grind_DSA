package robinhood;

import java.util.*;


/**
 * You are a developer for a university. Your current project is to develop a system for students
 * to find courses they share with friends.
 * The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.
 * Write a function that takes in a list of (student ID number, course name) pairs and returns,
 * for every pair of students, a list of all courses they share.
 */

// Helper class to store pairs of student ID and course
class StudentDetails {
    int studentId;
    String courseName;

    public StudentDetails(int studentId, String courseName) {
        this.studentId = studentId;
        this.courseName = courseName;
    }
}

public class SharedCourses {

    private static Map<String, List<String>> findSharedCourses(List<StudentDetails> enrollments) {
        // Step 1: Group courses by student
        Map<Integer, Set<String>> studentCourses = new HashMap<>();
        for (StudentDetails enrollment : enrollments) {
            // Check if the student is already in the map
            if (!studentCourses.containsKey(enrollment.studentId)) {
                studentCourses.put(enrollment.studentId, new HashSet<>());
            }
            studentCourses.get(enrollment.studentId).add(enrollment.courseName);
        }

        // Step 2: Find shared courses for each pair of students
        Map<String, List<String>> result = new HashMap<>();
        List<Integer> students = new ArrayList<>(studentCourses.keySet());

        for (int i = 0; i < students.size(); i++) {
            for (int j = i + 1; j < students.size(); j++) {
                int student1 = students.get(i);
                int student2 = students.get(j);

                Set<String> courses1 = studentCourses.get(student1);
                Set<String> courses2 = studentCourses.get(student2);

                // Find intersection (common courses)
                Set<String> commonCourses = new HashSet<>(courses1);
                commonCourses.retainAll(courses2);

                // Store the result if they have shared courses
                if (!commonCourses.isEmpty()) {
                    String pairKey = student1 + "," + student2;
                    result.put(pairKey, new ArrayList<>(commonCourses));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<StudentDetails> enrollments = new ArrayList<>();
        enrollments.add(new StudentDetails(1, "Java"));
        enrollments.add(new StudentDetails(1, "Math"));
        enrollments.add(new StudentDetails(1, "Science"));
        enrollments.add(new StudentDetails(2, "Math"));
        enrollments.add(new StudentDetails(2, "Art"));
        enrollments.add(new StudentDetails(3, "Math"));
        enrollments.add(new StudentDetails(3, "Science"));
        enrollments.add(new StudentDetails(3, "Art"));

        Map<String, List<String>> sharedCourses = findSharedCourses(enrollments);
        System.out.println(sharedCourses);
    }
}
