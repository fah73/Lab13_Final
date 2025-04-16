/*
 * Created on 2025-04-03
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

import java.util.Random;

public abstract class Food {
    public abstract Position getPosition();

    public abstract String getIcon();

    public static Food randomFood(Position position) {
        int maxActiveFoodItems = 4; //4 food items are in play for the game

        int randomNumber = new Random().nextInt(maxActiveFoodItems);

        switch (randomNumber) {
            case 0:
                return new Cherry(position);
            case 1:
                return new Apple(position);
            case 2:
                return new Cookie(position);
            case 3:
                return new Lemon(position);
            default:
                return null;
        }

    }
}
