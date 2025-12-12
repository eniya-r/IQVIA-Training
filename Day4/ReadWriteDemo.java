class StudentReadOnly {
    private String college = "DSU ";
    public String getCollege() {
        return college;
    }
}

class StudentWriteOnly {
    private String college;
    public void setCollege(String college) {
        this.college = college;
    }

    public String getCollege() {
        return college;
    }
}

public class ReadWriteDemo {
    public static void main(String[] args) {
        StudentReadOnly s1 = new StudentReadOnly();
        System.out.println("Read-Only college: " + s1.getCollege());

        StudentWriteOnly s2 = new StudentWriteOnly();
        s2.setCollege("SJU");
        System.out.println("Updated college: " + s2.getCollege());
    }
}
