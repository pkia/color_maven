/** Represents a Colour Model.
 * @author Evan Dunbar
 * @version 1
 * @since 1.0
 * The Colour class must implement the following functionality
 * •To create a Colour object you must specify exactly three colour components
 * •It is not allowed to create a Colour object without specifying valid component values
 * •Valid component values are in the range 0 to 255
 * •The default colour model is RGB
 * •A different colour models is specified by using a String value to identify the name of the model when creating the Colour object
 * •Colours can be compared, to be equal they must have the same colour model and same component values •Colours can be added, if they use the same model, by adding each of the components, however the value of each component cannot exceed 255
 */
public class Colour { //creating colour class

    private String colourModel; //adding model
    private int colourComponent1; //componenents R,G,B
    private int colourComponent2;
    private int colourComponent3;

    public Colour(int colourComponent1, int colourComponent2, int colourComponent3) {
        if (colourComponent1 > 255 || colourComponent2 > 255 || colourComponent3 > 255 //TESTING
                || colourComponent1 < 0 || colourComponent2 < 0 || colourComponent3 < 0)
            throw new IllegalArgumentException("Color Component must be in 0-255 range");
        this.colourModel = "RGB";
        this.colourComponent1 = colourComponent1;
        this.colourComponent2 = colourComponent2;
        this.colourComponent3 = colourComponent3;
        /** Sets the employee’s first name.
         * @param colourModel A String containing the
         *     colour modal type.
         * @param colourComponent1 First colour component.
         * @param colourComponent2 Second colour component.
         * @param colourComponent3 Third colour component
         *
         */
    }

    public Colour(String colourModel, int colourComponent1, int colourComponent2, int colourComponent3) {
        if (colourComponent1 > 255 || colourComponent2 > 255 || colourComponent3 > 255 //TESTING
                || colourComponent1 < 0 || colourComponent2 < 0 || colourComponent3 < 0)
            throw new IllegalArgumentException("Color Component must be in 0-255 range");
        this.colourModel = colourModel;
        this.colourComponent1 = colourComponent1;
        this.colourComponent2 = colourComponent2;
        this.colourComponent3 = colourComponent3;
    }

    public String getColourModel() {
        return colourModel;
    } //GETTERS

    public int getColourComponent1() {
        return colourComponent1;
    }

    public int getColourComponent2() {
        return colourComponent2;
    }

    public int getColourComponent3() {
        return colourComponent3;
    }

    public boolean equals(Object o) {
        Colour c = (Colour) o;
        if (colourModel.equals(c.getColourModel()) && colourComponent1 == c.getColourComponent1()
                && colourComponent2 == c.getColourComponent2() && colourComponent3 == c.getColourComponent3())
            return true;
        return false;
    }

    public Colour addColor(Colour c){
        if(!c.getColourModel().equals(this.colourModel))
            throw new IllegalArgumentException("Colour Modal of the 2 colours should be same");

        int comp1 = colourComponent1 + c.getColourComponent1();
        int comp2 = colourComponent2 + c.getColourComponent2();
        int comp3 = colourComponent3 + c.getColourComponent3();

        if(comp1>255)
            comp1 = 255;
        if(comp2>255)
            comp2 = 255;
        if(comp3>255)
            comp3 = 255;

        Colour newColour = new Colour(colourModel,comp1,comp2,comp3);
        return newColour;
    }
}
