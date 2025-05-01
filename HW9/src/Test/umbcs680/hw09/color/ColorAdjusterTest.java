package umbcs680.hw09.color;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ColorAdjusterTest {

	
	private String colorToString(Color color) {
	    return color.getRedScale() + "," + color.getGreenScale() + "," + color.getBlueScale();
	}

	@Test
	void GrayScaleAdjusterTest() {

		Image img = new Image(2, 2);
		img.setColor(0, 0, new Color(100, 150, 200)); 
        img.setColor(0, 1, new Color(50, 75, 100));   
        img.setColor(1, 0, new Color(25, 50, 75));   
        img.setColor(1, 1, new Color(200, 220, 240)); 
        Image grayScaleImg = Images.transform(img, new GrayScaleAdjuster());
        assertEquals("150,150,150", colorToString(grayScaleImg.getColor(0, 0)));
        assertEquals("75,75,75", colorToString(grayScaleImg.getColor(0, 1)));
        assertEquals("50,50,50", colorToString(grayScaleImg.getColor(1, 0)));
        assertEquals("220,220,220", colorToString(grayScaleImg.getColor(1, 1)));
	}
	
	@Test
	void BinarizationAdjusterTest() {

		Image img = new Image(2, 2);
		img.setColor(0, 0, new Color(100, 150, 200));
        img.setColor(0, 1, new Color(50, 75, 100));  
        img.setColor(1, 0, new Color(25, 50, 75));  
        img.setColor(1, 1, new Color(200, 220, 240)); 
        Image binarizedImg = Images.transform(img, new BinarizationAdjuster());
        assertEquals("255,255,255", colorToString(binarizedImg.getColor(0, 0)));
        assertEquals("0,0,0", colorToString(binarizedImg.getColor(0, 1)));
        assertEquals("0,0,0",colorToString( binarizedImg.getColor(1, 0)));
        assertEquals("255,255,255", colorToString(binarizedImg.getColor(1, 1)));
		
	}


}
