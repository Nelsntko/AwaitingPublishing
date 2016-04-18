/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awaitingpublishing;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author ntko
 */
public class Reference extends Observable {
    private String company, referee, title, dateOne, dateTwo, position, salary, additionalInfo = null;
    
    private boolean companyExists, refereeExists, titleExists, dateOneExists,
            dateTwoExists, positionExists, salaryExists, additionalInfoExists = false;
    
    
    private String reference() {
        ArrayList<String> reference = new ArrayList();
        reference.add(0, "");
        reference.add(1, "");
        reference.add(2, "");
        reference.add(3, "");
        reference.add(4, "");
        reference.add(5, "");
        
        if(refereeExists & titleExists){
            reference.set(0, referee + " " + '(' + title + ')');
        }
        else if(refereeExists){
            reference.set(0, referee);
        }
        else if(titleExists){
            reference.set(0, title);
        }
        else if(companyExists){
            reference.set(0, company);
        }
        else {
            reference.set(0, "The Company");
        }
        
        reference.set(1, " advised that the candidate was employed");
        
        boolean noDates = false;
        if(dateOneExists & dateTwoExists){
            DateChanger dc = new DateChanger();
            reference.set(2, " from " + dc.dateChanger(dateOne) + " to " + dc.dateChanger(dateTwo));
        }
        else {
            noDates = true;
            reference.set(2, ", but no employment dates were given");
        }
        
        if(positionExists & noDates){
            reference.set(3, ". The Referee could confirm that the Candidate's "
                    + "title was " + position);
        }
        else if(positionExists){
            reference.set(3, " in the position of " + position);
        }
        
        if(salaryExists & positionExists){
            reference.set(4, " with a salary of " + salary);
        }
        else if(salaryExists & noDates){
            reference.set(4, ". The Referee could confirm that the Candidate's "
                    + "salary was " + salary);
        }
        
        reference.set(5, ". ");
        

        
        int refnum = reference.size();
        String finishedRef = null;
        for(int i = 0; i < refnum; i++){
            if(i == 0){
                finishedRef = reference.get(i);
            } 
            else {
            finishedRef += reference.get(i);
            }
        }
        return finishedRef;
        }
    
    /**
     * @param company the company is set and is set to exist (if not null)
     * for reference() check
     */
    public void setCompany(String company) {
        if(company.isEmpty()){
            this.companyExists = false;
        }
        else{
        this.company = company;
        this.companyExists = true;
        }
    }
    
    /**
     * @param referee the referee is set and is set to exist (if not null)
     * for reference() check
     */
    public void setReferee(String referee) {
        if(referee.isEmpty()){
            this.refereeExists = false;
        }
        else{
        this.referee = referee;
        this.refereeExists = true;
        }
    }

    /**
     * @param title the title is set and is set to exist (if not null)
     * for reference() check
     */
    public void setTitle(String title) {
        if(title.isEmpty()){
            this.titleExists = false;
        }
        else{
        this.title = title;
        this.titleExists = true;
        }
    }

    /**
     * @param dateOne the start date is set and is set to exist (if not null)
     * for reference() check
     */
    public void setDateOne(String dateOne) {
        if(dateOne.isEmpty()){
            this.dateOneExists = false;
        }
        else{
        this.dateOne = dateOne;
        this.dateOneExists = true;
        }
    }

    /**
     * @param dateTwo the end date is set and is set to exist (if not null)
     * for reference() check
     */
    public void setDateTwo(String dateTwo) {
        if(dateTwo.isEmpty()){
            this.dateTwoExists = false;
        }
        else{
        this.dateTwo = dateTwo;
        this.dateTwoExists = true;
        }
    }
    
    /**
     * @param position the end date is set and is set to exist (if not null)
     * for reference() check
     */
    public void setPosition(String position) {
        if(position.isEmpty()){
            this.positionExists = false;
        }
        else{
        this.position = position;
        this.positionExists = true;
        }
    }
    /**
    * @param salary the salary to set
    */
    public void setSalary(String salary) {
        if(salary.isEmpty()){
            this.salaryExists = false;
        }
        else{
        this.salary = salary;
        this.salaryExists = true;
        }
    }
    
    /**
     * @return the reference
     */
    public String getReference() {
        return this.reference();
    }

    


}
