public class BaseInfo {

    private boolean flag = false;
    //编号
    private String Id;
    //消火栓名称
    private String FireHydrant;
    //消火栓地址
    private String FireHydrantAdress;
    //经度
    private String Longitude;
    //纬度
    private String Latitude;
    //所属路段
    private String Road;
    //放置形式
    private String PlacementForm;
    //接口形式
    private String InterfaceForm;
    //取水形式
    private String WaterFrom;
    //所属管网
    private String Departments;
    //管网形式
    private String PipeNetwork;
    //管网直径
    private String Diameter;
    //管网压力
    private String Pressure;
    //流量大小
    private String Flowsize;
    //供水单位
    private String Watersupply;
    //检查记录
    private String Inspectionrecord;
    //所在地消防机构
    private String FireFightingInstitutions;

    private String getId() {
        return Id;
    }

    private void setId(String id) {
        Id = id;
    }

    private String getFireHydrant() {
        return FireHydrant;
    }

    private void setFireHydrant(String fireHydrant) {
        FireHydrant = fireHydrant;
    }

    private String getFireHydrantAdress() {
        return FireHydrantAdress;
    }

    private void setFireHydrantAdress(String fireHydrantAdress) {
        FireHydrantAdress = fireHydrantAdress;
    }

    private String getLongitude() {
        return Longitude;
    }

    private void setLongitude(String longitude) {
        Longitude = longitude;
    }

    private String getLatitude() {
        return Latitude;
    }

    private void setLatitude(String latitude) {
        Latitude = latitude;
    }

    private String getRoad() {
        return Road;
    }

    private void setRoad(String road) {
        Road = road;
    }

    private String getPlacementForm() {
        return PlacementForm;
    }

    private void setPlacementForm(String placementForm) {
        PlacementForm = placementForm;
    }

    private String getInterfaceForm() {
        return InterfaceForm;
    }

    private void setInterfaceForm(String interfaceForm) {
        InterfaceForm = interfaceForm;
    }

    private String getWaterFrom() {
        return WaterFrom;
    }

    private void setWaterFrom(String waterFrom) {
        WaterFrom = waterFrom;
    }

    private String getDepartments() {
        return Departments;
    }

    private void setDepartments(String departments) {
        Departments = departments;
    }

    private String getPipeNetwork() {
        return PipeNetwork;
    }

    private void setPipeNetwork(String pipeNetwork) {
        PipeNetwork = pipeNetwork;
    }

    private String getDiameter() {
        return Diameter;
    }

    private void setDiameter(String diameter) {
        Diameter = diameter;
    }

    private String getPressure() {
        return Pressure;
    }

    private void setPressure(String pressure) {
        Pressure = pressure;
    }

    private String getFlowsize() {
        return Flowsize;
    }

    private void setFlowsize(String flowsize) {
        Flowsize = flowsize;
    }

    private String getWatersupply() {
        return Watersupply;
    }

    private void setWatersupply(String watersupply) {
        Watersupply = watersupply;
    }

    private String getInspectionrecord() {
        return Inspectionrecord;
    }

    private void setInspectionrecord(String inspectionrecord) {
        Inspectionrecord = inspectionrecord;
    }

    private String getFireFightingInstitutions() {
        return FireFightingInstitutions;
    }

    private void setFireFightingInstitutions(String fireFightingInstitutions) {
        FireFightingInstitutions = fireFightingInstitutions;
    }


    public synchronized void set(String Id, String FireHydrant, String FireHydrantAdress, String Longitude, String Latitude, String Road, String PlacementForm, String InterfaceForm, String WaterFrom, String Departments, String PipeNetwork, String Diameter, String Pressure, String Flowsize, String Watersupply, String Inspectionrecord, String FireFightingInstitutions){
        if (flag){
            try{
                super.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.setId(Id);
        this.setFireHydrant(FireHydrant);
        this.setFireHydrantAdress(FireHydrantAdress);
        this.setLongitude(Longitude);
        this.setLatitude(Latitude);
        this.setRoad(Road);
        this.setPlacementForm(PlacementForm);
        this.setInterfaceForm(InterfaceForm);
        this.setWaterFrom(WaterFrom);
        this.setDepartments(Departments);
        this.setPipeNetwork(PipeNetwork);
        this.setDiameter(Diameter);
        this.setPressure(Pressure);
        this.setFlowsize(Flowsize);
        this.setWatersupply(Watersupply);
        this.setInspectionrecord(Inspectionrecord);
        this.setFireFightingInstitutions(FireFightingInstitutions);

        flag = false;
        super.notify();
    }

    public synchronized void get(){
        if (!flag){
            try{
                super.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Id:" + this.getId());
        System.out.println("FireHydran:" + this.getFireHydrant());
        System.out.println("FireHydrantAdress:" + this.getFireHydrantAdress());
        System.out.println("Longitude:" + this.getLongitude());
        System.out.println("Latitude:" + this.getLatitude());
        System.out.println("Road:" + this.getRoad());
        System.out.println("PlacementForm:" + this.getPlacementForm());
        System.out.println("InterfaceForm:" + this.getInterfaceForm());
        System.out.println("WaterFrom:" + this.getWaterFrom());
        System.out.println("Departments:" + this.getDepartments());
        System.out.println("PipeNetwork:" + this.getPipeNetwork());
        System.out.println("Diameter:" + this.getDiameter());
        System.out.println("Pressure:" + this.getPressure());
        System.out.println("Flowsize:" + this.getFlowsize());
        System.out.println("Watersupply:" + this.getWatersupply());
        System.out.println("Inspectionrecord:" + this.getInspectionrecord());
        System.out.println("FireFightingInstitutions:" + this.getFireFightingInstitutions());
        System.out.println("********************************************************************");

        flag = true;
        super.notify();
    }

}
