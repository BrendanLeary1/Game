public class BoardSquare {
    private boolean emptySpace;
    private Unit unit;
    private String squareColor;
    public boolean isPlate;
    public BoardSquare(String squareColor) {
        this.squareColor = squareColor;
        this.emptySpace = true;
        this.isPlate = false;
    }

    public Unit getUnit(){
        return this.unit;
    }
    public boolean isEmptySpace() {
        return this.emptySpace;
    }
    public String getSquareColor() {
        return this.squareColor;
    }
    public void setSquareColor(String squareColor) {
        this.squareColor = squareColor;
    }
    public void setEmptySpace(boolean emptySpace) {
        this.emptySpace = emptySpace;
    }

    public void setPlate(boolean plate) {
        isPlate = plate;
    }

    public boolean getPlate(){
        return this.isPlate;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
        this.emptySpace = false;
    }

    public Unit removeUnit() {
        Unit temp = this.unit;
        this.unit = null;
        this.emptySpace = true;
        return temp;
    }

    @Override
    public String toString() {
        if (this.unit == null) {
            return "-------";
        }
        else {
            return "-" + this.getUnit().toString();
        }
    }


}