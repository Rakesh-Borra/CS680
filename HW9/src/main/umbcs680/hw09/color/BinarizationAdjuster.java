package umbcs680.hw09.color;

public class BinarizationAdjuster  implements ColorAdjuster{

	@Override
	public Color adjust(Color color) {

		int r, g, b;
		r = color.getRedScale();
		g = color.getGreenScale();
		b = color.getBlueScale();
		int avg = (r+g+b)/3;
		if (avg <= 125) {
            return new Color(0, 0, 0); 
        } else {
            return new Color(255, 255, 255);
        }
	}


}
