package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.NumberOfCordinatesNotEvenException;

public class PointListReader {
	
	private InputStream inputStream;
	
	public void setInputStream(InputStream inputStream){
		this.inputStream = inputStream;
	}
	
	public void setFileInputStream(String filename) throws FileNotFoundException{
		this.inputStream = new FileInputStream(filename);
	}
	
	public List<Point> read() throws NumberOfCordinatesNotEvenException{
		Scanner scanner = new Scanner(inputStream);
		
		List<Point> listOfPoints = new ArrayList<>();
		
		boolean xNow = true;
		int x = 0, y = 0;
		
		while(scanner.hasNext()){
			if(xNow){
				x = scanner.nextInt();
				xNow = false;
			}
			else{
				y = scanner.nextInt();
				xNow = true;
				
				listOfPoints.add(new Point(x,y));
			}
		}
		
		if(!xNow) throw new NumberOfCordinatesNotEvenException();
		
		return listOfPoints;
	}
}
