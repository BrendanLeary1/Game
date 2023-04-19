
public class SchoolLine {
    private StudentNode lineLeader;

    public StudentNode getLineLeader() {
        return this.lineLeader;
    }
    public void setLineLeader(StudentNode lineLeader) {
        this.lineLeader = lineLeader;
    }

    public SchoolLine(StudentNode lineLeader) {
        this.lineLeader = lineLeader;
    }


    // StudentNode class has 2 fields: name (String) and next (StudentNode I think)
    public void printStudentNames() {
        StudentNode current = lineLeader;
        while (current != null) {
            System.out.println(current.getName());
            current = current.getNext();
        }
    }

    public void cutInFront(StudentNode pushyStudent) {
        // make sure pushyStudent isn't null
        if (pushyStudent != null) {
            // must first set pushyStudent's next to the current lineLeader so that the current lineLeader's
            //values are not lost
            pushyStudent.setNext(lineLeader);
            // now, we can set lineLeader to the new leader
            lineLeader = pushyStudent;
        }
    }

    public static void main(String[] args) {
        SchoolLine myLine = new SchoolLine(new StudentNode("Student1", null));
        myLine.getLineLeader().setNext(new StudentNode("Student2", null)); // from StudentNode class
        StudentNode.insertStudentAfter(myLine.getLineLeader(), new StudentNode("Student3", null)); // the
        // insertStudentAfter method takes the new student (in this case, Student3) and sets their next value
        // to be the first student (in this case, Student1)
        myLine.cutInFront(new StudentNode("Student4", null));
        myLine.displayNames();
    }




    // a main method that implements the following:
    // Creates an instance of SchoolLine
    // Loads at least 3 students into the line
    // Calls the instance method that prints all the names of the students
    // an instance method named cutInFront that has one StudentNode parameter named
    //pushyStudent and does not return a value. This method adds the pushyStudent to the front of
    //the list.
    // add statements to your main method to call cutInFront with a new StudentNode and then call
    //the method that prints all the names of the students again
}
