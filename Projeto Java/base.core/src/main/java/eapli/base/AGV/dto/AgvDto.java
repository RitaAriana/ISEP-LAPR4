package eapli.base.AGV.dto;

import eapli.framework.representations.dto.DTO;

@DTO
public class AgvDto {

    public String id;

    public String volume;

    public String weight;

    public AgvDto(String id) {
        this.id = id;
    }

    public AgvDto(String id, String volume, String weight){
        this.id = id;
        this.volume = volume;
        this.weight = weight;
    }

    public String getId() {
        return id;
    } //rever classe

    public String getVolume() {
        return volume;
    }

    public String getWeight() {
        return weight;
    }
}
