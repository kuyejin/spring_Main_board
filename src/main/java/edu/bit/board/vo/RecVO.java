package edu.bit.board.vo;

import java.sql.Timestamp;
import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RecVO {
	
    private double width;
    private double height;
    
    public double getArea() {
    	return width * height;
    }
	

}
