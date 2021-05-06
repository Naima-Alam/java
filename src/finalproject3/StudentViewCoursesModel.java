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
public class StudentViewCoursesModel {
    private int sn;
    private String title;
    private String code;
    private int batch;
    private String sec;

    public StudentViewCoursesModel(int sn, String title, String code, int batch, String sec) {
        this.sn = sn;
        this.title = title;
        this.code = code;
        this.batch = batch;
        this.sec = sec;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }
    
}
