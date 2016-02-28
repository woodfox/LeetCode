package third;

public class RetangleArea {
    public int computeArea(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int xStart = Math.max(x1, x3);
        int xEnd = Math.min(x2, x4);
        int yStart = Math.max(y1, y3);
        int yEnd = Math.min(y2, y4);

        int mixed = 0;
        if(xStart < xEnd && yStart < yEnd) {
            mixed = (xEnd-xStart) * (yEnd - yStart);
        }

        return (x2-x1)*(y2-y1) + (x4-x3)*(y4-y3) - mixed;
    }
}
