import org.junit.Assert;
import org.junit.Test;

public class ColourTest {

    @Test
    public void testEquals() {
        Colour colour = new Colour(12, 55, 89);
        Colour colour2 = new Colour(12, 55, 89);

        Assert.assertEquals(colour, colour2);
    }

    @Test
    public void testEqualsWithDiffrentConstructors() {
        Colour colour = new Colour("RGB", 12, 55, 89);
        Colour colour2 = new Colour(12, 55, 89);

        Assert.assertEquals(colour, colour2);
    }

    @Test
    public void testNotEquals() {
        Colour colour = new Colour(12, 55, 89);
        Colour colour2 = new Colour(12, 45, 255);

        Assert.assertFalse(colour.equals(colour2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidValues() {
        Colour colour = new Colour(23, 405, 56);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMinusValues() {
        Colour colour = new Colour(23, 34, -4);
    }

    @Test
    public void addColor() {
        Colour colour1 = new Colour(12,34,67);
        Colour colour2 = new Colour(45,78,100);

        Colour colour3 = new Colour(57,112,167);
        Assert.assertEquals(colour3,colour1.addColor(colour2));
    }

    @Test
    public void addColorExceeding255() {
        Colour colour1 = new Colour(100,200,240);
        Colour colour2 = new Colour(45,78,100);

        Colour colour3 = new Colour(145,255,255);
        Assert.assertEquals(colour3,colour1.addColor(colour2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addColorWithDiffrentModels() {
        Colour colour1 = new Colour("CMYK",100,200,240);
        Colour colour2 = new Colour(45,78,100);

        Colour colour3 = new Colour(145,255,255);
        Assert.assertEquals(colour3,colour1.addColor(colour2));
    }
}