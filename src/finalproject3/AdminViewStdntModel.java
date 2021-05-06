/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject3;

/**
 *
 * @author ERIN
 */
public class AdminViewStdntModel {
    private int sn;
    private String name;
    private int id;
//    private String sec;
    private int batch;
    private String dept;
    private String pswrd;

    public AdminViewStdntModel(int sn, String name, int id,int batch, String dept, String pswrd) {
        this.sn = sn;
        this.name = name;
        this.id = id;
//        this.sec = sec;
        this.batch = batch;
        this.dept = dept;
        this.pswrd = pswrd;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getSec() {
//        return sec;
//    }
//
//    public void setSec(String sec) {
//        this.sec = sec;
//    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPswrd() {
        return pswrd;
    }

    public void setPswrd(String pswrd) {
        this.pswrd = pswrd;
    }

   
    
    
}
