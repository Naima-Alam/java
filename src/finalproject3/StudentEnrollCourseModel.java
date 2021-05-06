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
public class StudentEnrollCourseModel {
    private int sn;
    private String title;
    private String code;
    private String sec;
    private int credit;
    private int batch;
    private int seat;

    public StudentEnrollCourseModel(int sn, String title, String code, String sec, int credit, int batch, int seat) {
        this.sn = sn;
        this.title = title;
        this.code = code;
        this.sec = sec;
        this.credit = credit;
        this.batch = batch;
        this.seat = seat;
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

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
    

    
    
}
