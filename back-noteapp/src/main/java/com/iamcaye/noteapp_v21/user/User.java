package com.iamcaye.noteapp_v21.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public record User(
        @Id
        Integer id,
        String username,
        String email
) { }