package com.qadata.vo.InspectionReport.sub;

import java.util.List;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class WorkmanShipDetailsObject {

    private String workmanshipDetails;

    private List<WorkmanShipObject> workmanShipObjects;

    public String getWorkmanshipDetails() {
        return workmanshipDetails;
    }

    public void setWorkmanshipDetails(String workmanshipDetails) {
        this.workmanshipDetails = workmanshipDetails;
    }

    public List<WorkmanShipObject> getWorkmanShipObjects() {
        return workmanShipObjects;
    }

    public void setWorkmanShipObjects(List<WorkmanShipObject> workmanShipObjects) {
        this.workmanShipObjects = workmanShipObjects;
    }
}
