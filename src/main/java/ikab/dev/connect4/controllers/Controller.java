package ikab.dev.connect4.controllers;

import ikab.dev.connect4.models.Color;
import ikab.dev.connect4.models.Coordinate;
import ikab.dev.connect4.models.Session;

public abstract class Controller {

    protected Session session;

    Controller(Session session) {
        this.session= session;
    }

    public void nextState() {
        this.session.nextState();
    }


    public Color getColor(Coordinate coordinate) {
        return this.session.getColor(coordinate);
    }

}