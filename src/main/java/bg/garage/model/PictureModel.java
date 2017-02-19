package bg.garage.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class PictureModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Byte[] picture;

    public PictureModel() {

    }

    public PictureModel(Byte[] picture) {
        super();
        this.picture = picture;
    }

    public PictureModel(Long id, Byte[] picture) {
        super();
        this.id = id;
        this.picture = picture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte[] getPicture() {
        return picture;
    }

    public void setPicture(Byte[] picture) {
        this.picture = picture;
    }

}
