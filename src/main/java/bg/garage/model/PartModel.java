package bg.garage.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class PartModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String article;
    private String mark;
    private String catalogNumber;
    private String description;
    private Integer pieces;
    private Double price;

    public PartModel() {

    }

    public PartModel(String article, String mark, String catalogNumber, String description, Integer pieces,
            Double price) {
        super();
        this.article = article;
        this.mark = mark;
        this.catalogNumber = catalogNumber;
        this.description = description;
        this.pieces = pieces;
        this.price = price;
    }

    public PartModel(Long id, String article, String mark, String catalogNumber, String description, Integer pieces,
            Double price) {
        super();
        this.id = id;
        this.article = article;
        this.mark = mark;
        this.catalogNumber = catalogNumber;
        this.description = description;
        this.pieces = pieces;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPieces() {
        return pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
