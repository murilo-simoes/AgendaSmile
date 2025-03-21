package br.com.agendasmile.agenda.dto;

import br.com.agendasmile.agenda.models.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.UUID;

public class ListDentistDto implements Serializable {

    private static final Long serrialVersionUUID = 1L;

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("first_name")
    private String first_name;

    @JsonProperty("last_name")
    private String last_name;

    @JsonProperty("created_at")
    private String created_at;

    @JsonProperty("email")
    private String email;

    public ListDentistDto(User dentist) {
        this.id = dentist.getId();
        this.first_name = dentist.getFirst_name();
        this.last_name = dentist.getLast_name();

        this.created_at = dentist.getCreated_at().toLocalDateTime().toString();
        this.email = dentist.getEmail();
    }
}
