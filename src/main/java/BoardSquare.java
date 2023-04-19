public class BoardSquare {
    private boolean emptySpace;
    private Unit unit;
    private String squareColor;
    public BoardSquare(String squareColor) {
        this.emptySpace = false;
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
        if(this.unit != null) {
            return "-" + this.unit.toString();
        } else {
            return "-------";
        }
    }


}
