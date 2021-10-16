package com.example.project.user.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.stream.Stream;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email {

    @javax.validation.constraints.Email
    @Column(name = "email", nullable = false, unique = true)
    private String value;

    @Builder
    public Email(String value) {
        this.value = value;
    }

    public static Email of(String email) {
        return new Email(email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String getHost() {
        int index = value.indexOf("@");
        return value.substring(index);
    }

    public String getId() {
        int index = value.indexOf("@");
        return value.substring(0, index);
    }
}