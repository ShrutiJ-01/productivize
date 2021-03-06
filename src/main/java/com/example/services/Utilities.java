package com.example.services;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;

public class Utilities {

    //HashSet that stores picked Random Numbers
    private HashSet<Integer> pickedNumbers = new HashSet<>();

    //return a unique random number in the range 0 to the 
    //given bottomLimit.
    //returns -1 if no unique number is left in range
    public int getRandomID(int bottomLimit){
        boolean foundUniqueNumber=false;
        int uniqueRandomNumber=-1;   

        try {
            SecureRandom randomGenerator = SecureRandom.getInstance("SHA1PRNG");  
            while (!foundUniqueNumber) {
                int number=randomGenerator.nextInt(bottomLimit);
                if(isUnique(number)){
                    foundUniqueNumber=true;
                    uniqueRandomNumber = number;
                }
            }

            return uniqueRandomNumber;
            
        } catch (NoSuchAlgorithmException nsae) {
            return -1;

        }
        catch (Exception e) {
         e.printStackTrace();
         return -1;
        }

    }

    private boolean isUnique(int number){

       return pickedNumbers.add(number);

    }

    public static String getPasswordHash(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(16));                    
    }

    public static boolean verifyEnteredPassword(String plainTextPassword,String storedHash){
        return BCrypt.checkpw(plainTextPassword, storedHash);
    }

    public static boolean isValidPassword(String password)
    {//validator function for password
  
        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
  
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
  
        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }
  
        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);
  
        // Return if the password
        // matched the ReGex
        return m.matches();
    }

    public static boolean isFullname(String str) {
        //return false if name has special numbers or characters or is empty.
        String expression = "^[a-zA-Z\\s]+"; 
        if(str!=null){            
        return str.matches(expression);  
        }  
        else{
            return false;
        }    
    }

    public static Object[][] parseToObjectArray(ResultSet resultSet){

        int cols = 0,rows=0;
        
        try{
            //calculate rows and columns in resultSet
            cols=resultSet.getMetaData().getColumnCount();
            resultSet.last();
            rows=resultSet.getRow();
            resultSet.first();
            
            //fill result set data into object array

            Object[][] records = new Object[rows][cols];//deaclring empty object array
            int i=0, j=0; //declaring index variables
            for(i = 0;i < rows; i++){
                for (j = 0; j < cols; j++) {
                    records[i][j]=resultSet.getObject(j+1);
                }
                resultSet.next();
            }
            return records;           
        }
        catch(NullPointerException e){
            System.out.println("parse to object array : Null was resuturned as Result Set");
            return new Object[0][0];
        }
        catch(Exception e){
            System.out.println("parse to object array : Error parsing ResultSet into Object[][]");
            e.printStackTrace();
            return new Object[0][0];
        }
    }
}
