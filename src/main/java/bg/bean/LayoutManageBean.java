package bg.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "layoutManageBean")
@SessionScoped
public class LayoutManageBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer nordSize = 90;
    private Integer westSize = 350;
    private String westHeader = "Профилактика и Ремонти по Автомобила";
    private Integer eastSize = 340;
    private String eastHeader = "Полезна Информация";
    private Integer southSize = 240;
    private String southHeader = "Основни индикаций използвани в повечето автомобилни табла:";

    public void setCurrentUserPageLayout() {
        this.nordSize = 90;
        this.westSize = 350;
        this.westHeader = "Профилактика и Ремонти по Автомобила";
        this.eastSize = 340;
        this.eastHeader = "Добави Автомобил";
        this.southSize = 150;
        this.southHeader = "Основни индикаций използвани в повечето автомобилни табла:";
    }

    public void setAdminView() {
        this.nordSize = 90;
        this.westSize = 10;
        this.westHeader = "";
        this.eastSize = 10;
        this.eastHeader = "";
        this.southSize = 10;
        this.southHeader = "";
    }

    public Integer getNordSize() {
        return nordSize;
    }

    public void setNordSize(Integer nordSize) {
        this.nordSize = nordSize;
    }

    public Integer getWestSize() {
        return westSize;
    }

    public void setWestSize(Integer westSize) {
        this.westSize = westSize;
    }

    public String getWestHeader() {
        return westHeader;
    }

    public void setWestHeader(String westHeader) {
        this.westHeader = westHeader;
    }

    public Integer getEastSize() {
        return eastSize;
    }

    public void setEastSize(Integer eastSize) {
        this.eastSize = eastSize;
    }

    public String getEastHeader() {
        return eastHeader;
    }

    public void setEastHeader(String eastHeader) {
        this.eastHeader = eastHeader;
    }

    public Integer getSouthSize() {
        return southSize;
    }

    public void setSouthSize(Integer southSize) {
        this.southSize = southSize;
    }

    public String getSouthHeader() {
        return southHeader;
    }

    public void setSouthHeader(String southHeader) {
        this.southHeader = southHeader;
    }
}
