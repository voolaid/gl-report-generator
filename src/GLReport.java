import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GLReport {

    public enum ReportGroup { Department, Division, CostCenter }

    private String reportTitle;
    private Date beginDate;
    private Date endDate;
    private Date createDate;
    private String currency;

    private List<ReportGroup> grouping;     // [Department] = groups by department only
                                            // [Division, Department] = first groups by division, then by department
                                            // [CostCenter, Division] = first groups by cost center, then by division
                                            // [CostCenter, Division, Department] = first groups by cost center, then by division and finally by department
                                            // [..., ..., ...] = etc

    private List<GLEntry> glEntries;

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void addColumn(String header, String formula) {

    }

    public void setGrouping(ReportGroup... grouping) {
        if (this.grouping == null) {
            this.grouping = new ArrayList<>();
        }

        for(ReportGroup group : grouping) {
            this.grouping.add(group);
        }
    }

    public List<ReportGroup> getGrouping() {
        return grouping;
    }

    public String getHtmlOutput() {
        return "";
    }

}
