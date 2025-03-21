package br.com.agendasmile.agenda.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateOfficeDto {
    @JsonProperty("name")
    private String name;

    @JsonProperty("admin")
    private CreateAdminDto admin;

    public String getName() {
        return this.name;
    }

    public CreateAdminDto getAdmin() {
        return this.admin;
    }
}
