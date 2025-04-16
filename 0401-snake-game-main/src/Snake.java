/*
 * Created on 2025-04-03
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class Snake {
    private SnakeSegment head;
    private Direction direction = Direction.RIGHT; // Default direction
    //TODO test
    private boolean shouldGrow = false;
    LinkedList<SnakeSegment> snake = new LinkedList<>(); //Creates a linked list to make a snake



    public Snake() {
        // You may change this code for extra credit (implement some fancy stuff!)
        // Feel free to make the starting position random
        Position startingPosition = new Position(10, 10);
        head = new SnakeSegment(startingPosition);
        snake.add(head);
    }

    // TODO: The snake should grow whenever it "eats" a food item
    public void shouldGrow() {
        //snake.addLast(body);
        shouldGrow = true;
    }

    // TODO: Remove the last node (tail) of the snake, leave head untouched
    private void removeTail() {
        if (snake.size() > 1) {
            snake.removeLast();//Removes the last from the LinkedList

            //Updates the linked list of SnakeSegments
            SnakeSegment current = head;
            while (current.getNext() != null && current.getNext().getNext() != null) {
                current = current.getNext();
            }

            if (current != null) {
                current.setNext(null); //Cuts off the old tail
            }
        }

    }

    // Returns true if the snake is colliding with itself
    public boolean isColliding() {
        if (isBodyPartAt(head.getPosition())) {
            return true;
        }
        return false;
    }

    // TODO: Implement isInSnake()
    // Returns false if the specified position is inside the body of the snake
    public boolean isBodyPartAt(Position position) {
        //Head is index 0, skips head
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(i).getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    // Sets the direction the snake will move in
    public void setDirection(Direction direction) {
        this.direction = direction;

    }

    // TODO: Get the length of the snake
    public int getLength() {
        int count = 0;
        SnakeSegment current = head;
        while (current!= null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    // Moves the snake by one in the next direction
    // TODO: Implement move()
    public void move() {
        Position newPosition = head.getPosition().add(direction.deltaPosition());
        SnakeSegment newHead = new SnakeSegment(newPosition);

        newHead.setNext(head); //Links new head to old head
        head = newHead;
        snake.addFirst(newHead); //Adds to the front of the linked list tracker

        //TODO REMOVE IF WORKS
        // ...

        // * OPTIONAL: also handle wrapping left and right here
        // * Or check for a collision with the top and bottom of the frame

        // HINT: You may add and remove nodes here

        // TODO: Uncomment and use the following code snippet
        if (!shouldGrow) {
        removeTail();
        } else {
        shouldGrow = false;
        }
    }

    // Return the head of the snake
    public SnakeSegment getHead() {
        return this.head;
    }

    // TODO: Return the start of the body (NOT the head!)
    public SnakeSegment getBody() {
        if (snake.size() > 1) {
            return snake.get(1); //Index 0 is the head
        }
        return null;
    }

    // OPTIONAL: Implement an algorithm that moves the food for us
    public Direction findNextMove(ArrayList<Food> food) {
        return null;
    }
}

class SnakeSegment {
    private Position position;
    private SnakeSegment next;

    public SnakeSegment(Position pos) {
        this.position = pos;
    }

    public Position getPosition() {
        return this.position;
    }

    public SnakeSegment getNext() {
        return this.next;
    }

    public void setNext(SnakeSegment next) {
        this.next = next;
    }
}
