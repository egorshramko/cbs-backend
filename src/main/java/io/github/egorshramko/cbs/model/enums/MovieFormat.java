package io.github.egorshramko.cbs.model.enums;

public enum MovieFormat {
    _2D("2D"),
    _3D("3D"),
    IMAX("IMAX");

    private final String format;

    MovieFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
