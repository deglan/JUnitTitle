package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Message {

    REGEX_TITLE("[^a-zA-Z0-9]"),
    REPLACE_TITLE(""),
    INCORRECT_TITLE("Tytuł strony jest nieprawidłowy."),
    SITE_TITLE_PARAMETRIZED("Test tytułu strony: {0}");

    private final String message;
}
