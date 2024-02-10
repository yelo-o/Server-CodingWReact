package org.zerock.mallapi.repository;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.mallapi.domain.Todo;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void testInsert() {
        for (int i = 1; i <= 100; i++) {
            Todo todo = Todo.builder()
            .title("Title..." + i)
            .dueDate(LocalDate.of(2023,12,31))
            .writer("user00")
            .build();

            todoRepository.save(todo);
        }
    }

    @Test
    public void testRead() {
        //존재하는 번호로 확인
        Long tno = 33L;

        java.util.Optional<Todo> result = todoRepository.findById(tno);

        Todo todo = result.orElseThrow();

        log.info(todo);
    }
    
}
