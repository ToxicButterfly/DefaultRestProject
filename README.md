# Default REST Project

## Описание
Это проект REST API, созданный с использованием Spring Boot, который позволяет управлять книгами и авторами. Приложение предоставляет CRUD операции для сущностей книги и автора.

## Технологии
- Java 17
- Spring Boot 3.3.1
- Hibernate
- PostgreSQL
- ModelMapper
- Lombok
- Maven

## Установка и настройка

### Предварительные условия
- Убедитесь, что у вас установлены следующие программные обеспечения:
    - JDK 17
    - Maven 3.6+
    - PostgreSQL 13+
    - Git

### Запуск приложения локально
```bash
mvn spring-boot:run
```

## API
### /books
`GET` : Get all books

`POST` : Save new book

### /books/:id
`GET` : Get a book

`PUT` : Save or update book

`DELETE` : Delete book

### /authors
`GET` : Get all authors

`POST` : Save new author

### /authors/:id
`GET` : Get an author

`PUT` : Save or update author

`DELETE` : Delete author