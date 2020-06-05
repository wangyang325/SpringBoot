package wangyang.sample.common;

public class Student {
    private String id;
    private String name;
    private int mark;

    public Student(String pid, String pname) {
        this.id = pid;
        this.name = pname;
    }

    public Student(String pid, String pname, int pmark) {
        this.id = pid;
        this.name = pname;
        this.mark = pmark;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mark
     */
    public int getMark() {
        return mark;
    }

    /**
     * @param mark the mark to set
     */
    public void setMark(int mark) {
        this.mark = mark;
    }
}
