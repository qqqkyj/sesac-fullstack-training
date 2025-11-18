package com.example.todoapp.repository;

import com.example.todoapp.dto.TodoDto;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TodoRepository {
    private final Map<Long, TodoDto> storage = new ConcurrentHashMap<>(); //HashMap보다 멀티스레드 환경에서 안정적으로 작동
    private long nextId = 1L;

}
