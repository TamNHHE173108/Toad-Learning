/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Registrations {
    private User userID;
    private String courseID;
    private String totalCost;
    private String status;
    private String validFrom;
    private String validTO;
    private String updateBy;
    private String registrationTime;
    private String scoreID;
    private String score;
    private String quizStatus;

    public Registrations() {
    }

<<<<<<< HEAD
    

    public Registrations(User userID, String courseID) {
        this.userID = userID;
=======
    public Registrations(User userID, String courseID, String totalCost, String status, String validFrom, String validTO, String updateBy, String registrationTime, String scoreID, String score, String quizStatus) {
        this.userID = userID;   
>>>>>>> c53fbdab994328ffde6a25c8c89c0148868ba6a0
        this.courseID = courseID;
        this.totalCost = totalCost;
        this.status = status;
        this.validFrom = validFrom;
        this.validTO = validTO;
        this.updateBy = updateBy;
        this.registrationTime = registrationTime;
        this.scoreID = scoreID;
        this.score = score;
        this.quizStatus = quizStatus;
    }
    

<<<<<<< HEAD
    public Registrations(User userID, String courseID, String totalCost, String status, String validFrom, String validTO, String updateBy, String registrationTime, String scoreID, String score, String quizStatus) {
        this.userID = userID;   
        this.courseID = courseID;
        this.totalCost = totalCost;
        this.status = status;
        this.validFrom = validFrom;
        this.validTO = validTO;
        this.updateBy = updateBy;
        this.registrationTime = registrationTime;
        this.scoreID = scoreID;
        this.score = score;
        this.quizStatus = quizStatus;
    }

=======
>>>>>>> c53fbdab994328ffde6a25c8c89c0148868ba6a0
    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    
    
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidTO() {
        return validTO;
    }

    public void setValidTO(String validTO) {
        this.validTO = validTO;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getScoreID() {
        return scoreID;
    }

    public void setScoreID(String scoreID) {
        this.scoreID = scoreID;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getQuizStatus() {
        return quizStatus;
    }

    public void setQuizStatus(String quizStatus) {
        this.quizStatus = quizStatus;
    }

    @Override
<<<<<<< HEAD
    public String toString() {return "Registrations{" + "userID=" + userID + ", courseID=" + courseID + ", totalCost=" + totalCost + ", status=" + status + ", validFrom=" + validFrom + ", validTO=" + validTO + ", updateBy=" + updateBy + ", registrationTime=" + registrationTime + ", scoreID=" + scoreID + ", score=" + score + ", quizStatus=" + quizStatus + '}';
=======
    public String toString() {
        return "Registrations{" + "userID=" + userID + ", courseID=" + courseID + ", totalCost=" + totalCost + ", status=" + status + ", validFrom=" + validFrom + ", validTO=" + validTO + ", updateBy=" + updateBy + ", registrationTime=" + registrationTime + ", scoreID=" + scoreID + ", score=" + score + ", quizStatus=" + quizStatus + '}';
>>>>>>> c53fbdab994328ffde6a25c8c89c0148868ba6a0
    }
    
    
}