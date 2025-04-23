package assignment9;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

public class Snake {
    private static final double SEGMENT_SIZE = 0.02;
    private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
    private LinkedList<BodySegment> segments;
    private double deltaX = MOVEMENT_SIZE;
    private double deltaY = 0;

    public Snake() {
        segments = new LinkedList<>();
        segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE));
    }

    public void changeDirection(int direction) {
        switch (direction) {
            case 1 -> { deltaX = 0; deltaY = MOVEMENT_SIZE; }
            case 2 -> { deltaX = 0; deltaY = -MOVEMENT_SIZE; }
            case 3 -> { deltaX = -MOVEMENT_SIZE; deltaY = 0; }
            case 4 -> { deltaX = MOVEMENT_SIZE; deltaY = 0; }
        }
    }

    public void move() {
        BodySegment head = segments.getFirst();
        double newX = head.getX() + deltaX;
        double newY = head.getY() + deltaY;
        segments.addFirst(new BodySegment(newX, newY, SEGMENT_SIZE));
        segments.removeLast();
    }

    public void draw() {
        for (BodySegment segment : segments) {
            segment.draw();
        }
    }

    public boolean eatFood(Food f) {
        BodySegment head = segments.getFirst();
        if (Math.abs(head.getX() - f.getX()) < SEGMENT_SIZE && Math.abs(head.getY() - f.getY()) < SEGMENT_SIZE) {
            segments.add(new BodySegment(-1, -1, SEGMENT_SIZE)); // Add offscreen segment for now
            return true;
        }
        return false;
    }

    public boolean isInbounds() {
        BodySegment head = segments.getFirst();
        return head.getX() >= 0 && head.getX() <= 1 && head.getY() >= 0 && head.getY() <= 1;
    }
}