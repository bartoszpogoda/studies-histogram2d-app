package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.Test;

import exceptions.NumberOfCordinatesNotEvenException;
import helper.Point;
import helper.PointListReader;

public class PointListReaderTest {
	@Test
	public void testDefaultInput() throws NumberOfCordinatesNotEvenException{
		PointListReader plr = new PointListReader();
		String myFakeInput = "101 102\n103 105";
		plr.setInputStream(new ByteArrayInputStream(myFakeInput .getBytes(StandardCharsets.UTF_8)));
		
		List<Point> listOfPoints = plr.read();
		
		assertEquals(101,listOfPoints.get(0).getX());
		assertEquals(102,listOfPoints.get(0).getY());
		assertEquals(103,listOfPoints.get(1).getX());
		assertEquals(105,listOfPoints.get(1).getY());
	}
	
	@Test
	public void testThrowsExceptionOnBadInput(){
		PointListReader plr = new PointListReader();
		String myFakeInput = "101 102\n103";
		plr.setInputStream(new ByteArrayInputStream(myFakeInput .getBytes(StandardCharsets.UTF_8)));
		
		List<Point> listOfPoints;
		try {
			listOfPoints = plr.read();
			fail();
		} catch (NumberOfCordinatesNotEvenException e) {
			
		}
	}
	
	
}
