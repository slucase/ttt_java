public class Cell {

    public int x, y;

    public Cell (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Cell (int buttonNumber){
        switch (buttonNumber){
            case 0:
                this.x = 0;
                this.y = 0;
            case 1:
                this.x = 0;
                this.y = 1;
            case 2:
                this.x = 0;
                this.y = 2;
            case 3:
                this.x = 1;
                this.y = 0;
            case 4:
                this.x = 1;
                this.y = 1;
            case 5:
                this.x = 1;
                this.y = 2;
            case 6:
                this.x = 2;
                this.y = 0;
            case 7:
                this.x = 2;
                this.y = 1;
            case 8:
                this.x = 2;
                this.y = 2;
        }
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
