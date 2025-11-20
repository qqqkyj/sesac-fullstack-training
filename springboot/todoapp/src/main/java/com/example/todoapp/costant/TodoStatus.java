package com.example.todoapp.costant;

public enum TodoStatus {
    NORMAL(0),
    DELETE(1),
    UPDATE(2),
    COMPLETED(3),
    INCOMPLETED(4);

    private final int code;

    TodoStatus(int code) { this.code = code; }

    public int getCode() { return code; }

    public static TodoStatus fromCode(int code) {
        for (TodoStatus s : values()) {
            if (s.code == code) return s;
        }
        throw new IllegalArgumentException("Unknown status: " + code);
    }
}

