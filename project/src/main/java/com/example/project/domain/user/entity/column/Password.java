package com.example.project.domain.user.entity.column;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Password {
    @Size(min = 6, max = 20)
    @Column(name = "password", nullable = false, unique = true)
    private String value;

    @Builder
    protected Password(String value) {
        this.value = value;
    }

    public static Password of(String password) {
        return new Password(password);
    }
}