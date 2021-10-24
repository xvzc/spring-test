package com.example.project.domain.user.entity.column;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email {
    @javax.validation.constraints.Email
    @Column(name = "email", nullable = false, unique = true)
    private String value;

    @Builder
    protected Email(String value) {
        this.value = value;
    }

    public static Email of(String email) {
        return new Email(email);
    }
}