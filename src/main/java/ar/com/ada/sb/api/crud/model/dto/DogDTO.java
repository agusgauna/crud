package ar.com.ada.sb.api.crud.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DogDTO {
    private Long id;
    private String breed;
    private String sex;

    public DogDTO(Long id, String breed, String sex) {
        this.id = id;
        this.breed = breed;
        this.sex = sex;
    }

    public DogDTO(String breed, String sex) {
        this.breed = breed;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "DogDTO{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
