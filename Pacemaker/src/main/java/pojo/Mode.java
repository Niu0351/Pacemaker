package pojo;

import java.math.BigDecimal;

public class Mode {

    private Integer id;
    private String mode;
    private BigDecimal LRL;
    private BigDecimal URL;
    private BigDecimal AA;
    private BigDecimal VA;
    private BigDecimal APW;
    private BigDecimal VPW;
    private BigDecimal VRP;
    private BigDecimal ARP;
    private BigDecimal MSR;
    private BigDecimal FAD;
    private BigDecimal AS;
    private BigDecimal VS;
    private BigDecimal PVARP;
    private BigDecimal AT;
    private BigDecimal RT;
    private BigDecimal RF;
    private BigDecimal RecT;

    public Mode() {
    }

    public Mode(Integer id, String mode, BigDecimal LRL, BigDecimal URL, BigDecimal AA, BigDecimal VA, BigDecimal APW, BigDecimal VPW, BigDecimal VRP, BigDecimal ARP, BigDecimal MSR, BigDecimal FAD, BigDecimal AS, BigDecimal VS, BigDecimal PVARP, BigDecimal AT, BigDecimal RT, BigDecimal RF, BigDecimal recT) {
        this.id = id;
        this.mode = mode;
        this.LRL = LRL;
        this.URL = URL;
        this.AA = AA;
        this.VA = VA;
        this.APW = APW;
        this.VPW = VPW;
        this.VRP = VRP;
        this.ARP = ARP;
        this.MSR = MSR;
        this.FAD = FAD;
        this.AS = AS;
        this.VS = VS;
        this.PVARP = PVARP;
        this.AT = AT;
        this.RT = RT;
        this.RF = RF;
        RecT = recT;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public BigDecimal getLRL() {
        return LRL;
    }

    public void setLRL(BigDecimal LRL) {
        this.LRL = LRL;
    }

    public BigDecimal getURL() {
        return URL;
    }

    public void setURL(BigDecimal URL) {
        this.URL = URL;
    }

    public BigDecimal getAA() {
        return AA;
    }

    public void setAA(BigDecimal AA) {
        this.AA = AA;
    }

    public BigDecimal getVA() {
        return VA;
    }

    public void setVA(BigDecimal VA) {
        this.VA = VA;
    }

    public BigDecimal getAPW() {
        return APW;
    }

    public void setAPW(BigDecimal APW) {
        this.APW = APW;
    }

    public BigDecimal getVPW() {
        return VPW;
    }

    public void setVPW(BigDecimal VPW) {
        this.VPW = VPW;
    }

    public BigDecimal getVRP() {
        return VRP;
    }

    public void setVRP(BigDecimal VRP) {
        this.VRP = VRP;
    }

    public BigDecimal getARP() {
        return ARP;
    }

    public void setARP(BigDecimal ARP) {
        this.ARP = ARP;
    }

    public BigDecimal getMSR() {
        return MSR;
    }

    public void setMSR(BigDecimal MSR) {
        this.MSR = MSR;
    }

    public BigDecimal getFAD() {
        return FAD;
    }

    public void setFAD(BigDecimal FAD) {
        this.FAD = FAD;
    }

    public BigDecimal getAS() {
        return AS;
    }

    public void setAS(BigDecimal AS) {
        this.AS = AS;
    }

    public BigDecimal getVS() {
        return VS;
    }

    public void setVS(BigDecimal VS) {
        this.VS = VS;
    }

    public BigDecimal getPVARP() {
        return PVARP;
    }

    public void setPVARP(BigDecimal PVARP) {
        this.PVARP = PVARP;
    }

    public BigDecimal getAT() {
        return AT;
    }

    public void setAT(BigDecimal AT) {
        this.AT = AT;
    }

    public BigDecimal getRT() {
        return RT;
    }

    public void setRT(BigDecimal RT) {
        this.RT = RT;
    }

    public BigDecimal getRF() {
        return RF;
    }

    public void setRF(BigDecimal RF) {
        this.RF = RF;
    }

    public BigDecimal getRecT() {
        return RecT;
    }

    public void setRecT(BigDecimal recT) {
        RecT = recT;
    }

    @Override
    public String toString() {
        return "Mode{" +
                "id=" + id +
                ", mode='" + mode + '\'' +
                ", LRL=" + LRL +
                ", URL=" + URL +
                ", AA=" + AA +
                ", VA=" + VA +
                ", APW=" + APW +
                ", VPW=" + VPW +
                ", VRP=" + VRP +
                ", ARP=" + ARP +
                ", MSR=" + MSR +
                ", FAD=" + FAD +
                ", AS=" + AS +
                ", VS=" + VS +
                ", PVARP=" + PVARP +
                ", AT=" + AT +
                ", RT=" + RT +
                ", RF=" + RF +
                ", RecT=" + RecT +
                '}';
    }
}
