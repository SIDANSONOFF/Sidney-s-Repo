package reversi.model;

/**
 * Used to indicate a search direction.
 */
public enum Direction {
    TOP(-1, 0),
    TOP_RIGHT(-1, +1),
    RIGHT(0, +1),
    BOTTOM_RIGHT(+1, +1),
    BOTTOM(+1, 0),
    BOTTOM_LEFT(+1, -1),
    LEFT(0, -1),
    TOP_LEFT(-1, -1);

    /**
     * The modifier for the row between each iteration of the search.
     */
    private int rowMod;

    /**
     * The modifier for the column between each iteration of the search.
     */
    private int colMod;

    /**
     * Creates a new direction with the specified modifiers.
     *
     * @param rowMod The modifier for the row.
     * @param colMod The modifier for the column.
     */
    Direction(int rowMod, int colMod) {
        this.rowMod = rowMod;
        this.colMod = colMod;
    }

    /**
     * Returns the row modifier.
     *
     * @return Returns by how much the row should be modified between
     * iterations.
     */
    public int getRowMod() {
        return rowMod;
    }

    /**
     * Returns the column modifier.
     *
     * @return Returns by how much the column should be modified between
     * iterations.
     */
    public int getColMod() {
        return colMod;
    }
}
