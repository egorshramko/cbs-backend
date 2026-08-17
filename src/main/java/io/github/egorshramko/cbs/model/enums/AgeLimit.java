package io.github.egorshramko.cbs.model.enums;

import lombok.Getter;

@Getter
public enum AgeLimit {
    NO_LIMIT("0+", 0),
    OLDER_6("6+", 6),
    OLDER_12("12+", 12),
    OLDER_16("16+", 16),
    ADULT_ONLY("18+", 18);

    private final String description;
    private final Integer limit;

    AgeLimit(String description, Integer limit) {
        this.description = description;
        this.limit = limit;
    }
}
