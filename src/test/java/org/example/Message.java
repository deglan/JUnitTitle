package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Message {

    INCORRECT_TITLE("Tytuł strony jest nieprawidłowy.");

    private final String message;
}
