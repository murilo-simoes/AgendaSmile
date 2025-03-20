package br.com.agendasmile.agenda.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreatePatientDto {
    @NotBlank
    @JsonProperty("first_name")
    private String firstName;

    @NotBlank
    @JsonProperty("last_name")
    private String lastName;

    @NotBlank
    @Size(min = 11, max = 11)
    @JsonProperty("cpf")
    private String cpf;

    @NotBlank
    @JsonProperty("birth_date")
    private String birthDate;

    @NotBlank
    @Size(min = 4, max = 10)
    @JsonProperty("gender")
    private String gender;

    @NotBlank
    @Size(min = 11, max = 11)
    @JsonProperty("phone_number")
    private String phoneNumber;

    @Email
    @NotBlank
    @JsonProperty("email")
    private String email;

    @Size(max = 255)
    @JsonProperty("obs")
    private String obs;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getObs() {
        return obs;
    }
}
