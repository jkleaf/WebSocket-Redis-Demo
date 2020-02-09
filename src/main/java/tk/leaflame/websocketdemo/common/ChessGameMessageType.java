package tk.leaflame.websocketdemo.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;
import java.util.function.Function;

/**
 * @author leaflame
 * @date 2020/2/7 12:20
 */
public enum ChessGameMessageType {

    //TODO
    COORDINATE {
    },
    UNDO,
    SENTE,
    YIELD;

    private Coordinate coordinate;

    private CoordinateHandler coordinateHandler;

    ChessGameMessageType() {
    }

    ChessGameMessageType(CoordinateHandler coordinateHandler, Coordinate coordinate) {
        this.coordinateHandler = coordinateHandler;
        this.coordinate = coordinate;
    }

//    abstract Function action();

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public void handle() throws CoordinateIllegalException {
        coordinateHandler.action(Optional.of(coordinate).orElseThrow(CoordinateIllegalException::new));
    }

    @FunctionalInterface
    public interface CoordinateHandler<R> {
        R action(Coordinate coordinate);
    }

    @Data
    @AllArgsConstructor
    public static class Coordinate {
        private int x;
        private int y;
    }

    private final static class CoordinateIllegalException extends Exception {

        private final static String DEFAULT_MESSAGE = "Coordinate Illegal!";

        CoordinateIllegalException() {
            this(DEFAULT_MESSAGE);
        }

        CoordinateIllegalException(String message) {
            super(message);
        }
    }
}
