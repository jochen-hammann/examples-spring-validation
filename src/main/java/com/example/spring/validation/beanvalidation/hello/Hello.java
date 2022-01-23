package com.example.spring.validation.beanvalidation.hello;

import com.example.spring.validation.beanvalidation.custom.ContactNumberConstraint;

import javax.validation.constraints.*;

public class Hello
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    @NotEmpty(message = "The field 'nonEmpty' must not be null or empty.")
    private String nonEmpty;

    @NotBlank(message = "The field 'nonBlank' must not be null or blank (not empty after trim).")
    private String nonBlank;

    @NotNull(message = "The field 'min10max20' must not be null.")
    @Min(value = 10, message = "The field 'min10max20' must contain a value between 10 and 20.")
    @Max(value = 20, message = "The field 'min10max20' must contain a value between 10 and 20.")
    private Long min10max20;

    @ContactNumberConstraint(message = "The phone number must contain more than 8 and less than 14 numbers.")
    private String phone;

    // ============================== [Construction / Destruction] ==============================

    // -------------------- [Public Construction / Destruction] --------------------

    // ============================== [Getter/Setter] ==============================

    // -------------------- [Private Getter/Setter] --------------------

    // -------------------- [Public Getter/Setter] --------------------

    // ============================== [Methods] ==============================

    // -------------------- [Private Methods] --------------------

    // -------------------- [Public Methods] --------------------

    public String getNonEmpty()
    {
        return nonEmpty;
    }

    public void setNonEmpty(String nonEmpty)
    {
        this.nonEmpty = nonEmpty;
    }

    public String getNonBlank()
    {
        return nonBlank;
    }

    public void setNonBlank(String nonBlank)
    {
        this.nonBlank = nonBlank;
    }

    public Long getMin10max20()
    {
        return min10max20;
    }

    public void setMin10max20(Long min10max20)
    {
        this.min10max20 = min10max20;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }
}
