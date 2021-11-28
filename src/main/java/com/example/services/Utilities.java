package com.example.services;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Utilities {

    public int getRandomUID(){

        // SecureRandom randomGenerator = SecureRandom.getInstance("SHA1PRNG");         
        // HashSet<Integer> set = new HashSet<>();
        // while(set.size()<10)
        //     set.add(randomGenerator.nextInt(9999));
        // catch NoSuchAlgorithmException nsae
        try {
            SecureRandom randomGenerator = SecureRandom.getInstance("SHA1PRNG");         
            HashSet<Integer> set = new HashSet<>();
            while (set.size()<10) {
                set.add(randomGenerator.nextInt(9999));
            }
            return 1;
            
        } catch (NoSuchAlgorithmException nsae) {
            return 1;

        }

    }


    public static List<Object[]> parseToObjectArray(ResultSet resultSet){

        List<Object[]> records=new ArrayList<>();
        try {
            while(resultSet.next()){
                int cols = resultSet.getMetaData().getColumnCount();
                Object[] arr = new Object[cols];
                for(int i=0; i<cols; i++){
                    arr[i] = resultSet.getObject(i+1);
                }
                records.add(arr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return records;
    }
}
