/*
 * Created on 2025-04-03
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

public enum Direction {
    // TODO: Implement.
        UP,
        DOWN,
        LEFT,
        RIGHT
    ;

    public Position deltaPosition () {
        // TODO: should return the new position after the snake has moved
        // The position should either move +1 or -1 along the x or y axis
        switch (this) {
            case UP:
            return new Position(0,-1);
            case DOWN:
            return new Position(0,1);
            case LEFT:
            return new Position(-1,0);
            case RIGHT:
            return new Position(1,0);
            default:
            return new Position(0, 0); // default position if not moving
        }
    }
}
